package cn.cumtmaker.maker.security.validate;

import org.springframework.security.core.AuthenticationException;

    // 验证码错误异常，继承spring security的认证异常

public class ValidateCodeException extends AuthenticationException {
    private static final long serialVersionUID = 1L;
    public ValidateCodeException(String msg) {
        super(msg);
    }
}