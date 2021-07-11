package com.cht.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.Set;

@Repository
public interface RoleService {
    //根据用户名查询所有的角色名
    Set<String> queryAllRolenameByUsername(@Param("username") String username);
}
