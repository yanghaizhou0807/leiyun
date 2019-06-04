package com.example.admin.leiyun_ic.Bean;

import java.util.List;

public class NewHomepageNagtBean {

    /**
     * code : 200
     * msg : 请求成功
     * data : [
     * {"nav_id":2,"nav_name":"福利商城","nav_type":3,"bind_id":0,"nav_url":"#","nav_pic":"/uploads/20190529/30e6a3998645ed0a072bf2a547c44760.png","nav_sort":1,"status":1,"update_time":"2019-05-29 15:55:19"},
     * {"nav_id":4,"nav_name":"新品首发","nav_type":2,"bind_id":15,"nav_url":"","nav_pic":"/uploads/20190529/e5d6077c2721e338033c17832042501e.png","nav_sort":2,"status":1,"update_time":"2019-05-29 16:04:02"},
     * ]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * nav_id : 2
         * nav_name : 福利商城
         * nav_type : 3
         * bind_id : 0
         * nav_url : #
         * nav_pic : /uploads/20190529/30e6a3998645ed0a072bf2a547c44760.png
         * nav_sort : 1
         * status : 1
         * update_time : 2019-05-29 15:55:19
         */

        private int nav_id;
        private String nav_name;
        private int nav_type;
        private int bind_id;
        private String nav_url;
        private String nav_pic;
        private int nav_sort;
        private int status;
        private String update_time;

        public int getNav_id() {
            return nav_id;
        }

        public void setNav_id(int nav_id) {
            this.nav_id = nav_id;
        }

        public String getNav_name() {
            return nav_name;
        }

        public void setNav_name(String nav_name) {
            this.nav_name = nav_name;
        }

        public int getNav_type() {
            return nav_type;
        }

        public void setNav_type(int nav_type) {
            this.nav_type = nav_type;
        }

        public int getBind_id() {
            return bind_id;
        }

        public void setBind_id(int bind_id) {
            this.bind_id = bind_id;
        }

        public String getNav_url() {
            return nav_url;
        }

        public void setNav_url(String nav_url) {
            this.nav_url = nav_url;
        }

        public String getNav_pic() {
            return nav_pic;
        }

        public void setNav_pic(String nav_pic) {
            this.nav_pic = nav_pic;
        }

        public int getNav_sort() {
            return nav_sort;
        }

        public void setNav_sort(int nav_sort) {
            this.nav_sort = nav_sort;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }
    }
}
