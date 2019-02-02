package cn.cumtmaker.maker.service;


import cn.cumtmaker.maker.VO.UserVO;
import cn.cumtmaker.maker.model.User;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Timestamp;

public interface UserService {
    int userSignUp(String role,String username,String password);
    UserVO getUserByUserName(String username);
    UserVO getUserByRequest(HttpServletRequest request);
    int resetPassword(String username, String oldPassword,String newPassword);
    int setUserSignUpInfo(String username, String nickname, int enable,String telephone,String email,
                          String address, Timestamp registrationTime,String school);
    int setMakerSignUpInfo(String username, String storeName, String mobileNumber, String email,
                           String school, String realName, String studentId, Timestamp registrationTime);
}
