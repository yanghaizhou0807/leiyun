package com.example.admin.leiyun_ic.Bean;

public class OrderStatusQuantityBean  {

    /**
     * code : 200
     * msg : 请求成功
     * data : {"order_new":0,"order_pay":36,"order_recive":2,"order_complete":5,"order_close":93,"order_noeval":3,"order_all":136,"order_refund":7}
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
         * order_new : 0
         * order_pay : 36
         * order_recive : 2
         * order_complete : 5
         * order_close : 93
         * order_noeval : 3
         * order_all : 136
         * order_refund : 7
         */

        private int order_new;
        private int order_pay;
        private int order_recive;
        private int order_complete;
        private int order_close;
        private int order_noeval;
        private int order_all;
        private int order_refund;

        public int getOrder_new() {
            return order_new;
        }

        public void setOrder_new(int order_new) {
            this.order_new = order_new;
        }

        public int getOrder_pay() {
            return order_pay;
        }

        public void setOrder_pay(int order_pay) {
            this.order_pay = order_pay;
        }

        public int getOrder_recive() {
            return order_recive;
        }

        public void setOrder_recive(int order_recive) {
            this.order_recive = order_recive;
        }

        public int getOrder_complete() {
            return order_complete;
        }

        public void setOrder_complete(int order_complete) {
            this.order_complete = order_complete;
        }

        public int getOrder_close() {
            return order_close;
        }

        public void setOrder_close(int order_close) {
            this.order_close = order_close;
        }

        public int getOrder_noeval() {
            return order_noeval;
        }

        public void setOrder_noeval(int order_noeval) {
            this.order_noeval = order_noeval;
        }

        public int getOrder_all() {
            return order_all;
        }

        public void setOrder_all(int order_all) {
            this.order_all = order_all;
        }

        public int getOrder_refund() {
            return order_refund;
        }

        public void setOrder_refund(int order_refund) {
            this.order_refund = order_refund;
        }
    }
}
