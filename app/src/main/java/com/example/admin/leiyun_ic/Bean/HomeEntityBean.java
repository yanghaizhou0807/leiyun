package com.example.admin.leiyun_ic.Bean;

import java.util.List;

public class HomeEntityBean {


    /**
     * success : true
     * code : 200
     * message : 获取成功
     * jsonResult : [
     * {"home1":{"title":"","image":"http://www.helibuy.cn/data/upload/mobile/special/s2/s2_06087376039514446.png","type":"special","data":"2"}},
     * {"home3":[
     * {"title":"品牌专供","item":[{"image":"http://www.helibuy.cn/data/upload/mobile/special/s2/s2_06087376998269358.jpg","type":"special","data":"1"},
     * {"image":"http://www.helibuy.cn/data/upload/mobile/special/s2/s2_06087377127958465.jpg","type":"special","data":"2"}]},
     * {"title":"进口好货","item":[{"image":"http://www.helibuy.cn/data/upload/mobile/special/s2/s2_06087377253583909.jpg","type":"special","data":"2"},
     * {"image":"http://www.helibuy.cn/data/upload/mobile/special/s2/s2_06087377463263573.jpg","type":"special","data":"3"}]}]},
     *
     * {"home1":{"title":"福利精选","image":"http://www.helibuy.cn/data/upload/mobile/special/s2/s2_06087377722649690.png","type":"special","data":"3"}},
     *
     * {"goods":{"title":"优惠专区",
     * "item":[{"goods_id":"779670","goods_name":"赛鲸 笔记本电脑桌 床上桌 读书架 宿舍可折叠懒人桌子 学生学习飘窗书桌 手机平板支架 大桌面 G6学习版","goods_promotion_price":"169.00","goods_image":"http://img11.360buyimg.com/n1/jfs/t26968/83/2300959645/190917/996d6a97/5bfcbce0N2ffad886.jpg"},
     * {"goods_id":"779609","goods_name":"宜客乐思（ECOLUS）宜客莱系列平板手机支架书房办公阅读书架IS-NS02WT","goods_promotion_price":"29.90","goods_image":"http://img11.360buyimg.com/n1/jfs/t21730/178/1859562438/110771/73a3c920/5b3b15a1N59e3c526.jpg"},
     * {"goods_id":"776628","goods_name":"江小白 京东手机定制40度清香型白酒100ml*4瓶","goods_promotion_price":"86.00","goods_image":"http://img11.360buyimg.com/n1/jfs/t1/18609/30/5634/84831/5c3ff274E2dd6d22a/a09d22012fd47783.jpg"},
     * {"goods_id":"768373","goods_name":"益米（YImi）变形电子手机 变身机器人男孩玩具 3-4-5岁（颜色随机发货）","goods_promotion_price":"59.00","goods_image":"http://img11.360buyimg.com/n1/jfs/t19435/36/2219902995/97425/9e6bf33/5aeaa81aN85905e6e.jpg"},
     * {"goods_id":"768461","goods_name":"奥多拉(oduora) 儿童电话手表 安全定位全彩触屏高清拍照 防丢GPS定位联通移动插卡手表手机男女孩礼物","goods_promotion_price":"199.00","goods_image":"http://img11.360buyimg.com/n1/jfs/t1/19934/15/2044/284050/5c19ed44Ea9f7762c/795cc3560b822070.jpg"},
     * {"goods_id":"768282","goods_name":"Le idea8手机控制APP高清航拍智能气压定高折叠无人机四轴飞行器专业电动遥控飞机男生毕业季礼物 IDEA8遥控器电池（7号）","goods_promotion_price":"10.00","goods_image":"http://img11.360buyimg.com/n1/jfs/t21724/352/1154911528/116606/5fb70443/5b20d715Nced5e340.jpg"},
     * {"goods_id":"769904","goods_name":"黑科技平安福手机摇步器刷步器自动摇手环微信运动刷步数摇摆器计步器刷步神器解放双腿 USB电池两用加速版","goods_promotion_price":"38.00","goods_image":"http://img11.360buyimg.com/n1/jfs/t1/27150/20/2669/181207/5c203dfbEff26f34e/a062b066030f1e79.jpg"},
     * {"goods_id":"779565","goods_name":"赛鲸 笔记本电脑桌 床上桌读书架 折叠懒人桌子 学生学习宿舍飘窗书桌 手机平板支架 大桌面带抽屉 G6旗舰版","goods_promotion_price":"199.00","goods_image":"http://img11.360buyimg.com/n1/jfs/t1/5328/15/12169/420948/5bd2aab2E6f62e67a/7e581580673a70fc.jpg"}]}},
     *
     * {"home3":[{"title":"口碑精选","item":[{"image":"http://www.helibuy.cn/data/upload/mobile/special/s2/s2_06087380771394908.jpg","type":"goods","data":"21217"},{"image":"http://www.helibuy.cn/data/upload/mobile/special/s2/s2_06087380919673093.jpg","type":"goods","data":"21217"}]},{"title":"人气榜","item":[{"image":"http://www.helibuy.cn/data/upload/mobile/special/s2/s2_06087381285302609.png","type":"goods","data":"21217"},{"image":"http://www.helibuy.cn/data/upload/mobile/special/s2/s2_06087381373114865.jpg","type":"goods","data":"21217"}]}]},
     * {"home3":[{"title":"拼团钜惠","item":[{"image":"http://www.helibuy.cn/data/upload/mobile/special/s2/s2_06087381649204965.jpg","type":"goods","data":"21217"},{"image":"http://www.helibuy.cn/data/upload/mobile/special/s2/s2_06087381727801229.jpg","type":"goods","data":"21217"}]},{"title":"达人囤货","item":[{"image":"http://www.helibuy.cn/data/upload/mobile/special/s2/s2_06087381955765976.jpg","type":"goods","data":"21217"},{"image":"http://www.helibuy.cn/data/upload/mobile/special/s2/s2_06087382029833833.jpg","type":"goods","data":"21217"}]}]},
     * {"home1":{"title":"","image":"http://www.helibuy.cn/data/upload/mobile/special/s2/s2_06087379988585940.png","type":"special","data":"2"}}]
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
         * home1 : {"title":"","image":"http://www.helibuy.cn/data/upload/mobile/special/s2/s2_06087376039514446.png","type":"special","data":"2"}
         * home3 : [{"title":"品牌专供","item":[{"image":"http://www.helibuy.cn/data/upload/mobile/special/s2/s2_06087376998269358.jpg","type":"special","data":"1"},{"image":"http://www.helibuy.cn/data/upload/mobile/special/s2/s2_06087377127958465.jpg","type":"special","data":"2"}]},{"title":"进口好货","item":[{"image":"http://www.helibuy.cn/data/upload/mobile/special/s2/s2_06087377253583909.jpg","type":"special","data":"2"},{"image":"http://www.helibuy.cn/data/upload/mobile/special/s2/s2_06087377463263573.jpg","type":"special","data":"3"}]}]
         * goods : {"title":"优惠专区","item":[{"goods_id":"779670","goods_name":"赛鲸 笔记本电脑桌 床上桌 读书架 宿舍可折叠懒人桌子 学生学习飘窗书桌 手机平板支架 大桌面 G6学习版","goods_promotion_price":"169.00","goods_image":"http://img11.360buyimg.com/n1/jfs/t26968/83/2300959645/190917/996d6a97/5bfcbce0N2ffad886.jpg"},{"goods_id":"779609","goods_name":"宜客乐思（ECOLUS）宜客莱系列平板手机支架书房办公阅读书架IS-NS02WT","goods_promotion_price":"29.90","goods_image":"http://img11.360buyimg.com/n1/jfs/t21730/178/1859562438/110771/73a3c920/5b3b15a1N59e3c526.jpg"},{"goods_id":"776628","goods_name":"江小白 京东手机定制40度清香型白酒100ml*4瓶","goods_promotion_price":"86.00","goods_image":"http://img11.360buyimg.com/n1/jfs/t1/18609/30/5634/84831/5c3ff274E2dd6d22a/a09d22012fd47783.jpg"},{"goods_id":"768373","goods_name":"益米（YImi）变形电子手机 变身机器人男孩玩具 3-4-5岁（颜色随机发货）","goods_promotion_price":"59.00","goods_image":"http://img11.360buyimg.com/n1/jfs/t19435/36/2219902995/97425/9e6bf33/5aeaa81aN85905e6e.jpg"},{"goods_id":"768461","goods_name":"奥多拉(oduora) 儿童电话手表 安全定位全彩触屏高清拍照 防丢GPS定位联通移动插卡手表手机男女孩礼物","goods_promotion_price":"199.00","goods_image":"http://img11.360buyimg.com/n1/jfs/t1/19934/15/2044/284050/5c19ed44Ea9f7762c/795cc3560b822070.jpg"},{"goods_id":"768282","goods_name":"Le idea8手机控制APP高清航拍智能气压定高折叠无人机四轴飞行器专业电动遥控飞机男生毕业季礼物 IDEA8遥控器电池（7号）","goods_promotion_price":"10.00","goods_image":"http://img11.360buyimg.com/n1/jfs/t21724/352/1154911528/116606/5fb70443/5b20d715Nced5e340.jpg"},{"goods_id":"769904","goods_name":"黑科技平安福手机摇步器刷步器自动摇手环微信运动刷步数摇摆器计步器刷步神器解放双腿 USB电池两用加速版","goods_promotion_price":"38.00","goods_image":"http://img11.360buyimg.com/n1/jfs/t1/27150/20/2669/181207/5c203dfbEff26f34e/a062b066030f1e79.jpg"},{"goods_id":"779565","goods_name":"赛鲸 笔记本电脑桌 床上桌读书架 折叠懒人桌子 学生学习宿舍飘窗书桌 手机平板支架 大桌面带抽屉 G6旗舰版","goods_promotion_price":"199.00","goods_image":"http://img11.360buyimg.com/n1/jfs/t1/5328/15/12169/420948/5bd2aab2E6f62e67a/7e581580673a70fc.jpg"}]}
         */

