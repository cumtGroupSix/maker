package cn.cumtmaker.maker.service.impl;

import cn.cumtmaker.maker.mapper.UserMapper;
import cn.cumtmaker.maker.model.Cart;
import cn.cumtmaker.maker.model.User;
import cn.cumtmaker.maker.service.UserService;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int signUp(String username,String password){
        if(userMapper.getUserByUserName(username)==null) {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String longPassword = bCryptPasswordEncoder.encode(password);
            return userMapper.signUp(username, longPassword);
        }
        else{
            return 0;
        }
    }

    @Override
    public User getUserByUserName(String username){
        return userMapper.getUserByUserName(username);
    }

    @Override
    public int getUserIdByRequest(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        String username= Jwts.parser()
                .setSigningKey("GroupSix")
                .parseClaimsJws(token.replace("Bearer ", ""))
                .getBody()
                .getSubject();
        int userid=userMapper.getUserByUserName(username).getUserId();
        return userid;
    }
}
