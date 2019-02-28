package cn.cumtmaker.maker.service;


import cn.cumtmaker.maker.VO.UserVO;
import cn.cumtmaker.maker.model.MakerInfo;
import cn.cumtmaker.maker.model.User;
import cn.cumtmaker.maker.model.UserInfo;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Timestamp;

public interface UserService {
    int userSignUp(String role,String username,String password);
    UserVO getUserByUserName(String username);
    UserVO getUserByRequest(HttpServletRequest request);
    int resetPassword(String username, String oldPassword,String newPassword);
    int adminResetPassword(HttpServletRequest httpServletRequest,String username,String newPassword);
    int setUserSignUpInfo(String username, String nickname, Integer enable,String telephone,String email,
                          String address, Timestamp registrationTime,String school);
    int setMakerSignUpInfo(String username, String storeName, String mobileNumber, String email,
                           String school, String realName, String studentId, Timestamp registrationTime);
    int deleteUser(HttpServletRequest httpServletRequest,String username);
    UserInfo getUserInfo(String username);
    MakerInfo getMakerInfo(String username);
    int updateUserInfo(HttpServletRequest httpServletRequest,String username,Integer enable, String nickname,String telephone,
                       String email,String address,String school);
    int updateMakerInfo(HttpServletRequest httpServletRequest,String username,
                        String storeName,String mobileNumber, String email,
                        String school, String realName,String studentId);
    int updateUserInfoByUser(HttpServletRequest httpServletRequest,String username, Integer enable,String nickname,String telephone,
                             String email,String address,String school);
    UserInfo getUserInfoByUser(HttpServletRequest httpServletRequest);
    int sendEmail(String sender,String username,String title,String text);
    int findPassword(String username,String newPassword);

    //    通过用户ID查找用户
    User selectByUserId(Integer userId);
}
