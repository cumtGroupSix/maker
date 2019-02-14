package cn.cumtmaker.maker.controller;

import cn.cumtmaker.maker.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RequestMapping(value="api/admin",produces = {APPLICATION_JSON_UTF8_VALUE})
@Controller
@Api(value="api/admin",tags="AdminApi",description="管理员接口")
public class AdminController {
    @Autowired
    UserService userService;


    //注册API
    @ResponseBody
    @PostMapping("/userSignUp")
    @ApiOperation(value = "用户注册(管理员权限)")
    public ResponseEntity signUp(String role,String username,String password) {
        return ResponseEntity.ok(userService.userSignUp(role,username,password));
    }

    @ResponseBody
    @PostMapping("/userSignUpInfo")
    @ApiOperation(value = "用户注册信息增加(管理员权限)")
    public ResponseEntity setUserSignUpInfo(String username, String nickname, int enable, String telephone,String email, String address, String school){
        Timestamp registrationTime=Timestamp.valueOf(LocalDateTime.now());
        return ResponseEntity.ok(userService.setUserSignUpInfo(username,nickname,enable,telephone,email,address,registrationTime,school));
    }

    @ResponseBody
    @PostMapping("/makerSignUpInfo")
    @ApiOperation(value = "创客注册信息增加(管理员权限)")
    public ResponseEntity setMakerSignUpInfo(String username,String storeName,String mobileNumber,String email,
                                             String school, String realName, String studentId){
        Timestamp registrationTime=Timestamp.valueOf(LocalDateTime.now());
        return ResponseEntity.ok(userService.setMakerSignUpInfo(username,storeName,mobileNumber,email,school,realName,studentId,registrationTime));
    }

    @ResponseBody
    @DeleteMapping("/deleteUser")
    @ApiOperation(value = "删除用户(管理员权限)")
    public ResponseEntity deleteUser(HttpServletRequest httpServletRequest,String username) {
        return ResponseEntity.ok(userService.deleteUser(httpServletRequest,username));
    }

    @ResponseBody
    @PostMapping("/resetPassword")
    @ApiOperation(value = "修改密码(管理员权限)")
    public ResponseEntity resetPassword(HttpServletRequest httpServletRequest,String username,String newPassword) {
        return ResponseEntity.ok(userService.adminResetPassword(httpServletRequest,username,newPassword));
    }

    @ResponseBody
    @GetMapping("/getByUserName")
    @ApiOperation(value = "根据username获取用户信息(管理员权限)")
    public ResponseEntity getByUserName(String username) {
        return ResponseEntity.ok(userService.getUserByUserName(username));
    }

    @ResponseBody
    @GetMapping("/getUserInfoByUserName")
    @ApiOperation(value = "根据username获取USER信息(管理员权限)")
    public ResponseEntity getUserInfoByUserName(String username) {
        return ResponseEntity.ok(userService.getUserInfo(username));
    }

    @ResponseBody
    @GetMapping("/getMakerInfoByUserName")
    @ApiOperation(value = "根据username获取Maker信息(管理员权限)")
    public ResponseEntity getMakerInfoByUserName(String username) {
        return ResponseEntity.ok(userService.getMakerInfo(username));
    }

    @ResponseBody
    @PostMapping("/updateUserInfo")
    @ApiOperation(value = "USER信息修改(管理员权限)")
    public ResponseEntity updateUserInfo(HttpServletRequest httpServletRequest,String username, Integer enable,String nickname,String telephone,
                                         String email,String address,String school){
        return ResponseEntity.ok(userService.updateUserInfo(httpServletRequest,username,enable,nickname,telephone,email,address,school));
    }

    @ResponseBody
    @PostMapping("/updateMakerInfo")
    @ApiOperation(value = "Maker信息修改(管理员权限)")
    public ResponseEntity updateMakerInfo(HttpServletRequest httpServletRequest,String username,
                                          String storeName,String mobileNumber, String email,
                                          String school, String realName,String studentId){
        return ResponseEntity.ok(userService.updateMakerInfo(httpServletRequest,username,storeName,mobileNumber,email,school,realName,studentId));
    }


}
