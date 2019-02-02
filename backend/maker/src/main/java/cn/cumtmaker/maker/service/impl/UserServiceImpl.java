package cn.cumtmaker.maker.service.impl;

import cn.cumtmaker.maker.VO.UserVO;
import cn.cumtmaker.maker.mapper.MakerInfoMapper;
import cn.cumtmaker.maker.mapper.UserInfoMapper;
import cn.cumtmaker.maker.mapper.UserMapper;
import cn.cumtmaker.maker.model.Cart;
import cn.cumtmaker.maker.model.User;
import cn.cumtmaker.maker.service.UserService;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Timestamp;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    MakerInfoMapper makerInfoMapper;

    private Logger logger= LoggerFactory.getLogger(getClass());

//    注册方法实现
    @Override
    public int userSignUp(String role,String username,String password){
        if(userMapper.getUserByUserName(username)==null) {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String encodePassword = bCryptPasswordEncoder.encode(password);
            userMapper.signUp(role,username, encodePassword);
            logger.info("用户名为"+username+"的"+role+"用户注册成功");
            return 1;
        }
        else{
            return 0;
        }
    }
    //用户注册信息
    @Override
    public int setUserSignUpInfo(String username, String nickname, int enable, String telephone,String email, String address, Timestamp registrationTime, String school){
        int userId=userMapper.getUserByUserName(username).getUserId();
        String role=userMapper.getUserByUserName(username).getRole();
        userInfoMapper.userSignUpInfo(userId,nickname,enable,telephone,email,address,registrationTime,school);
        logger.info("用户名为"+username+"的"+role+"用户添加用户注册信息成功");
        return 1;
    }
    //创客注册信息
    @Override
    public int setMakerSignUpInfo(String username, String storeName, String mobileNumber, String email,
                                  String school, String realName, String studentId, Timestamp registrationTime){
        int userId=userMapper.getUserByUserName(username).getUserId();
        String role=userMapper.getUserByUserName(username).getRole();
        int storeId=userId;
        makerInfoMapper.makerSignUpInfo(userId,storeId,storeName,mobileNumber,email,school,realName,studentId,registrationTime);
        logger.info("用户名为"+username+"的"+role+"用户添加创客注册信息成功");
        return 1;

    }
    //根据用户名返回UserVO
    @Override
    public UserVO getUserByUserName(String username){
        return toUserVO(userMapper.getUserByUserName(username));
    }

    //根据JWT Token 返回User信息
    @Override
    public UserVO getUserByRequest(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        String username= Jwts.parser()
                .setSigningKey("GroupSix")
                .parseClaimsJws(token.replace("Bearer ", ""))
                .getBody()
                .getSubject();
        return toUserVO(userMapper.getUserByUserName(username));
    }

    //修改密码方法实现
    @Override
    public int resetPassword(String username, String oldPassword,String newPassword){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password= userMapper.getUserByUserName(username).getPassword();
        boolean match=bCryptPasswordEncoder.matches(oldPassword,password);
        if(match==true){
            String encodePassword = bCryptPasswordEncoder.encode(newPassword);
            userMapper.resetPassword(username,encodePassword);
            String role=userMapper.getUserByUserName(username).getRole();
            logger.info("用户名为"+username+"的"+role+"用户更改了密码");
            return 1;
        }else{
            return 0;
        }
    }

//将User转化为UserVO
    private UserVO toUserVO(User user){
        UserVO userVO=new UserVO();
        BeanUtils.copyProperties(user,userVO);
        return  userVO;
    }
}
