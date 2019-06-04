package com.example.admin.leiyun_ic.Bean;

import java.io.Serializable;

public class UserLoginBean implements Serializable {


    /**
     * code : 0
     * msg : 操作成功
     * data : {"member_id":1,"nickname":"admin","username":"13436187723","create_time":"2019-04-24 11:35:13","device_id":"123456","main_url":null,"user_token":"4"}
     * exe_time : 0.486657
     */

    private int code;
    private String msg;
    private DataBean data;
    private String exe_time;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getExe_time() {
        return exe_time;
    }

    public void setExe_time(String exe_time) {
        this.exe_time = exe_time;
    }

    public static class DataBean {
        /**
         * member_id : 1
         * nickname : admin
         * username : 13436187723
         * create_time : 2019-04-24 11:35:13
         * device_id : 123456
         * main_url : null
         * user_token : 4
         */

        private int member_id;
        private String nickname;
        private String username;
        private String create_time;
        private String device_id;
        private Object main_url;
        private String user_token;

        public int getMember_id() {
            return member_id;
        }

        public void setMember_id(int member_id) {
            this.member_id = member_id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getDevice_id() {
            return device_id;
        }

        public void setDevice_id(String device_id) {
            this.device_id = device_id;
        }

        public Object getMain_url() {
            return main_url;
        }

        public void setMain_url(Object main_url) {
            this.main_url = main_url;
        }

        public String getUser_token() {
            return user_token;
        }

        public void setUser_token(String user_token) {
            this.user_token = user_token;
        }
    }
}
