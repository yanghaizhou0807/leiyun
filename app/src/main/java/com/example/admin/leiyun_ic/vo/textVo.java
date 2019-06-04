package com.example.admin.leiyun_ic.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class textVo {

    /**
     * code : 200
     * datas : {
     * "0":{"adv_list":{"item":
     * [{"image":"http://www.helibuy.cn/data/upload/mobile/special/s0/s0_05992208847673789.jpg","type":"","data":""},
     * {"image":"http://www.helibuy.cn/data/upload/mobile/special/s0/s0_05999238668304550.jpg","type":"","data":""}]
     * }},
     *
     * "1":{"goods":
     * {"title":"为你推荐",
     * "item":[
     * {"goods_id":"17176",
     * "goods_name":"创维（Skyworth）55M7 55英寸14核4K超高清智能酷开网络液晶电视（黑色）",
     * "goods_promotion_price":"2794.74",
     * "goods_image":"http://img11.360buyimg.com/n1/jfs/t6583/360/144916161/277180/fce869e1/593a2a2bN923ddc83.jpg"},
     * ]}
     * },
     *
     * "show_price":{"is_login":"1","wap_show_price":"0","login_to_see_price":"登录后查看"}
     * }
     */

    private int code;
    private DatasBean datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DatasBean getDatas() {
        return datas;
    }

    public void setDatas(DatasBean datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        /**
         *----------轮播图接口数据--------
         * 0 : {
         * "adv_list":{
         * "item":[
         * {"image":"http://www.helibuy.cn/data/upload/mobile/special/s0/s0_05992208847673789.jpg",
         * "type":"",
         * "data":""},
         * {"image":"http://www.helibuy.cn/data/upload/mobile/special/s0/s0_05999238668304550.jpg",
         * "type":"",
         * "data":""}
         * ]
         * }
         * }
         *
         * 1 : {
         * "goods":{
         * "title":"为你推荐",
         * "item":[
         * {"goods_id":"17176",
         * "goods_name":"创维（Skyworth）55M7 55英寸14核4K超高清智能酷开网络液晶电视（黑色）",
         * "goods_promotion_price":"2794.74",
         * "goods_image":"http://img11.360buyimg.com/n1/jfs/t6583/360/144916161/277180/fce869e1/593a2a2bN923ddc83.jpg"}
         * ]
         * }
         * }
         *
         * show_price : {"is_login":"1","wap_show_price":"0","login_to_see_price":"登录后查看"}
         */
        @SerializedName("0")
        private _$0Bean _$0;
        @SerializedName("1")
        private _$1Bean _$1;
        private ShowPriceBean show_price;

        public _$0Bean get_$0() {
            return _$0;
        }

        public void set_$0(_$0Bean _$0) {
            this._$0 = _$0;
        }

        public _$1Bean get_$1() {
            return _$1;
        }

        public void set_$1(_$1Bean _$1) {
            this._$1 = _$1;
        }

        public ShowPriceBean getShow_price() {
            return show_price;
        }

        public void setShow_price(ShowPriceBean show_price) {
            this.show_price = show_price;
        }

        public static class _$0Bean {
            /**
             * adv_list : {"item":
             * [{"image":"http://www.helibuy.cn/data/upload/mobile/special/s0/s0_05992208847673789.jpg","type":"","data":""},
             * {"image":"http://www.helibuy.cn/data/upload/mobile/special/s0/s0_05999238668304550.jpg","type":"","data":""}]}
             */

            private AdvListBean adv_list;

            public AdvListBean getAdv_list() {
                return adv_list;
            }

            public void setAdv_list(AdvListBean adv_list) {
                this.adv_list = adv_list;
            }

            public static class AdvListBean {
                private List<ItemBean> item;

                public List<ItemBean> getItem() {
                    return item;
                }

                public void setItem(List<ItemBean> item) {
                    this.item = item;
                }

                public static class ItemBean {
                    /**
                     * image : http://www.helibuy.cn/data/upload/mobile/special/s0/s0_05992208847673789.jpg
                     * type :
                     * data :
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

        public static class _$1Bean {
            /**
             * goods : {"title":"为你推荐",
             * "item":[
             * {"goods_id":"17176","goods_name":"创维（Skyworth）55M7 55英寸14核4K超高清智能酷开网络液晶电视（黑色）","goods_promotion_price":"2794.74","goods_image":"http://img11.360buyimg.com/n1/jfs/t6583/360/144916161/277180/fce869e1/593a2a2bN923ddc83.jpg"},
             * {"goods_id":"17175","goods_name":"LG 55UH7500-CA 55英寸 IPS硬屏 4色4K HDR 臻广色域  超薄 智能电视","goods_promotion_price":"6448.93","goods_image":"http://img11.360buyimg.com/n1/jfs/t3241/279/4270391062/260232/2dfcfee5/583beabaNe0f3acdf.jpg"},
             * {"goods_id":"17173","goods_name":"乐视超级电视 超4 X55 Curved 曲面 55英寸 4K超高清 HDR 1.7GHz 4核CPU 3GB内存+32GB闪存 （标配底座）","goods_promotion_price":"4238.79","goods_image":"http://img11.360buyimg.com/n1/jfs/t17944/269/254799423/357171/162b7ac0/5a669b0aNbac96b45.jpg"},
             * {"goods_id":"17172","goods_name":"康佳（KONKA）LED40S1 40英寸全高清智能LED液晶平板电视","goods_promotion_price":"1299.00","goods_image":"http://img11.360buyimg.com/n1/jfs/t7351/344/283804913/359390/d52344e3/59913f4cN12e2e67d.jpg"},
             * {"goods_id":"19483","goods_name":"努比亚（nubia）律音耳机 手机斜入耳式线控耳塞","goods_promotion_price":"95.48","goods_image":"http://img11.360buyimg.com/n1/jfs/t2947/226/655479920/21048/c66e474/57627dafN55538af5.jpg"},
             * {"goods_id":"19451","goods_name":"雷曼克斯（LineMax）LM-001A笑脸 耳挂式对讲机耳机 K口通用","goods_promotion_price":"18.56","goods_image":"http://img11.360buyimg.com/n1/jfs/t2164/53/2694991317/56998/e5a06280/56e64cb0N7c9c3cd2.jpg"}
             * ]
             * }
             */

            private GoodsBean goods;

            public GoodsBean getGoods() {
                return goods;
            }

            public void setGoods(GoodsBean goods) {
                this.goods = goods;
            }

            public static class GoodsBean {
                /**
                 * title : 为你推荐
                 * item : [
                 * {"goods_id":"17176","goods_name":"创维（Skyworth）55M7 55英寸14核4K超高清智能酷开网络液晶电视（黑色）","goods_promotion_price":"2794.74","goods_image":"http://img11.360buyimg.com/n1/jfs/t6583/360/144916161/277180/fce869e1/593a2a2bN923ddc83.jpg"},
                 * {"goods_id":"17175","goods_name":"LG 55UH7500-CA 55英寸 IPS硬屏 4色4K HDR 臻广色域  超薄 智能电视","goods_promotion_price":"6448.93","goods_image":"http://img11.360buyimg.com/n1/jfs/t3241/279/4270391062/260232/2dfcfee5/583beabaNe0f3acdf.jpg"},
                 * {"goods_id":"17173","goods_name":"乐视超级电视 超4 X55 Curved 曲面 55英寸 4K超高清 HDR 1.7GHz 4核CPU 3GB内存+32GB闪存 （标配底座）","goods_promotion_price":"4238.79","goods_image":"http://img11.360buyimg.com/n1/jfs/t17944/269/254799423/357171/162b7ac0/5a669b0aNbac96b45.jpg"},
                 * ]
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
                     * goods_id : 17176
                     * goods_name : 创维（Skyworth）55M7 55英寸14核4K超高清智能酷开网络液晶电视（黑色）
                     * goods_promotion_price : 2794.74
                     * goods_image : http://img11.360buyimg.com/n1/jfs/t6583/360/144916161/277180/fce869e1/593a2a2bN923ddc83.jpg
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
        }

        public static class ShowPriceBean {
            /**
             * is_login : 1
             * wap_show_price : 0
             * login_to_see_price : 登录后查看
             */

            private String is_login;
            private String wap_show_price;
            private String login_to_see_price;

            public String getIs_login() {
                return is_login;
            }

            public void setIs_login(String is_login) {
                this.is_login = is_login;
            }

            public String getWap_show_price() {
                return wap_show_price;
            }

            public void setWap_show_price(String wap_show_price) {
                this.wap_show_price = wap_show_price;
            }

            public String getLogin_to_see_price() {
                return login_to_see_price;
            }

            public void setLogin_to_see_price(String login_to_see_price) {
                this.login_to_see_price = login_to_see_price;
            }
        }
    }
}
