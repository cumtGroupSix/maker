package cn.cumtmaker.maker.service.impl;

import cn.cumtmaker.maker.VO.UserInfoVO;
import cn.cumtmaker.maker.VO.UserVO;
import cn.cumtmaker.maker.mapper.MakerInfoMapper;
import cn.cumtmaker.maker.mapper.UserInfoMapper;
import cn.cumtmaker.maker.mapper.UserMapper;
import cn.cumtmaker.maker.model.MakerInfo;
import cn.cumtmaker.maker.model.User;
import cn.cumtmaker.maker.model.UserInfo;
import cn.cumtmaker.maker.service.UserService;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    MakerInfoMapper makerInfoMapper;

    @Autowired
    JavaMailSender jms;

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
    public int setUserSignUpInfo(String username, String nickname, Integer enable, String telephone,String email, String address, Timestamp registrationTime, String school){
        int userId=userMapper.getUserByUserName(username).getUserId();
        String role=userMapper.getUserByUserName(username).getRole();
        userInfoMapper.userSignUpInfo(userId,nickname,enable,telephone,email,address,registrationTime,school);
        logger.info("用户名为"+username+"的"+role+"用户添加用户注册信息成功");
        return 1;
    }

    //用户获取USER信息
    @Override
    public UserInfo getUserInfoByUser(HttpServletRequest httpServletRequest){
        //根据请求头获取UserVO
        UserVO userVO = getUserByRequest(httpServletRequest);
        logger.info("用户" + userVO.getUsername() + "查询了自己的USER信息");
        return  userInfoMapper.getUserInfo(userVO.getUserId());
    }

    //用户更新USER信息
    @Override
    public int updateUserInfoByUser(HttpServletRequest httpServletRequest,String username, Integer enable,String nickname,String telephone,
                                    String email,String address,String school){
        //根据请求头获取UserVO
        UserVO userVO = getUserByRequest(httpServletRequest);
        if (userVO != null && userVO.getUsername().equals(username)) {
            //认证信息是用户本人
            Integer userId = userVO.getUserId();
            int code = userInfoMapper.updateUserInfo(userId,enable,nickname,telephone,email,address,school);
            if (code == 1)
                logger.info("用户" + username + "更改了自己的信息");
            return code;
        }

        return 0;
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

    //邮箱发送验证码
    @Override
    public int sendEmail(String sender,String username,String title,String text){
        //建立邮件消息
        SimpleMailMessage mainMessage = new SimpleMailMessage();
        //发送者
        mainMessage.setFrom(sender);
        //验证用户角色
        String role = getUserByUserName(username).getRole();
        if(role.equals("USER")){
            String receiver=getUserInfo(username).getEmail();
            mainMessage.setTo(receiver);
            logger.info("邮件接收者 -- "+receiver);
        }else if(role.equals("MAKER")){
            String receiver=getMakerInfo(username).getEmail();
            mainMessage.setTo(receiver);
            logger.info("邮件接收者 -- "+receiver);
        }else{
            return 0;
        }
        //发送的标题
        mainMessage.setSubject(title);
        //发送的内容
        mainMessage.setText(text);
        jms.send(mainMessage);
        return 1;
    }

    //管理员根据username删除用户
    @Override
    public int deleteUser(HttpServletRequest httpServletRequest,String username){
        String token = httpServletRequest.getHeader("Authorization");
        if (token != null) {
            String adminname = getUserByRequest(httpServletRequest).getUsername();
            String role = getUserByUserName(username).getRole();
            //判断操作用户不是管理员
            if (!role.equals("ADMIN")) {
                int code = userMapper.deleteUser(username);
                if (code == 1) {
                    logger.info("管理员" + adminname + "删除了一个" + role + "用户:" + username);
                }
                return code;
            } else {
                return 0;
            }
        }else{
            return  0;
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
        if (token != null){
            String username= Jwts.parser()
                    .setSigningKey("GroupSix")
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .getBody()
                    .getSubject();
            return toUserVO(userMapper.getUserByUserName(username));
        }else{
            return null;
        }

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

    //找回密码方法实现
    @Override
    public int findPassword(String username,String newPassword){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String encodePassword = bCryptPasswordEncoder.encode(newPassword);
            int code=userMapper.resetPassword(username,encodePassword);
            if(code==1){
                String role=userMapper.getUserByUserName(username).getRole();
                logger.info("用户名为"+username+"的"+role+"用户重新找回了密码");
            }
            return code;
    }

//管理员修改用户密码
    @Override
    public int adminResetPassword(HttpServletRequest httpServletRequest,String username,String newPassword){
        String token = httpServletRequest.getHeader("Authorization");
        if (token != null) {
            String adminname = getUserByRequest(httpServletRequest).getUsername();
            String role = getUserByUserName(username).getRole();
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String encodePassword = bCryptPasswordEncoder.encode(newPassword);
            //判断操作用户不是管理员
            if(!role.equals("ADMIN")){
                int code=userMapper.resetPassword(username,encodePassword);
                if(code==1){
                    logger.info("管理员："+adminname+"更改了"+ role + "用户:"+username+"的密码");
                }
                return code;
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }
    //管理员获取USER信息
    @Override
    public UserInfo getUserInfo(String username){
        Integer userId=getUserByUserName(username).getUserId();
        return  userInfoMapper.getUserInfo(userId);
    }

    @Override
    public List<UserInfoVO> getAllUser(){
        List<UserInfo> list=userInfoMapper.getAllUser();
        return toUserInfoVO(list);
    }

    //管理员获取MAKER信息
    @Override
    public MakerInfo getMakerInfo(String username){
        Integer userId=getUserByUserName(username).getUserId();
        return  makerInfoMapper.getMakerInfo(userId);
    }

    //管理员更新USER信息
    @Override
    public int updateUserInfo(HttpServletRequest httpServletRequest,String username, Integer enable,String nickname,String telephone,
                       String email,String address,String school){
        String token = httpServletRequest.getHeader("Authorization");
        if (token != null) {
            String adminname = getUserByRequest(httpServletRequest).getUsername();
            Integer userId=getUserByUserName(username).getUserId();
            String role = getUserByUserName(username).getRole();
            //判断操作用户不是管理员
            if (!role.equals("ADMIN")) {
                int code=userInfoMapper.updateUserInfo(userId,enable,nickname,telephone,email,address,school);
                if(code==1){
                    logger.info("管理员："+adminname+"更改了"+ role + "用户:"+username+"的信息");
                }
                return code;
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }

    //管理员更新MAKER信息
    @Override
    public int updateMakerInfo(HttpServletRequest httpServletRequest,String username,
                        String storeName,String mobileNumber, String email,
                        String school, String realName,String studentId){
        String token = httpServletRequest.getHeader("Authorization");
        if (token != null) {
            String adminname = getUserByRequest(httpServletRequest).getUsername();
            Integer userId=getUserByUserName(username).getUserId();
            String role = getUserByUserName(username).getRole();
            //判断操作用户不是管理员
            if (!role.equals("ADMIN")) {
                int code=makerInfoMapper.updateMakerInfo(userId,storeName,mobileNumber,email,school,realName,studentId);
                if(code==1){
                    logger.info("管理员："+adminname+"更改了"+ role + "用户:"+username+"的信息");
                }
                return code;
            }else{
                return 0;
            }
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
    //将UserInfo转化为UserInfoVO
    private List<UserInfoVO> toUserInfoVO(List<UserInfo> userInfoList){
        List<UserInfoVO> list=new ArrayList<>();
        for(UserInfo userInfo :userInfoList){
            UserInfoVO userInfoVO=new UserInfoVO();
            String username=userMapper.selectByUserId(userInfo.getUserId()).getUsername();
            BeanUtils.copyProperties(userInfo,userInfoVO);
            //转化时间格式
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Timestamp timestamp=new Timestamp(userInfo.getRegistrationTime().getTime()+8*3600*1000);
            Date date=new Date(timestamp.getTime());
            String time=simpleDateFormat.format(date);
            //调用userInfoVO的set方法
            userInfoVO.setRegistrationTime(time);
            userInfoVO.setUsername(username);
            list.add(userInfoVO);
        }
        return list;

    }

    //    通过用户ID查找用户
    public User selectByUserId(Integer userId){
        return userMapper.selectByUserId(userId);
    }
}
