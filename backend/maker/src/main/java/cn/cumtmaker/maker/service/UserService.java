package cn.cumtmaker.maker.service;


import cn.cumtmaker.maker.VO.UserVO;
import cn.cumtmaker.maker.model.User;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    //用户注册方法
    int signUp(String username,String password);
    UserVO getUserByUserName(String username);
    UserVO getUserByRequest(HttpServletRequest request);
    int resetPassword(String username, String oldPassword,String newPassword);
}
