package cn.cumtmaker.maker.security;

import cn.cumtmaker.maker.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Logger logger= LoggerFactory.getLogger(getClass());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        String role=userMapper.getUserByUserName(username).getRole();
        logger.info("用户名为"+username+"的"+role+"用户尝试登录");
       UserDetails userDetails= new User(username,userMapper.getUserByUserName(username).getPassword(), getRole(username));
       return userDetails;
    }

    private List<GrantedAuthority>  getRole(String username){
        String role=userMapper.getUserByUserName(username).getRole();
        List<GrantedAuthority> list =new ArrayList<GrantedAuthority>();
        list.add(new SimpleGrantedAuthority("ROLE_"+role));
        return list;
    }
}
