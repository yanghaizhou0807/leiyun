package com.example.admin.leiyun_ic.Bean;

import java.io.Serializable;
import java.util.List;

public class  HomeRecycleViewBean implements Serializable {
    /**
     * success : true
     * code : 200
     * message : 获取成功
     * jsonResult : [
     * {"goods_name":"加加林(JAJALIN) 眼罩竹炭眼罩 睡眠遮光 男女士睡觉护眼罩 旅游用品 JA008黑色（2件起售）","goods_marketprice":"9.90","goods_price":"9.62","goods_image":"http://img11.360buyimg.com/n1/jfs/t3196/316/615088850/287938/b8b755fd/57bbaab6N4a4063a3.jpg","goods_id":32552},
     * {"goods_name":"加加林 手机防水袋苹果三星小米防水套游泳潜水套iphone6防水手机套 常规款粉色 适合5.0英寸以下手机JA016","goods_marketprice":"25.00","goods_price":"25.00","goods_image":"http://img11.360buyimg.com/n1/jfs/t11095/312/887232231/92554/171ff766/59facd99N47028543.jpg","goods_id":32553},
     * {"goods_name":"EPC 旅行套装 充气枕头 睡眠眼罩 户外便携 旅游用品 旅行套装送耳塞（耳塞颜色随机）","goods_marketprice":"51.50","goods_price":"39.94","goods_image":"http://img11.360buyimg.com/n1/jfs/t1417/125/329906034/85880/fd4dec2e/557566dbNf95d7194.jpg","goods_id":32558},
     * {"goods_name":"四万公里 新款便携式洗漱包 防水多功能随身化妆包旅行男女收纳包 SW1101 深灰色","goods_marketprice":"24.80","goods_price":"22.82","goods_image":"http://img11.360buyimg.com/n1/jfs/t15952/59/846627340/135838/6e1c1615/5a4096e5N7d085078.jpg","goods_id":32560},
     * {"goods_name":"四万公里 韩国多功能化妆包 旅行必备便携洗漱包整理包 SW1201 深蓝色","goods_marketprice":"16.80","goods_price":"16.80","goods_image":"http://img11.360buyimg.com/n1/jfs/t14362/102/1082174013/80788/25a674be/5a44b8b5N48cad934.jpg","goods_id":32571},
     * {"goods_name":"四万公里 便携式香皂片香皂纸肥皂片 创意洗手小肥皂 清洁卫生100片装 SW2014 颜色随机（2件起售）","goods_marketprice":"9.90","goods_price":"8.56","goods_image":"http://img11.360buyimg.com/n1/jfs/t6421/83/2242824761/292234/ebb9cb3c/595f4ecfN866a6b9b.jpg","goods_id":32572},
     * {"goods_name":"四万公里 一次性内裤 女士纯棉内裤 旅行用品 SW8003 90克棉 3条/包 M号","goods_marketprice":"15.60","goods_price":"15.60","goods_image":"http://img11.360buyimg.com/n1/jfs/t1924/282/637335201/152311/aeb6e309/561f7451N98ef0dc7.jpg","goods_id":32578},
     * {"goods_name":"加加林 多功能洗漱杯 漱口杯 牙刷杯  旅行刷牙杯 便携牙刷收纳盒 大号多彩白色（2件起售）","goods_marketprice":"9.90","goods_price":"9.90","goods_image":"http://img11.360buyimg.com/n1/jfs/t5953/305/6754395450/55695/1e9aa34d/59759d0cN7b0f3d93.jpg","goods_id":32582},
     * {"goods_name":"安悠 一次性枕套 旅行用品酒店出差 干净卫生 AYU3001 50*80cm（2件起售）","goods_marketprice":"8.80","goods_price":"8.80","goods_image":"http://img11.360buyimg.com/n1/jfs/t4195/238/2548376294/153443/148f6284/58d344edNc371eba9.jpg","goods_id":32583},
     * {"goods_name":"Freego悠派一次性内裤 金装 5条装 全棉水洗高温烘干 旅行出差度假旅游必备 男灰XXL码","goods_marketprice":"24.90","goods_price":"24.90","goods_image":"http://img11.360buyimg.com/n1/jfs/t3802/264/792240316/114778/6ca4df48/581441e8Nf7d10761.jpg","goods_id":32588},
     * {"goods_name":"加加林 真丝眼罩 桑蚕丝眼罩 透气舒适睡眠眼罩 青花瓷","goods_marketprice":"58.00","goods_price":"58.00","goods_image":"http://img11.360buyimg.com/n1/jfs/t3061/216/1632818481/233780/c606de93/57d126daNcfe129e0.jpg","goods_id":32589},
     * {"goods_name":"蓝橙 LYCEEM  洗漱包 防水轻质洗漱袋收纳包旅游用品收纳袋 经典款 黑色","goods_marketprice":"35.00","goods_price":"28.74","goods_image":"http://img11.360buyimg.com/n1/jfs/t1927/210/121881368/147358/d71c94fa/55efde98Nd8823124.jpg","goods_id":32595}
     * ]
     */
    private boolean success;
    private int code;
    private String message;
    private List<JsonResultBean> jsonResult;

    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
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
