package com.example.admin.leiyun_ic.Bean;

import java.util.List;

public class UserAddressListBean {

    /**
     * code : 200
     * msg : 请求成功
     * data : {"total":1,"per_page":"10","current_page":1,"last_page":1,"data":[{"address_id":73,"member_id":999,"true_name":"陈金文","province_id":1,"area_id":2,"city_id":3,"area_info":"重庆市 渝中区","address":"重庆市奉节县","tel_phone":null,"mob_phone":"17783427199","status":"1","is_default":"1","dlyp_id":0,"email":"3123@qq.com"}]}
     */

    private int code;
    private String msg;
    private DataBeanX data;

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

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * total : 1
         * per_page : 10
         * current_page : 1
         * last_page : 1
         * data : [{"address_id":73,"member_id":999,"true_name":"陈金文","province_id":1,"area_id":2,"city_id":3,"area_info":"重庆市 渝中区","address":"重庆市奉节县","tel_phone":null,"mob_phone":"17783427199","status":"1","is_default":"1","dlyp_id":0,"email":"3123@qq.com"}]
         */

        private int total;
        private String per_page;
        private int current_page;
        private int last_page;
        private List<DataBean> data;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public String getPer_page() {
            return per_page;
        }

        public void setPer_page(String per_page) {
            this.per_page = per_page;
        }

        public int getCurrent_page() {
            return current_page;
        }

        public void setCurrent_page(int current_page) {
            this.current_page = current_page;
        }

        public int getLast_page() {
            return last_page;
        }

        public void setLast_page(int last_page) {
            this.last_page = last_page;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * address_id : 73
             * member_id : 999
             * true_name : 陈金文
             * province_id : 1
             * area_id : 2
             * city_id : 3
             * area_info : 重庆市 渝中区
             * address : 重庆市奉节县
             * tel_phone : null
             * mob_phone : 17783427199
             * status : 1
             * is_default : 1
             * dlyp_id : 0
             * email : 3123@qq.com
             */

            private int address_id;
            private int member_id;
            private String true_name;
            private int province_id;
            private int area_id;
            private int city_id;
            private String area_info;
            private String address;
            private Object tel_phone;
            private String mob_phone;
            private String status;
            private String is_default;
            private int dlyp_id;
            private String email;

            public int getAddress_id() {
                return address_id;
            }

            public void setAddress_id(int address_id) {
                this.address_id = address_id;
            }

            public int getMember_id() {
                return member_id;
            }

            public void setMember_id(int member_id) {
                this.member_id = member_id;
            }

            public String getTrue_name() {
                return true_name;
            }

            public void setTrue_name(String true_name) {
                this.true_name = true_name;
            }

            public int getProvince_id() {
                return province_id;
            }

            public void setProvince_id(int province_id) {
                this.province_id = province_id;
            }

            public int getArea_id() {
                return area_id;
            }

            public void setArea_id(int area_id) {
                this.area_id = area_id;
            }

            public int getCity_id() {
                return city_id;
            }

            public void setCity_id(int city_id) {
                this.city_id = city_id;
            }

            public String getArea_info() {
                return area_info;
            }

            public void setArea_info(String area_info) {
                this.area_info = area_info;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public Object getTel_phone() {
                return tel_phone;
            }

            public void setTel_phone(Object tel_phone) {
                this.tel_phone = tel_phone;
            }

            public String getMob_phone() {
                return mob_phone;
            }

            public void setMob_phone(String mob_phone) {
                this.mob_phone = mob_phone;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getIs_default() {
                return is_default;
            }

            public void setIs_default(String is_default) {
                this.is_default = is_default;
            }

            public int getDlyp_id() {
                return dlyp_id;
            }

            public void setDlyp_id(int dlyp_id) {
                this.dlyp_id = dlyp_id;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }
        }
    }
}
