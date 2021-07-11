package com.cht.service;

import com.cht.dao.PermissionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.Set;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;
    @Override
    public Set<String> queryAllPermissionByUsername(String username) {
        return permissionMapper.queryAllPermissionByUsername(username);
    }
}
