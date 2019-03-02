package cn.cumtmaker.maker.mapper;

import cn.cumtmaker.maker.model.User;
import cn.cumtmaker.maker.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
   int signUp(@Param("role") String role,@Param("username") String username, @Param("password") String password);
   User getUserByUserName(String username);
   int resetPassword(@Param("username") String username, @Param("password") String password);
   int deleteUser(String username);

   /**
    * 通过用户ID查找用户
    */
   User selectByUserId(Integer userId);
}