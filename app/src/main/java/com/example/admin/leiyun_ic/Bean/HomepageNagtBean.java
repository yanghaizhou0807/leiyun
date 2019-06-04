package com.example.admin.leiyun_ic.Bean;

import java.util.List;

public class HomepageNagtBean {

    /**
     * success : true
     * code : 200
     * msg : 请求成功
     * jsonResult : {"list":[
     * {"nav_name":"测试","nav_url":"http://www.helibuy.cn/","nav_pic":"http://www.helibuy.cn/data/upload/mobile/nav/","nav_type":"1"},
     * {"nav_name":"测试2","nav_url":"http://www.helibuy.cn/","nav_pic":"http://www.helibuy.cn/data/upload/mobile/nav/","nav_type":"1"}]}
     */

    private boolean success;
    private String code;
    private String msg;
    private JsonResultBean jsonResult;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public JsonResultBean getJsonResult() {
        return jsonResult;
    }

    public void setJsonResult(JsonResultBean jsonResult) {
        this.jsonResult = jsonResult;
    }

    public static class JsonResultBean {
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * nav_name : 测试
             * nav_url : http://www.helibuy.cn/
             * nav_pic : http://www.helibuy.cn/data/upload/mobile/nav/
             * nav_type : 1
             */

            private String nav_name;
            private String nav_url;
            private String nav_pic;
            private String nav_type;

            public String getNav_name() {
                return nav_name;
            }

            public void setNav_name(String nav_name) {
                this.nav_name = nav_name;
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

            public String getNav_type() {
                return nav_type;
            }

            public void setNav_type(String nav_type) {
                this.nav_type = nav_type;
            }
        }
    }
}
