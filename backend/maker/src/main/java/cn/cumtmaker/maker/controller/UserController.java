package cn.cumtmaker.maker.controller;

import cn.cumtmaker.maker.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RequestMapping(value="api/user",produces = {APPLICATION_JSON_UTF8_VALUE})
@Controller
@Api(value="api/user",tags="UserApi",description="用户登录注册接口")
/**
 * 用户登录注册Controller
 */
public class UserController {
    @Autowired
    UserService userService;


    /**
     * 用户注册API
     * @param role
     * @param username
     * @param password
     * @return 0/1
     */
    @ResponseBody
    @PostMapping("/userSignUp")
    @ApiOperation(value = "用户注册")
    public ResponseEntity signUp(String role,String username,String password) {
        return ResponseEntity.ok(userService.userSignUp(role,username,password));
    }

    /**
     * 用户注册信息增加API
     * @param username
     * @param nickname
     * @param enable
     * @param telephone
     * @param email
     * @param address
     * @param school
     * @return
     */
    @ResponseBody
    @PostMapping("/userSignUpInfo")
    @ApiOperation(value = "用户注册信息增加")
    public ResponseEntity setUserSignUpInfo(String username, String nickname,Integer enable, String telephone,String email, String address, String school){
        Timestamp registrationTime=Timestamp.valueOf(LocalDateTime.now());
        return ResponseEntity.ok(userService.setUserSignUpInfo(username,nickname,enable,telephone,email,address,registrationTime,school));
    }

    /**
     * 创客注册信息增加API
     * @param username
     * @param storeName
     * @param mobileNumber
     * @param email
     * @param school
     * @param realName
     * @param studentId
     * @return 0/1
     */
    @ResponseBody
    @PostMapping("/makerSignUpInfo")
    @ApiOperation(value = "创客注册信息增加")
    public ResponseEntity setMakerSignUpInfo(String username,String storeName,String mobileNumber,String email,
                                             String school, String realName, String studentId){
        Timestamp registrationTime=Timestamp.valueOf(LocalDateTime.now());
        return ResponseEntity.ok(userService.setMakerSignUpInfo(username,storeName,mobileNumber,email,school,realName,studentId,registrationTime));
    }

    /**根据token获取用户信息
     *
     * @param request
     * @return USER
     */
    @ResponseBody
    @GetMapping("/get")
    @ApiOperation(value = "根据token获取用户信息")
    public ResponseEntity getByToken(HttpServletRequest request) {
        return ResponseEntity.ok(userService.getUserByRequest(request));
    }

    /**
     * 修改密码API
     * @param username
     * @param oldPassword
     * @param newPassword
     * @return 0/1
     */
    @ResponseBody
    @PostMapping("/resetPassword")
    @ApiOperation(value = "修改密码")
    public ResponseEntity resetPassword(String username, String oldPassword,String newPassword) {
        return ResponseEntity.ok(userService.resetPassword(username, oldPassword,newPassword));
    }

    /**
     * 找回密码API
     * @param username
     * @param newPassword
     * @return 0/1
     */
    @ResponseBody
    @PostMapping("/findPassword")
    @ApiOperation(value = "找回密码")
    public ResponseEntity findPassword(String username,String newPassword) {
        return ResponseEntity.ok(userService.findPassword(username,newPassword));
    }

    /**
     * USER信息获取(用户自身权限)API
     * @param httpServletRequest
     * @return UserInfo
     */
    @ResponseBody
    @GetMapping("/userInfo")
    @ApiOperation(value = "USER信息获取(用户自身权限)")
    public ResponseEntity getUserInfo(HttpServletRequest httpServletRequest){
        return ResponseEntity.ok(userService.getUserInfoByUser(httpServletRequest));
    }

    /**
     * USER信息修改(用户自身权限)
     * @param httpServletRequest
     * @param username
     * @param enable
     * @param nickname
     * @param telephone
     * @param email
     * @param address
     * @param school
     * @return 0/1
     */
    @ResponseBody
    @PostMapping("/updateUserInfo")
    @ApiOperation(value = "USER信息修改(用户自身权限)")
    public ResponseEntity updateUserInfo(HttpServletRequest httpServletRequest,String username, Integer enable,String nickname,String telephone,
                                         String email,String address,String school){
        return ResponseEntity.ok(userService.updateUserInfoByUser(httpServletRequest,username,enable,nickname,telephone,email,address,school));
    }

    /**
     * 通过用户ID查找用户
     * @param userId
     * @return userInfo
     */
    @ResponseBody
    @GetMapping("/selectByUserId/{userId}")
    @ApiOperation(value = "通过用户ID查找用户")
    public ResponseEntity selectByUserId(@PathVariable("userId") Integer userId){
        return ResponseEntity.ok(userService.selectByUserId(userId));
    }
}
