package cn.cumtmaker.maker.mapper;

import cn.cumtmaker.maker.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
   int signUp(@Param("username") String username, @Param("password") String password);
   User getUserByUserName(String username);
   int resetPassword(@Param("username") String username, @Param("password") String password);
}