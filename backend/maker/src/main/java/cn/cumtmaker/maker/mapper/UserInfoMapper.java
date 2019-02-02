package cn.cumtmaker.maker.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;

@Mapper
public interface UserInfoMapper {
    int userSignUpInfo(@Param("userId") int userId, @Param("nickname") String nickname, @Param("enable") int enable,
                       @Param("telephone") String telephone,@Param("email") String email, @Param("address") String address,
                       @Param("registrationTime") Timestamp registrationTime, @Param("school") String school);
}