        private Home1Bean home1;
        private GoodsBean goods;
        private List<Home3Bean> home3;

        public Home1Bean getHome1() {
            return home1;
        }

        public void setHome1(Home1Bean home1) {
            this.home1 = home1;
        }

        public GoodsBean getGoods() {
            return goods;
        }

        public void setGoods(GoodsBean goods) {
            this.goods = goods;
        }

        public List<Home3Bean> getHome3() {
            return home3;
        }

        public void setHome3(List<Home3Bean> home3) {
            this.home3 = home3;
        }

        public static class Home1Bean {
            /**
             * title :
             * image : http://www.helibuy.cn/data/upload/mobile/special/s2/s2_06087376039514446.png
             * type : special
             * data : 2
             */

            private String title;
            private String image;
            private String type;
            private String data;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getData() {
                return data;
            }

            public void setData(String data) {
                this.data = data;
            }
        }

        public static class GoodsBean {
            /**
             * title : 优惠专区
             * item : [{"goods_id":"779670","goods_name":"赛鲸 笔记本电脑桌 床上桌 读书架 宿舍可折叠懒人桌子 学生学习飘窗书桌 手机平板支架 大桌面 G6学习版","goods_promotion_price":"169.00","goods_image":"http://img11.360buyimg.com/n1/jfs/t26968/83/2300959645/190917/996d6a97/5bfcbce0N2ffad886.jpg"},{"goods_id":"779609","goods_name":"宜客乐思（ECOLUS）宜客莱系列平板手机支架书房办公阅读书架IS-NS02WT","goods_promotion_price":"29.90","goods_image":"http://img11.360buyimg.com/n1/jfs/t21730/178/1859562438/110771/73a3c920/5b3b15a1N59e3c526.jpg"},{"goods_id":"776628","goods_name":"江小白 京东手机定制40度清香型白酒100ml*4瓶","goods_promotion_price":"86.00","goods_image":"http://img11.360buyimg.com/n1/jfs/t1/18609/30/5634/84831/5c3ff274E2dd6d22a/a09d22012fd47783.jpg"},{"goods_id":"768373","goods_name":"益米（YImi）变形电子手机 变身机器人男孩玩具 3-4-5岁（颜色随机发货）","goods_promotion_price":"59.00","goods_image":"http://img11.360buyimg.com/n1/jfs/t19435/36/2219902995/97425/9e6bf33/5aeaa81aN85905e6e.jpg"},{"goods_id":"768461","goods_name":"奥多拉(oduora) 儿童电话手表 安全定位全彩触屏高清拍照 防丢GPS定位联通移动插卡手表手机男女孩礼物","goods_promotion_price":"199.00","goods_image":"http://img11.360buyimg.com/n1/jfs/t1/19934/15/2044/284050/5c19ed44Ea9f7762c/795cc3560b822070.jpg"},{"goods_id":"768282","goods_name":"Le idea8手机控制APP高清航拍智能气压定高折叠无人机四轴飞行器专业电动遥控飞机男生毕业季礼物 IDEA8遥控器电池（7号）","goods_promotion_price":"10.00","goods_image":"http://img11.360buyimg.com/n1/jfs/t21724/352/1154911528/116606/5fb70443/5b20d715Nced5e340.jpg"},{"goods_id":"769904","goods_name":"黑科技平安福手机摇步器刷步器自动摇手环微信运动刷步数摇摆器计步器刷步神器解放双腿 USB电池两用加速版","goods_promotion_price":"38.00","goods_image":"http://img11.360buyimg.com/n1/jfs/t1/27150/20/2669/181207/5c203dfbEff26f34e/a062b066030f1e79.jpg"},{"goods_id":"779565","goods_name":"赛鲸 笔记本电脑桌 床上桌读书架 折叠懒人桌子 学生学习宿舍飘窗书桌 手机平板支架 大桌面带抽屉 G6旗舰版","goods_promotion_price":"199.00","goods_image":"http://img11.360buyimg.com/n1/jfs/t1/5328/15/12169/420948/5bd2aab2E6f62e67a/7e581580673a70fc.jpg"}]
             */

