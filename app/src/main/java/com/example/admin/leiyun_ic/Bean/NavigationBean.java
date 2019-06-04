package com.example.admin.leiyun_ic.Bean;

import java.io.Serializable;

public class NavigationBean implements Serializable {

    /**
     * code : 0
     * msg : 操作成功
     * data : {"device_id":"123456","user_token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJKV1QiLCJpYXQiOjE1NTkyMTAyOTMsImV4cCI6MzExODQyMDU4NiwiYXVkIjoiYXBpQmFzZSIsInN1YiI6IjExMTFhcGlCYXNlIiwiZGF0YSI6eyJkZXZpY2VfaWQiOiIxMjM0NTYifX0.vENFbiMiU58xzZ5jJXhBcDMf1e_Adlte1yKf1aocCCw"}
     * exe_time : 0.001973
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
         * device_id : 123456
         * user_token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJKV1QiLCJpYXQiOjE1NTkyMTAyOTMsImV4cCI6MzExODQyMDU4NiwiYXVkIjoiYXBpQmFzZSIsInN1YiI6IjExMTFhcGlCYXNlIiwiZGF0YSI6eyJkZXZpY2VfaWQiOiIxMjM0NTYifX0.vENFbiMiU58xzZ5jJXhBcDMf1e_Adlte1yKf1aocCCw
         */

        private String device_id;
        private String user_token;

        public String getDevice_id() {
            return device_id;
        }

        public void setDevice_id(String device_id) {
            this.device_id = device_id;
        }

        public String getUser_token() {
            return user_token;
        }

        public void setUser_token(String user_token) {
            this.user_token = user_token;
        }
    }
}
