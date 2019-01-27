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

    @Override
    public UserVO getUserByUserName(String username){
        return toUserVO(userMapper.getUserByUserName(username));
    }

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

    private UserVO toUserVO(User user){
        UserVO userVO=new UserVO();
        BeanUtils.copyProperties(user,userVO);
        return  userVO;
    }
}
