package com.longzhiye.android.libdemo.model.bean;

import java.util.List;

/**
 * Author: longzhiye
 * Date: 16-5-27
 * Time: 15:05
 */
public class BeanC {

    private List<InvestLectureBean> invest_lecture;
    private List<ViewpointBean> viewpoint;
    private List<AdvTeacherBean> adv_teacher;
    private List<AdviserBean> adviser;

    public List<InvestLectureBean> getInvest_lecture() {
        return invest_lecture;
    }

    public void setInvest_lecture(List<InvestLectureBean> invest_lecture) {
        this.invest_lecture = invest_lecture;
    }

    public List<ViewpointBean> getViewpoint() {
        return viewpoint;
    }

    public void setViewpoint(List<ViewpointBean> viewpoint) {
        this.viewpoint = viewpoint;
    }

    public List<AdvTeacherBean> getAdv_teacher() {
        return adv_teacher;
    }

    public void setAdv_teacher(List<AdvTeacherBean> adv_teacher) {
        this.adv_teacher = adv_teacher;
    }

    public List<AdviserBean> getAdviser() {
        return adviser;
    }

    public void setAdviser(List<AdviserBean> adviser) {
        this.adviser = adviser;
    }

    public static class InvestLectureBean {
        private String cover;
        private int view_num;
        private int can_read;
        private int invest_id;
        private double sign_fee;
        private int id;
        private String title;
        private int type;
        private int is_sign;
        private int priase_num;
        private double coin;
        private String invest_name;

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int getView_num() {
            return view_num;
        }

        public void setView_num(int view_num) {
            this.view_num = view_num;
        }

        public int getCan_read() {
            return can_read;
        }

        public void setCan_read(int can_read) {
            this.can_read = can_read;
        }

        public int getInvest_id() {
            return invest_id;
        }

        public void setInvest_id(int invest_id) {
            this.invest_id = invest_id;
        }

        public double getSign_fee() {
            return sign_fee;
        }

        public void setSign_fee(double sign_fee) {
            this.sign_fee = sign_fee;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getIs_sign() {
            return is_sign;
        }

        public void setIs_sign(int is_sign) {
            this.is_sign = is_sign;
        }

        public int getPriase_num() {
            return priase_num;
        }

        public void setPriase_num(int priase_num) {
            this.priase_num = priase_num;
        }

        public double getCoin() {
            return coin;
        }

        public void setCoin(double coin) {
            this.coin = coin;
        }

        public String getInvest_name() {
            return invest_name;
        }

        public void setInvest_name(String invest_name) {
            this.invest_name = invest_name;
        }

        @Override
        public String toString() {
            return "InvestLectureBean{" +
                    "cover='" + cover + '\'' +
                    ", view_num=" + view_num +
                    ", can_read=" + can_read +
                    ", invest_id=" + invest_id +
                    ", sign_fee=" + sign_fee +
                    ", id=" + id +
                    ", title='" + title + '\'' +
                    ", type=" + type +
                    ", is_sign=" + is_sign +
                    ", priase_num=" + priase_num +
                    ", coin=" + coin +
                    ", invest_name='" + invest_name + '\'' +
                    '}';
        }
    }

    public static class ViewpointBean {
        private int view_num;
        private int comment_num;
        private String user_avatar;
        private String create_time;
        private int user_id;
        private String user_name;
        private String section_name;
        private int id;
        private String title;
        private String content;
        private int priase_num;

        public int getView_num() {
            return view_num;
        }

        public void setView_num(int view_num) {
            this.view_num = view_num;
        }

        public int getComment_num() {
            return comment_num;
        }

        public void setComment_num(int comment_num) {
            this.comment_num = comment_num;
        }

        public String getUser_avatar() {
            return user_avatar;
        }

        public void setUser_avatar(String user_avatar) {
            this.user_avatar = user_avatar;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getSection_name() {
            return section_name;
        }

        public void setSection_name(String section_name) {
            this.section_name = section_name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getPriase_num() {
            return priase_num;
        }

        public void setPriase_num(int priase_num) {
            this.priase_num = priase_num;
        }

        @Override
        public String toString() {
            return "ViewpointBean{" +
                    "view_num=" + view_num +
                    ", comment_num=" + comment_num +
                    ", user_avatar='" + user_avatar + '\'' +
                    ", create_time='" + create_time + '\'' +
                    ", user_id=" + user_id +
                    ", user_name='" + user_name + '\'' +
                    ", section_name='" + section_name + '\'' +
                    ", id=" + id +
                    ", title='" + title + '\'' +
                    ", content='" + content + '\'' +
                    ", priase_num=" + priase_num +
                    '}';
        }
    }

    public static class AdvTeacherBean {
        private int teach_id;
        private String teach_avatar;
        private int id;

        public int getTeach_id() {
            return teach_id;
        }

        public void setTeach_id(int teach_id) {
            this.teach_id = teach_id;
        }

        public String getTeach_avatar() {
            return teach_avatar;
        }

        public void setTeach_avatar(String teach_avatar) {
            this.teach_avatar = teach_avatar;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "AdvTeacherBean{" +
                    "teach_id=" + teach_id +
                    ", teach_avatar='" + teach_avatar + '\'' +
                    ", id=" + id +
                    '}';
        }
    }

    public static class AdviserBean {
        private String adviser_avatar;
        private String adviser_name;
        private int id;
        private int type;

        public String getAdviser_avatar() {
            return adviser_avatar;
        }

        public void setAdviser_avatar(String adviser_avatar) {
            this.adviser_avatar = adviser_avatar;
        }

        public String getAdviser_name() {
            return adviser_name;
        }

        public void setAdviser_name(String adviser_name) {
            this.adviser_name = adviser_name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "AdviserBean{" +
                    "adviser_avatar='" + adviser_avatar + '\'' +
                    ", adviser_name='" + adviser_name + '\'' +
                    ", id=" + id +
                    ", type=" + type +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "BeanC{" +
                "invest_lecture=" + invest_lecture +
                ", viewpoint=" + viewpoint +
                ", adv_teacher=" + adv_teacher +
                ", adviser=" + adviser +
                '}';
    }
}
