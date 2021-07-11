package com.cht.dao;

import com.cht.pojo.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleMapper {
    //根据用户名查询所有的角色名，注意，下面为set，最好不要用list
    Set<String> queryAllRolenameByUsername(@Param("username") String username);
}
