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
public class UserController {
    @Autowired
    UserService userService;


    //注册API
    @ResponseBody
    @PostMapping("/userSignUp")
    @ApiOperation(value = "用户注册")
    public ResponseEntity signUp(String role,String username,String password) {
        return ResponseEntity.ok(userService.userSignUp(role,username,password));
    }

    @ResponseBody
    @PostMapping("/userSignUpInfo")
    @ApiOperation(value = "用户注册信息增加")
    public ResponseEntity setUserSignUpInfo(String username, String nickname,Integer enable, String telephone,String email, String address, String school){
        Timestamp registrationTime=Timestamp.valueOf(LocalDateTime.now());
        return ResponseEntity.ok(userService.setUserSignUpInfo(username,nickname,enable,telephone,email,address,registrationTime,school));
    }

    @ResponseBody
    @PostMapping("/makerSignUpInfo")
    @ApiOperation(value = "创客注册信息增加")
    public ResponseEntity setMakerSignUpInfo(String username,String storeName,String mobileNumber,String email,
                                             String school, String realName, String studentId){
        Timestamp registrationTime=Timestamp.valueOf(LocalDateTime.now());
        return ResponseEntity.ok(userService.setMakerSignUpInfo(username,storeName,mobileNumber,email,school,realName,studentId,registrationTime));
    }

    @ResponseBody
    @GetMapping("/get")
    @ApiOperation(value = "根据token获取用户信息")
    public ResponseEntity getByToken(HttpServletRequest request) {
        return ResponseEntity.ok(userService.getUserByRequest(request));
    }

    @ResponseBody
    @PostMapping("/resetPassword")
    @ApiOperation(value = "修改密码")
    public ResponseEntity resetPassword(String username, String oldPassword,String newPassword) {
        return ResponseEntity.ok(userService.resetPassword(username, oldPassword,newPassword));
    }
}
