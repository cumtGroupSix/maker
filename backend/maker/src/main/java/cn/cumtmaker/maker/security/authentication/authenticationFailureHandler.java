package cn.cumtmaker.maker.security.authentication;

import cn.cumtmaker.maker.VO.UserVO;
import cn.cumtmaker.maker.mapper.UserMapper;
import cn.cumtmaker.maker.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class authenticationFailureHandler implements AuthenticationFailureHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ObjectMapper objectMapper;

    //登录失败处理方法重写
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException{

        logger.info("登录失败");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(objectMapper.writeValueAsString("登录失败"));
    }

}
