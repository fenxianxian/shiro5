package com.cht.dao;

import com.cht.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
     User queryUserByUsername(@Param("username") String username);

     Integer insertUser(User user);
}
