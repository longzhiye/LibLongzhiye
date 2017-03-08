package com.longzhiye.android.libdemo.model.bean;

/**
 * Author: longzhiye
 * Date: 16-5-26
 * Time: 16:39
 */
public class BeanA {

    private double user_coin;
    private String sign_remark;
    private String level_name;
    private String gender;
    private String avatar_url;
    private int user_id;
    private String nickname;
    private int sign_limit;
    private String slogan;
    private String token;

    public double getUser_coin() {
        return user_coin;
    }

    public void setUser_coin(double user_coin) {
        this.user_coin = user_coin;
    }

    public String getSign_remark() {
        return sign_remark;
    }

    public void setSign_remark(String sign_remark) {
        this.sign_remark = sign_remark;
    }

    public String getLevel_name() {
        return level_name;
    }

    public void setLevel_name(String level_name) {
        this.level_name = level_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getSign_limit() {
        return sign_limit;
    }

    public void setSign_limit(int sign_limit) {
        this.sign_limit = sign_limit;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "BeanA{" +
                "user_coin=" + user_coin +
                ", sign_remark='" + sign_remark + '\'' +
                ", level_name='" + level_name + '\'' +
                ", gender='" + gender + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                ", user_id=" + user_id +
                ", nickname='" + nickname + '\'' +
                ", sign_limit=" + sign_limit +
                ", slogan='" + slogan + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
