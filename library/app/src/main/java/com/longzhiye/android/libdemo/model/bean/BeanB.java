package com.longzhiye.android.libdemo.model.bean;

/**
 * Author: longzhiye
 * Date: 16-5-26
 * Time: 17:54
 */
public class BeanB {


    private int comment_num;
    private int is_attention;
    private int invest_type;
    private int sign_coin;
    private String avatar;
    private int type;
    private int fans;
    private int is_signed;
    private int praise_num;
    private String name;
    private int id;
    private String tag;
    private String skilled_field;

    public int getComment_num() {
        return comment_num;
    }

    public void setComment_num(int comment_num) {
        this.comment_num = comment_num;
    }

    public int getIs_attention() {
        return is_attention;
    }

    public void setIs_attention(int is_attention) {
        this.is_attention = is_attention;
    }

    public int getInvest_type() {
        return invest_type;
    }

    public void setInvest_type(int invest_type) {
        this.invest_type = invest_type;
    }

    public int getSign_coin() {
        return sign_coin;
    }

    public void setSign_coin(int sign_coin) {
        this.sign_coin = sign_coin;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public int getIs_signed() {
        return is_signed;
    }

    public void setIs_signed(int is_signed) {
        this.is_signed = is_signed;
    }

    public int getPraise_num() {
        return praise_num;
    }

    public void setPraise_num(int praise_num) {
        this.praise_num = praise_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSkilled_field() {
        return skilled_field;
    }

    public void setSkilled_field(String skilled_field) {
        this.skilled_field = skilled_field;
    }

    @Override
    public String toString() {
        return "BeanB{" +
                "comment_num=" + comment_num +
                ", is_attention=" + is_attention +
                ", invest_type=" + invest_type +
                ", sign_coin=" + sign_coin +
                ", avatar='" + avatar + '\'' +
                ", type=" + type +
                ", fans=" + fans +
                ", is_signed=" + is_signed +
                ", praise_num=" + praise_num +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", tag='" + tag + '\'' +
                ", skilled_field='" + skilled_field + '\'' +
                '}';
    }
}
