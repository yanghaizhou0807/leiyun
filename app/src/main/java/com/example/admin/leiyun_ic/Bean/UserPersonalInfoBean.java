package com.example.admin.leiyun_ic.Bean;

public class UserPersonalInfoBean {

    /**
     * code : 200
     * msg : 请求成功
     * data : {"mobile":"13436187723","mobile_bind":1,"email":"","email_bind":1,"nickname":"admin","member_truename":"admin","member_avatar":"http://img11.360buyimg.com/n1/jfs/t18847/306/478451043/74502/7c02f653/5a83d2edNbfce59aa.jpg","member_sex":1,"member_birthday":"2019-09-20","user_name":"13436187723","company_id":4,"available_rc_balance":"9999.00","member_exppoints":50,"invite_one":0,"invite_two":0,"invite_three":0,"member_areaid":null,"member_cityid":null,"member_provinceid":null,"is_paypwd":1,"company_name":"雷云智链"}
     */

    private int code;
    private String msg;
    private DataBean data;

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

    public static class DataBean {
        /**
         * mobile : 13436187723
         * mobile_bind : 1
         * email :
         * email_bind : 1
         * nickname : admin
         * member_truename : admin
         * member_avatar : http://img11.360buyimg.com/n1/jfs/t18847/306/478451043/74502/7c02f653/5a83d2edNbfce59aa.jpg
         * member_sex : 1
         * member_birthday : 2019-09-20
         * user_name : 13436187723
         * company_id : 4
         * available_rc_balance : 9999.00
         * member_exppoints : 50
         * invite_one : 0
         * invite_two : 0
         * invite_three : 0
         * member_areaid : null
         * member_cityid : null
         * member_provinceid : null
         * is_paypwd : 1
         * company_name : 雷云智链
         */

        private String mobile;
        private int mobile_bind;
        private String email;
        private int email_bind;
        private String nickname;
        private String member_truename;
        private String member_avatar;
        private int member_sex;
        private String member_birthday;
        private String user_name;
        private int company_id;
        private String available_rc_balance;
        private int member_exppoints;
        private int invite_one;
        private int invite_two;
        private int invite_three;
        private Object member_areaid;
        private Object member_cityid;
        private Object member_provinceid;
        private int is_paypwd;
        private String company_name;

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getMobile_bind() {
            return mobile_bind;
        }

        public void setMobile_bind(int mobile_bind) {
            this.mobile_bind = mobile_bind;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getEmail_bind() {
            return email_bind;
        }

        public void setEmail_bind(int email_bind) {
            this.email_bind = email_bind;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getMember_truename() {
            return member_truename;
        }

        public void setMember_truename(String member_truename) {
            this.member_truename = member_truename;
        }

        public String getMember_avatar() {
            return member_avatar;
        }

        public void setMember_avatar(String member_avatar) {
            this.member_avatar = member_avatar;
        }

        public int getMember_sex() {
            return member_sex;
        }

        public void setMember_sex(int member_sex) {
            this.member_sex = member_sex;
        }

        public String getMember_birthday() {
            return member_birthday;
        }

        public void setMember_birthday(String member_birthday) {
            this.member_birthday = member_birthday;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public int getCompany_id() {
            return company_id;
        }

        public void setCompany_id(int company_id) {
            this.company_id = company_id;
        }

        public String getAvailable_rc_balance() {
            return available_rc_balance;
        }

        public void setAvailable_rc_balance(String available_rc_balance) {
            this.available_rc_balance = available_rc_balance;
        }

        public int getMember_exppoints() {
            return member_exppoints;
        }

        public void setMember_exppoints(int member_exppoints) {
            this.member_exppoints = member_exppoints;
        }

        public int getInvite_one() {
            return invite_one;
        }

        public void setInvite_one(int invite_one) {
            this.invite_one = invite_one;
        }

        public int getInvite_two() {
            return invite_two;
        }

        public void setInvite_two(int invite_two) {
            this.invite_two = invite_two;
        }

        public int getInvite_three() {
            return invite_three;
        }

        public void setInvite_three(int invite_three) {
            this.invite_three = invite_three;
        }

        public Object getMember_areaid() {
            return member_areaid;
        }

        public void setMember_areaid(Object member_areaid) {
            this.member_areaid = member_areaid;
        }

        public Object getMember_cityid() {
            return member_cityid;
        }

        public void setMember_cityid(Object member_cityid) {
            this.member_cityid = member_cityid;
        }

        public Object getMember_provinceid() {
            return member_provinceid;
        }

        public void setMember_provinceid(Object member_provinceid) {
            this.member_provinceid = member_provinceid;
        }

        public int getIs_paypwd() {
            return is_paypwd;
        }

        public void setIs_paypwd(int is_paypwd) {
            this.is_paypwd = is_paypwd;
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }
    }
}
