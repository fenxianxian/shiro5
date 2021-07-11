package com.cht.test;

import com.cht.dao.UserMapper;
import com.cht.pojo.User;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

public class JiaMiTest {
    public static void main(String[] args) {
        String pwd = "1234";
        String salt = UUID.randomUUID().toString();//盐
        //将密码用md5加密，并加上盐，最后迭代1000次，最终加密出来的结果再转为Base64，就是最终的密文了
        String s = new Md5Hash(pwd, salt, 1000).toBase64();//或者是toString()
        System.out.println(s);
    }

    @Test
    public void zhuche(){
        /*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        User user = new User(null,"陈功","ab123");
        userMapper.insertUser(user);*/
    }
}
