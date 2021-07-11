package com.cht.service;

import com.cht.dao.UserMapper;
import com.cht.pojo.User;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Override
    public User queryUserByUsername(String username) {
        return userMapper.queryUserByUsername(username);
    }

    @Override
    public Integer insertUser(User user) {
        String salt = UUID.randomUUID().toString();
        String pwd = new Sha256Hash(user.getPassword(), salt, 1000).toBase64();
        user.setPassword(pwd);
        user.setSalt(salt);
        return userMapper.insertUser(user);
    }
}
