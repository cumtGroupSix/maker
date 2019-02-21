package cn.cumtmaker.maker.mapper;


import cn.cumtmaker.maker.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;

@Mapper
public interface UserInfoMapper {
    int userSignUpInfo(@Param("userId") int userId, @Param("nickname") String nickname, @Param("enable") Integer enable,
                       @Param("telephone") String telephone,@Param("email") String email, @Param("address") String address,
                       @Param("registrationTime") Timestamp registrationTime, @Param("school") String school);
    UserInfo getUserInfo(int userId);
    int updateUserInfo(@Param("userId") int userId,@Param("enable") Integer enable, @Param("nickname") String nickname, @Param("telephone") String telephone,
                       @Param("email") String email, @Param("address") String address, @Param("school") String school);
}