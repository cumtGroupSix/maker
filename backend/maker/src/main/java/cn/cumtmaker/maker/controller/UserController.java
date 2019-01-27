package cn.cumtmaker.maker.controller;

import cn.cumtmaker.maker.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RequestMapping(value="api/user",produces = {APPLICATION_JSON_UTF8_VALUE})
@Controller
@Api(value="api/user",tags="UserApi",description="用户登录注册接口")
public class UserController {
    @Autowired
    UserService userService;


    //注册
    @ResponseBody
    @PostMapping("/signup")
    @ApiOperation(value = "用户注册")
    public ResponseEntity signUp(String username,String password) {
        return ResponseEntity.ok(userService.signUp(username,password));
    }

    @ResponseBody
    @GetMapping("/get")
    @ApiOperation(value = "根据token获取")
    public ResponseEntity getByToken(HttpServletRequest request) {
        return ResponseEntity.ok(userService.getUserByRequest(request));
    }

    @ResponseBody
    @GetMapping("/getByUserName")
    @ApiOperation(value = "根据username获取")
    public ResponseEntity getByUserName(String username) {
        return ResponseEntity.ok(userService.getUserByUserName(username));
    }
}