            private String title;
            private List<ItemBean> item;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<ItemBean> getItem() {
                return item;
            }

            public void setItem(List<ItemBean> item) {
                this.item = item;
            }

            public static class ItemBean {
                /**
                 * goods_id : 779670
                 * goods_name : 赛鲸 笔记本电脑桌 床上桌 读书架 宿舍可折叠懒人桌子 学生学习飘窗书桌 手机平板支架 大桌面 G6学习版
                 * goods_promotion_price : 169.00
                 * goods_image : http://img11.360buyimg.com/n1/jfs/t26968/83/2300959645/190917/996d6a97/5bfcbce0N2ffad886.jpg
                 */

                private String goods_id;
                private String goods_name;
                private String goods_promotion_price;
                private String goods_image;

                public String getGoods_id() {
                    return goods_id;
                }

                public void setGoods_id(String goods_id) {
                    this.goods_id = goods_id;
                }

                public String getGoods_name() {
                    return goods_name;
                }

                public void setGoods_name(String goods_name) {
                    this.goods_name = goods_name;
                }

                public String getGoods_promotion_price() {
                    return goods_promotion_price;
                }

                public void setGoods_promotion_price(String goods_promotion_price) {
                    this.goods_promotion_price = goods_promotion_price;
                }

                public String getGoods_image() {
                    return goods_image;
                }

                public void setGoods_image(String goods_image) {
                    this.goods_image = goods_image;
                }
            }
        }

        public static class Home3Bean {
            /**
             * title : 品牌专供
             * item : [{"image":"http://www.helibuy.cn/data/upload/mobile/special/s2/s2_06087376998269358.jpg","type":"special","data":"1"},{"image":"http://www.helibuy.cn/data/upload/mobile/special/s2/s2_06087377127958465.jpg","type":"special","data":"2"}]
             */

            private String title;
            private List<ItemBeanX> item;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<ItemBeanX> getItem() {
                return item;
            }

            public void setItem(List<ItemBeanX> item) {
                this.item = item;
            }

            public static class ItemBeanX {
                /**
                 * image : http://www.helibuy.cn/data/upload/mobile/special/s2/s2_06087376998269358.jpg
                 * type : special
                 * data : 1
                 */

                private String image;
                private String type;
                private String data;

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getData() {
                    return data;
                }

                public void setData(String data) {
                    this.data = data;
                }
            }
        }
    }
}
