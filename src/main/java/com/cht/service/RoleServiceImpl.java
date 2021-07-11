package com.cht.service;

import com.cht.dao.RoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{

    @Resource
    private RoleMapper roleMapper;

    @Override
    public Set<String> queryAllRolenameByUsername(String username) {
        return roleMapper.queryAllRolenameByUsername(username);
    }
}
