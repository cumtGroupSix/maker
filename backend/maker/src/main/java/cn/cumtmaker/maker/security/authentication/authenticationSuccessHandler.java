package cn.cumtmaker.maker.security.authentication;

import cn.cumtmaker.maker.VO.UserVO;
import cn.cumtmaker.maker.mapper.UserMapper;
import cn.cumtmaker.maker.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
public class authenticationSuccessHandler implements AuthenticationSuccessHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    UserMapper userMapper;

    //登录成功处理方法重写
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException{

        logger.info("登录成功");

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(objectMapper.writeValueAsString(
                toUserVO(userMapper.getUserByUserName(authentication.getName()))));

        //登录验证成功后，生成JWT的token
        String token = Jwts.builder()
                .setSubject((((org.springframework.security.core.userdetails.User) authentication.getPrincipal()).getUsername()))
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 2 * 1000))
                .signWith(SignatureAlgorithm.HS512, "GroupSix")
                .compact();
        response.addHeader("Authorization", "Bearer " + token);
    }

    private UserVO toUserVO(User user){
        UserVO userVO=new UserVO();
        BeanUtils.copyProperties(user,userVO);
        return  userVO;
    }

}
