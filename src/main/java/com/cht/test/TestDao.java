package com.cht.test;

import com.cht.dao.PermissionMapper;
import com.cht.dao.RoleMapper;
import com.cht.dao.UserMapper;
import com.cht.pojo.Role;
import com.cht.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Set;

public class TestDao {
    //测试方法
    @Test
    public void testDao(){
       /* ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        User user = userMapper.queryUserByUsername("小飞老师");
        RoleMapper roleMapper = context.getBean("roleMapper", RoleMapper.class);
        Set<String> roles = roleMapper.queryAllRolenameByUsername("小飞老师");
        PermissionMapper permissionMapper = context.getBean("permissionMapper", PermissionMapper.class);
        Set<String> permissions = permissionMapper.queryAllPermissionByUsername("小飞老师");
        System.out.println(user);
        System.out.println(roles);
        System.out.println(permissions);*/
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(context);

    }

}
