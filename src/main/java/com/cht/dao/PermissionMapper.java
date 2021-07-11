package com.cht.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PermissionMapper {
    //根据用户名查询所有的权限名
    Set<String> queryAllPermissionByUsername(@Param("username") String username);
}
