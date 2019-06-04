package com.example.admin.leiyun_ic.Bean;

import java.util.List;

public class HomeRvBean {

    private List<JsonResultBean> jsonResult;

    public List<JsonResultBean> getJsonResult() {
        return jsonResult;
    }

    public void setJsonResult(List<JsonResultBean> jsonResult) {
        this.jsonResult = jsonResult;
    }

    public static class JsonResultBean {
        /**
         * goods_name : 加加林(JAJALIN) 眼罩竹炭眼罩 睡眠遮光 男女士睡觉护眼罩 旅游用品 JA008黑色（2件起售）
         * goods_marketprice : 9.90
         * goods_price : 9.62
         * goods_image : http://img11.360buyimg.com/n1/jfs/t3196/316/615088850/287938/b8b755fd/57bbaab6N4a4063a3.jpg
         * goods_id : 32552
         */

        private String goods_name;
        private String goods_marketprice;
        private String goods_price;
        private String goods_image;
        private int goods_id;

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getGoods_marketprice() {
            return goods_marketprice;
        }

        public void setGoods_marketprice(String goods_marketprice) {
            this.goods_marketprice = goods_marketprice;
        }

        public String getGoods_price() {
            return goods_price;
        }

        public void setGoods_price(String goods_price) {
            this.goods_price = goods_price;
        }

        public String getGoods_image() {
            return goods_image;
        }

        public void setGoods_image(String goods_image) {
            this.goods_image = goods_image;
        }

        public int getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(int goods_id) {
            this.goods_id = goods_id;
        }
    }
}
