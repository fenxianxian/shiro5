package com.cht.service;

import org.apache.ibatis.annotations.Param;


import java.util.Set;


public interface PermissionService {
    //根据用户名查询所有的权限名
    Set<String> queryAllPermissionByUsername(@Param("username") String username);
}
