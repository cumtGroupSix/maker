package cn.cumtmaker.maker.service.impl;

import cn.cumtmaker.maker.VO.UserVO;
import cn.cumtmaker.maker.mapper.UserMapper;
import cn.cumtmaker.maker.model.Cart;
import cn.cumtmaker.maker.model.User;
import cn.cumtmaker.maker.service.UserService;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

//    注册方法实现
    @Override
    public int signUp(String username,String password){
        if(userMapper.getUserByUserName(username)==null) {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String encodePassword = bCryptPasswordEncoder.encode(password);
            return userMapper.signUp(username, encodePassword);
        }
        else{
            return 0;
        }
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
