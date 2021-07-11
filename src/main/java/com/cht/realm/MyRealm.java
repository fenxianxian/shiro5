package com.cht.realm;

import com.cht.pojo.User;
import com.cht.service.PermissionService;
import com.cht.service.RoleService;
import com.cht.service.UserService;
import lombok.Setter;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

import java.util.Set;

//自定义Realm
//Realm的职责就是为shiro加载用户，角色和权限数据，供内部校验使用，现在既然库中有数据了，就需要用自定义的Realm去加载。所以现在我们就自己建一个自定义的Realm类吧
//以下两个方法不是我们来调，而是securityManager需要数据时自动来调用
@Setter
@Component
public class MyRealm extends AuthorizingRealm {

    private UserService userService;
    private RoleService roleService;
    private PermissionService permissionService;

    //做权限，角色校验
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("进行权限，角色验证。。。");
        //获取用户名
        String username = (String) principalCollection.getPrimaryPrincipal();
        //根据用户名查询权限和角色信息(这里注意一下，因为我此处是根据用户名去查询，所以我们得要求用户名是唯一的)
        //RoleService roleService
               // = ContextLoader.getCurrentWebApplicationContext().getBean("roleServiceImpl", RoleService.class);
       // PermissionService permissionService
         //       = ContextLoader.getCurrentWebApplicationContext().getBean("permissionServiceImpl", PermissionService.class);
        Set<String> roles = roleService.queryAllRolenameByUsername(username);
        Set<String> permissions = permissionService.queryAllPermissionByUsername(username);
        //将查询出来的数据封装成AuthorizationInfo
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(roles);
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    //做身份认证(查用户名，密码的)
    //何时触发：subject.login(token);
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("进行身份认证。。。");
        //根据传进来的令牌token，获取用户名
        String username = (String) authenticationToken.getPrincipal();
        //查询用户信息
       // UserService userService
         //       = ContextLoader.getCurrentWebApplicationContext().getBean("userServiceImpl", UserService.class);
        //查询到用户信息
        User user = userService.queryUserByUsername(username);
        //判断用户身份为空
        if(user==null){ //如果为空
            return null; //后续会抛出异常，也就是所谓的UnKnownAccountException
        }
        //将用户信息封装在AuthenticationInfo对象中
        //第一个参数：数据库里的用户名  第二个参数：数据库里的密码 第三个参数：可以不太在意，可以理解为当前realm的标识，名字
        SimpleAuthenticationInfo info
                = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), ByteSource.Util.bytes(user.getSalt()),this.getName());
        return info;
    }
}
