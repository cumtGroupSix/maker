package cn.cumtmaker.maker.VO;

import java.sql.Timestamp;

public class UserInfoVO {
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 是否可用
     */
    private Boolean enable;

    /**
     * 电话号码
     */
    private String telephone;

    /**
     * 地址
     */
    private String address;


    public String getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(String registrationTime) {
        this.registrationTime = registrationTime;
    }

    /**
     * 注册时间
     */
    private String registrationTime;

    /**
     * 学校名称
     */
    private String school;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取昵称
     *
     * @return nickname - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取是否可用
     *
     * @return enable - 是否可用
     */
    public Boolean getEnable() {
        return enable;
    }

    /**
     * 设置是否可用
     *
     * @param enable 是否可用
     */
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    /**
     * 获取电话号码
     *
     * @return telephone - 电话号码
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置电话号码
     *
     * @param telephone 电话号码
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取注册时间
     *
     * @return registration_time - 注册时间
     */

    /**
     * 设置注册时间
     *
     * @param registrationTime 注册时间
     */

    /**
     * 获取学校名称
     *
     * @return school - 学校名称
     */
    public String getSchool() {
        return school;
    }

    /**
     * 设置学校名称
     *
     * @param school 学校名称
     */
    public void setSchool(String school) {
        this.school = school;
    }

//    public void setRegistrationTime(Timestamp registrationTime) {
//        this.registrationTime = registrationTime;
//    }
//
//    public Timestamp getRegistrationTime() {
//        return registrationTime;
//    }
}