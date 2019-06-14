package com.example.admin.leiyun_ic.Details.Bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class goodsDetailBean {

    /**
     * code : 200
     * msg : 请求成功
     * data : {"spec_value_ar":[[{"id":94,"val":"14寸"},{"id":95,"val":"15寸"}],[{"id":98,"val":"红色"},{"id":99,"val":"黑色"}]],"goods_salenum":14,"goods_name":"LS","goods_marketprice":"88.00","goods_price":"99.00","store_name":"新增供应商","gc_id":204,"spec_name":["尺寸","颜色"],"spec_value":[{"94":"14寸","95":"15寸"},{"98":"红色","99":"黑色"}],"goods_discount":30,"sku_data":[{"goods_sku_id":121460,"goods_id":121474,"goods_name":"LS(14寸 红色)","goods_price":"98.00","goods_promotion_price":null,"goods_promotion_type":0,"goods_marketprice":"99.00","goods_barcode":"","goods_salenum":7,"spec_name":["尺寸","颜色"],"goods_spec":{"94":"14寸","98":"红色"},"goods_storage":3,"goods_image":"http://web.fl.cn:8088/upload/picture/goodsImage/20190522/262d6ca6d0e0074d4c551dbf8065730b.jpg","evaluation_good_star":5,"evaluation_count":0,"is_fcode":0,"is_presell":0,"have_gift":0,"yggc_sku":"","spec_compose":"94-98"},{"goods_sku_id":121461,"goods_id":121474,"goods_name":"LS(14寸 黑色)","goods_price":"88.00","goods_promotion_price":null,"goods_promotion_type":0,"goods_marketprice":"89.00","goods_barcode":"","goods_salenum":6,"spec_name":["尺寸","颜色"],"goods_spec":{"94":"14寸","99":"黑色"},"goods_storage":4,"goods_image":"http://web.fl.cn:8088/upload/picture/goodsImage/20190522/262d6ca6d0e0074d4c551dbf8065730b.jpg","evaluation_good_star":5,"evaluation_count":0,"is_fcode":0,"is_presell":0,"have_gift":0,"yggc_sku":"","spec_compose":"94-99"},{"goods_sku_id":121466,"goods_id":121474,"goods_name":"LS(15寸 红色)","goods_price":"77.00","goods_promotion_price":null,"goods_promotion_type":0,"goods_marketprice":"77.00","goods_barcode":"","goods_salenum":2,"spec_name":["尺寸","颜色"],"goods_spec":{"95":"15寸","98":"红色"},"goods_storage":0,"goods_image":"http://192.168.0.162:8088/upload/picture/goodsImage/20190527/8d2ca77dc2d421a694e7a847d0d81d84.png","evaluation_good_star":5,"evaluation_count":0,"is_fcode":0,"is_presell":0,"have_gift":0,"yggc_sku":"","spec_compose":"95-98"},{"goods_sku_id":121467,"goods_id":121474,"goods_name":"LS(15寸 黑色)","goods_price":"66.00","goods_promotion_price":null,"goods_promotion_type":0,"goods_marketprice":"66.00","goods_barcode":"","goods_salenum":3,"spec_name":["尺寸","颜色"],"goods_spec":{"95":"15寸","99":"黑色"},"goods_storage":0,"goods_image":"http://192.168.0.162:8088/upload/picture/goodsImage/20190527/18c5e3080b51a16d36beadacd3d438aa.jpg","evaluation_good_star":5,"evaluation_count":0,"is_fcode":0,"is_presell":0,"have_gift":0,"yggc_sku":"","spec_compose":"95-99"}],"goods_id":121474,"goods_image":"http://web.fl.cn:8088/upload/picture/goodsImage/20190522/262d6ca6d0e0074d4c551dbf8065730b.jpg","image_more":[{"big_thumb":"http://web.fl.cn:8088/upload/picture/goodsImage20190522thumbbig_85e80760a06c98be7d60663188cd259e.jpg","medium_thumb":"http://web.fl.cn:8088/upload/picture/goodsImage20190522thumbmedium_85e80760a06c98be7d60663188cd259e.jpg","small_thumb":"http://web.fl.cn:8088/upload/picture/goodsImage20190522thumbsmall_85e80760a06c98be7d60663188cd259e.jpg"}],"favorites":0,"comment":{"listCount":{"all":5,"image":5,"eval_again":3,"good":2,"normal":1,"bad":0,"good_percent":40,"avg_star":"3.0000"},"list":[{"geval_id":5,"geval_goodsid":121474,"geval_goodsname":"富士（FUJIFILM）INSTAX 一次成像相机  MINI相纸（胶片）黑白","geval_scores":1,"geval_content":"asdasdasdas错哦","geval_isanonymous":0,"geval_addtime":"2019-04-04 09:41:05","geval_frommemberid":1,"geval_explain":"好的呢亲","geval_image":"http://img11.360buyimg.com/n1/jfs/t18847/306/478451043/74502/7c02f653/5a83d2edNbfce59aa.jpg","geval_addtime_again":null,"geval_image_again":null,"geval_content_again":null,"geval_explain_again":null,"member_avatar":"/upload/picture/memberImg/20190613/40418a7344852e63d2e0484e6922ae93.png","nickname":"哈哈哈"},{"geval_id":4,"geval_goodsid":121474,"geval_goodsname":"富士（FUJIFILM）INSTAX 一次成像相机  MINI相纸（胶片）黑白","geval_scores":2,"geval_content":"不错哦","geval_isanonymous":0,"geval_addtime":"2019-04-04 09:41:00","geval_frommemberid":1,"geval_explain":"好的呢亲","geval_image":"http://img11.360buyimg.com/n1/jfs/t18847/306/478451043/74502/7c02f653/5a83d2edNbfce59aa.jpg","geval_addtime_again":"2019-04-03 18:09:47","geval_image_again":"http://img11.360buyimg.com/n1/jfs/t18847/306/478451043/74502/7c02f653/5a83d2edNbfce59aa.jpg","geval_content_again":"","geval_explain_again":"好的呢亲","member_avatar":"/upload/picture/memberImg/20190613/40418a7344852e63d2e0484e6922ae93.png","nickname":"哈哈哈"}]}}
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
         * spec_value_ar : [[{"id":94,"val":"14寸"},{"id":95,"val":"15寸"}],[{"id":98,"val":"红色"},{"id":99,"val":"黑色"}]]
         * goods_salenum : 14
         * goods_name : LS
         * goods_marketprice : 88.00
         * goods_price : 99.00
         * store_name : 新增供应商
         * gc_id : 204
         * spec_name : ["尺寸","颜色"]
         * spec_value : [{"94":"14寸","95":"15寸"},{"98":"红色","99":"黑色"}]
         * goods_discount : 30
         * sku_data : [{"goods_sku_id":121460,"goods_id":121474,"goods_name":"LS(14寸 红色)","goods_price":"98.00","goods_promotion_price":null,"goods_promotion_type":0,"goods_marketprice":"99.00","goods_barcode":"","goods_salenum":7,"spec_name":["尺寸","颜色"],"goods_spec":{"94":"14寸","98":"红色"},"goods_storage":3,"goods_image":"http://web.fl.cn:8088/upload/picture/goodsImage/20190522/262d6ca6d0e0074d4c551dbf8065730b.jpg","evaluation_good_star":5,"evaluation_count":0,"is_fcode":0,"is_presell":0,"have_gift":0,"yggc_sku":"","spec_compose":"94-98"},{"goods_sku_id":121461,"goods_id":121474,"goods_name":"LS(14寸 黑色)","goods_price":"88.00","goods_promotion_price":null,"goods_promotion_type":0,"goods_marketprice":"89.00","goods_barcode":"","goods_salenum":6,"spec_name":["尺寸","颜色"],"goods_spec":{"94":"14寸","99":"黑色"},"goods_storage":4,"goods_image":"http://web.fl.cn:8088/upload/picture/goodsImage/20190522/262d6ca6d0e0074d4c551dbf8065730b.jpg","evaluation_good_star":5,"evaluation_count":0,"is_fcode":0,"is_presell":0,"have_gift":0,"yggc_sku":"","spec_compose":"94-99"},{"goods_sku_id":121466,"goods_id":121474,"goods_name":"LS(15寸 红色)","goods_price":"77.00","goods_promotion_price":null,"goods_promotion_type":0,"goods_marketprice":"77.00","goods_barcode":"","goods_salenum":2,"spec_name":["尺寸","颜色"],"goods_spec":{"95":"15寸","98":"红色"},"goods_storage":0,"goods_image":"http://192.168.0.162:8088/upload/picture/goodsImage/20190527/8d2ca77dc2d421a694e7a847d0d81d84.png","evaluation_good_star":5,"evaluation_count":0,"is_fcode":0,"is_presell":0,"have_gift":0,"yggc_sku":"","spec_compose":"95-98"},{"goods_sku_id":121467,"goods_id":121474,"goods_name":"LS(15寸 黑色)","goods_price":"66.00","goods_promotion_price":null,"goods_promotion_type":0,"goods_marketprice":"66.00","goods_barcode":"","goods_salenum":3,"spec_name":["尺寸","颜色"],"goods_spec":{"95":"15寸","99":"黑色"},"goods_storage":0,"goods_image":"http://192.168.0.162:8088/upload/picture/goodsImage/20190527/18c5e3080b51a16d36beadacd3d438aa.jpg","evaluation_good_star":5,"evaluation_count":0,"is_fcode":0,"is_presell":0,"have_gift":0,"yggc_sku":"","spec_compose":"95-99"}]
         * goods_id : 121474
         * goods_image : http://web.fl.cn:8088/upload/picture/goodsImage/20190522/262d6ca6d0e0074d4c551dbf8065730b.jpg
         * image_more : [{"big_thumb":"http://web.fl.cn:8088/upload/picture/goodsImage20190522thumbbig_85e80760a06c98be7d60663188cd259e.jpg","medium_thumb":"http://web.fl.cn:8088/upload/picture/goodsImage20190522thumbmedium_85e80760a06c98be7d60663188cd259e.jpg","small_thumb":"http://web.fl.cn:8088/upload/picture/goodsImage20190522thumbsmall_85e80760a06c98be7d60663188cd259e.jpg"}]
         * favorites : 0
         * comment : {"listCount":{"all":5,"image":5,"eval_again":3,"good":2,"normal":1,"bad":0,"good_percent":40,"avg_star":"3.0000"},"list":[{"geval_id":5,"geval_goodsid":121474,"geval_goodsname":"富士（FUJIFILM）INSTAX 一次成像相机  MINI相纸（胶片）黑白","geval_scores":1,"geval_content":"asdasdasdas错哦","geval_isanonymous":0,"geval_addtime":"2019-04-04 09:41:05","geval_frommemberid":1,"geval_explain":"好的呢亲","geval_image":"http://img11.360buyimg.com/n1/jfs/t18847/306/478451043/74502/7c02f653/5a83d2edNbfce59aa.jpg","geval_addtime_again":null,"geval_image_again":null,"geval_content_again":null,"geval_explain_again":null,"member_avatar":"/upload/picture/memberImg/20190613/40418a7344852e63d2e0484e6922ae93.png","nickname":"哈哈哈"},{"geval_id":4,"geval_goodsid":121474,"geval_goodsname":"富士（FUJIFILM）INSTAX 一次成像相机  MINI相纸（胶片）黑白","geval_scores":2,"geval_content":"不错哦","geval_isanonymous":0,"geval_addtime":"2019-04-04 09:41:00","geval_frommemberid":1,"geval_explain":"好的呢亲","geval_image":"http://img11.360buyimg.com/n1/jfs/t18847/306/478451043/74502/7c02f653/5a83d2edNbfce59aa.jpg","geval_addtime_again":"2019-04-03 18:09:47","geval_image_again":"http://img11.360buyimg.com/n1/jfs/t18847/306/478451043/74502/7c02f653/5a83d2edNbfce59aa.jpg","geval_content_again":"","geval_explain_again":"好的呢亲","member_avatar":"/upload/picture/memberImg/20190613/40418a7344852e63d2e0484e6922ae93.png","nickname":"哈哈哈"}]}
         */

        private int goods_salenum;
        private String goods_name;
        private String goods_marketprice;
        private String goods_price;
        private String store_name;
        private int gc_id;
        private int goods_discount;
        private int goods_id;
        private String goods_image;
        private int favorites;
        private CommentBean comment;
        private List<List<SpecValueArBean>> spec_value_ar;
        private List<String> spec_name;
        private List<SpecValueBean> spec_value;
        private List<SkuDataBean> sku_data;
        private List<ImageMoreBean> image_more;

        public int getGoods_salenum() {
            return goods_salenum;
        }

        public void setGoods_salenum(int goods_salenum) {
            this.goods_salenum = goods_salenum;
        }

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

        public String getStore_name() {
            return store_name;
        }

        public void setStore_name(String store_name) {
            this.store_name = store_name;
        }

        public int getGc_id() {
            return gc_id;
        }

        public void setGc_id(int gc_id) {
            this.gc_id = gc_id;
        }

        public int getGoods_discount() {
            return goods_discount;
        }

        public void setGoods_discount(int goods_discount) {
            this.goods_discount = goods_discount;
        }

        public int getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(int goods_id) {
            this.goods_id = goods_id;
        }

        public String getGoods_image() {
            return goods_image;
        }

        public void setGoods_image(String goods_image) {
            this.goods_image = goods_image;
        }

        public int getFavorites() {
            return favorites;
        }

        public void setFavorites(int favorites) {
            this.favorites = favorites;
        }

        public CommentBean getComment() {
            return comment;
        }

        public void setComment(CommentBean comment) {
            this.comment = comment;
        }

        public List<List<SpecValueArBean>> getSpec_value_ar() {
            return spec_value_ar;
        }

        public void setSpec_value_ar(List<List<SpecValueArBean>> spec_value_ar) {
            this.spec_value_ar = spec_value_ar;
        }

        public List<String> getSpec_name() {
            return spec_name;
        }

        public void setSpec_name(List<String> spec_name) {
            this.spec_name = spec_name;
        }

        public List<SpecValueBean> getSpec_value() {
            return spec_value;
        }

        public void setSpec_value(List<SpecValueBean> spec_value) {
            this.spec_value = spec_value;
        }

        public List<SkuDataBean> getSku_data() {
            return sku_data;
        }

        public void setSku_data(List<SkuDataBean> sku_data) {
            this.sku_data = sku_data;
        }

        public List<ImageMoreBean> getImage_more() {
            return image_more;
        }

        public void setImage_more(List<ImageMoreBean> image_more) {
            this.image_more = image_more;
        }

        public static class CommentBean {
            /**
             * listCount : {"all":5,"image":5,"eval_again":3,"good":2,"normal":1,"bad":0,"good_percent":40,"avg_star":"3.0000"}
             * list : [{"geval_id":5,"geval_goodsid":121474,"geval_goodsname":"富士（FUJIFILM）INSTAX 一次成像相机  MINI相纸（胶片）黑白","geval_scores":1,"geval_content":"asdasdasdas错哦","geval_isanonymous":0,"geval_addtime":"2019-04-04 09:41:05","geval_frommemberid":1,"geval_explain":"好的呢亲","geval_image":"http://img11.360buyimg.com/n1/jfs/t18847/306/478451043/74502/7c02f653/5a83d2edNbfce59aa.jpg","geval_addtime_again":null,"geval_image_again":null,"geval_content_again":null,"geval_explain_again":null,"member_avatar":"/upload/picture/memberImg/20190613/40418a7344852e63d2e0484e6922ae93.png","nickname":"哈哈哈"},{"geval_id":4,"geval_goodsid":121474,"geval_goodsname":"富士（FUJIFILM）INSTAX 一次成像相机  MINI相纸（胶片）黑白","geval_scores":2,"geval_content":"不错哦","geval_isanonymous":0,"geval_addtime":"2019-04-04 09:41:00","geval_frommemberid":1,"geval_explain":"好的呢亲","geval_image":"http://img11.360buyimg.com/n1/jfs/t18847/306/478451043/74502/7c02f653/5a83d2edNbfce59aa.jpg","geval_addtime_again":"2019-04-03 18:09:47","geval_image_again":"http://img11.360buyimg.com/n1/jfs/t18847/306/478451043/74502/7c02f653/5a83d2edNbfce59aa.jpg","geval_content_again":"","geval_explain_again":"好的呢亲","member_avatar":"/upload/picture/memberImg/20190613/40418a7344852e63d2e0484e6922ae93.png","nickname":"哈哈哈"}]
             */

            private ListCountBean listCount;
            private List<ListBean> list;

            public ListCountBean getListCount() {
                return listCount;
            }

            public void setListCount(ListCountBean listCount) {
                this.listCount = listCount;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListCountBean {
                /**
                 * all : 5
                 * image : 5
                 * eval_again : 3
                 * good : 2
                 * normal : 1
                 * bad : 0
                 * good_percent : 40
                 * avg_star : 3.0000
                 */

                private int all;
                private int image;
                private int eval_again;
                private int good;
                private int normal;
                private int bad;
                private int good_percent;
                private String avg_star;

                public int getAll() {
                    return all;
                }

                public void setAll(int all) {
                    this.all = all;
                }

                public int getImage() {
                    return image;
                }

                public void setImage(int image) {
                    this.image = image;
                }

                public int getEval_again() {
                    return eval_again;
                }

                public void setEval_again(int eval_again) {
                    this.eval_again = eval_again;
                }

                public int getGood() {
                    return good;
                }

                public void setGood(int good) {
                    this.good = good;
                }

                public int getNormal() {
                    return normal;
                }

                public void setNormal(int normal) {
                    this.normal = normal;
                }

                public int getBad() {
                    return bad;
                }

                public void setBad(int bad) {
                    this.bad = bad;
                }

                public int getGood_percent() {
                    return good_percent;
                }

                public void setGood_percent(int good_percent) {
                    this.good_percent = good_percent;
                }

                public String getAvg_star() {
                    return avg_star;
                }

                public void setAvg_star(String avg_star) {
                    this.avg_star = avg_star;
                }
            }

            public static class ListBean {
                /**
                 * geval_id : 5
                 * geval_goodsid : 121474
                 * geval_goodsname : 富士（FUJIFILM）INSTAX 一次成像相机  MINI相纸（胶片）黑白
                 * geval_scores : 1
                 * geval_content : asdasdasdas错哦
                 * geval_isanonymous : 0
                 * geval_addtime : 2019-04-04 09:41:05
                 * geval_frommemberid : 1
                 * geval_explain : 好的呢亲
                 * geval_image : http://img11.360buyimg.com/n1/jfs/t18847/306/478451043/74502/7c02f653/5a83d2edNbfce59aa.jpg
                 * geval_addtime_again : null
                 * geval_image_again : null
                 * geval_content_again : null
                 * geval_explain_again : null
                 * member_avatar : /upload/picture/memberImg/20190613/40418a7344852e63d2e0484e6922ae93.png
                 * nickname : 哈哈哈
                 */

                private int geval_id;
                private int geval_goodsid;
                private String geval_goodsname;
                private int geval_scores;
                private String geval_content;
                private int geval_isanonymous;
                private String geval_addtime;
                private int geval_frommemberid;
                private String geval_explain;
                private String geval_image;
                private Object geval_addtime_again;
                private Object geval_image_again;
                private Object geval_content_again;
                private Object geval_explain_again;
                private String member_avatar;
                private String nickname;

                public int getGeval_id() {
                    return geval_id;
                }

                public void setGeval_id(int geval_id) {
                    this.geval_id = geval_id;
                }

                public int getGeval_goodsid() {
                    return geval_goodsid;
                }

                public void setGeval_goodsid(int geval_goodsid) {
                    this.geval_goodsid = geval_goodsid;
                }

                public String getGeval_goodsname() {
                    return geval_goodsname;
                }

                public void setGeval_goodsname(String geval_goodsname) {
                    this.geval_goodsname = geval_goodsname;
                }

                public int getGeval_scores() {
                    return geval_scores;
                }

                public void setGeval_scores(int geval_scores) {
                    this.geval_scores = geval_scores;
                }

                public String getGeval_content() {
                    return geval_content;
                }

                public void setGeval_content(String geval_content) {
                    this.geval_content = geval_content;
                }

                public int getGeval_isanonymous() {
                    return geval_isanonymous;
                }

                public void setGeval_isanonymous(int geval_isanonymous) {
                    this.geval_isanonymous = geval_isanonymous;
                }

                public String getGeval_addtime() {
                    return geval_addtime;
                }

                public void setGeval_addtime(String geval_addtime) {
                    this.geval_addtime = geval_addtime;
                }

                public int getGeval_frommemberid() {
                    return geval_frommemberid;
                }

                public void setGeval_frommemberid(int geval_frommemberid) {
                    this.geval_frommemberid = geval_frommemberid;
                }

                public String getGeval_explain() {
                    return geval_explain;
                }

                public void setGeval_explain(String geval_explain) {
                    this.geval_explain = geval_explain;
                }

                public String getGeval_image() {
                    return geval_image;
                }

                public void setGeval_image(String geval_image) {
                    this.geval_image = geval_image;
                }

                public Object getGeval_addtime_again() {
                    return geval_addtime_again;
                }

                public void setGeval_addtime_again(Object geval_addtime_again) {
                    this.geval_addtime_again = geval_addtime_again;
                }

                public Object getGeval_image_again() {
                    return geval_image_again;
                }

                public void setGeval_image_again(Object geval_image_again) {
                    this.geval_image_again = geval_image_again;
                }

                public Object getGeval_content_again() {
                    return geval_content_again;
                }

                public void setGeval_content_again(Object geval_content_again) {
                    this.geval_content_again = geval_content_again;
                }

                public Object getGeval_explain_again() {
                    return geval_explain_again;
                }

                public void setGeval_explain_again(Object geval_explain_again) {
                    this.geval_explain_again = geval_explain_again;
                }

                public String getMember_avatar() {
                    return member_avatar;
                }

                public void setMember_avatar(String member_avatar) {
                    this.member_avatar = member_avatar;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }
            }
        }

        public static class SpecValueArBean {
            /**
             * id : 94
             * val : 14寸
             */

            private int id;
            private String val;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getVal() {
                return val;
            }

            public void setVal(String val) {
                this.val = val;
            }
        }

        public static class SpecValueBean {
            /**
             * 94 : 14寸
             * 95 : 15寸
             * 98 : 红色
             * 99 : 黑色
             */

            @SerializedName("94")
            private String _$94;
            @SerializedName("95")
            private String _$95;
            @SerializedName("98")
            private String _$98;
            @SerializedName("99")
            private String _$99;

            public String get_$94() {
                return _$94;
            }

            public void set_$94(String _$94) {
                this._$94 = _$94;
            }

            public String get_$95() {
                return _$95;
            }

            public void set_$95(String _$95) {
                this._$95 = _$95;
            }

            public String get_$98() {
                return _$98;
            }

            public void set_$98(String _$98) {
                this._$98 = _$98;
            }

            public String get_$99() {
                return _$99;
            }

            public void set_$99(String _$99) {
                this._$99 = _$99;
            }
        }

        public static class SkuDataBean {
            /**
             * goods_sku_id : 121460
             * goods_id : 121474
             * goods_name : LS(14寸 红色)
             * goods_price : 98.00
             * goods_promotion_price : null
             * goods_promotion_type : 0
             * goods_marketprice : 99.00
             * goods_barcode :
             * goods_salenum : 7
             * spec_name : ["尺寸","颜色"]
             * goods_spec : {"94":"14寸","98":"红色"}
             * goods_storage : 3
             * goods_image : http://web.fl.cn:8088/upload/picture/goodsImage/20190522/262d6ca6d0e0074d4c551dbf8065730b.jpg
             * evaluation_good_star : 5
             * evaluation_count : 0
             * is_fcode : 0
             * is_presell : 0
             * have_gift : 0
             * yggc_sku :
             * spec_compose : 94-98
             */

            private int goods_sku_id;
            private int goods_id;
            private String goods_name;
            private String goods_price;
            private Object goods_promotion_price;
            private int goods_promotion_type;
            private String goods_marketprice;
            private String goods_barcode;
            private int goods_salenum;
            private GoodsSpecBean goods_spec;
            private int goods_storage;
            private String goods_image;
            private int evaluation_good_star;
            private int evaluation_count;
            private int is_fcode;
            private int is_presell;
            private int have_gift;
            private String yggc_sku;
            private String spec_compose;
            private List<String> spec_name;

            public int getGoods_sku_id() {
                return goods_sku_id;
            }

            public void setGoods_sku_id(int goods_sku_id) {
                this.goods_sku_id = goods_sku_id;
            }

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getGoods_price() {
                return goods_price;
            }

            public void setGoods_price(String goods_price) {
                this.goods_price = goods_price;
            }

            public Object getGoods_promotion_price() {
                return goods_promotion_price;
            }

            public void setGoods_promotion_price(Object goods_promotion_price) {
                this.goods_promotion_price = goods_promotion_price;
            }

            public int getGoods_promotion_type() {
                return goods_promotion_type;
            }

            public void setGoods_promotion_type(int goods_promotion_type) {
                this.goods_promotion_type = goods_promotion_type;
            }

            public String getGoods_marketprice() {
                return goods_marketprice;
            }

            public void setGoods_marketprice(String goods_marketprice) {
                this.goods_marketprice = goods_marketprice;
            }

            public String getGoods_barcode() {
                return goods_barcode;
            }

            public void setGoods_barcode(String goods_barcode) {
                this.goods_barcode = goods_barcode;
            }

            public int getGoods_salenum() {
                return goods_salenum;
            }

            public void setGoods_salenum(int goods_salenum) {
                this.goods_salenum = goods_salenum;
            }

            public GoodsSpecBean getGoods_spec() {
                return goods_spec;
            }

            public void setGoods_spec(GoodsSpecBean goods_spec) {
                this.goods_spec = goods_spec;
            }

            public int getGoods_storage() {
                return goods_storage;
            }

            public void setGoods_storage(int goods_storage) {
                this.goods_storage = goods_storage;
            }

            public String getGoods_image() {
                return goods_image;
            }

            public void setGoods_image(String goods_image) {
                this.goods_image = goods_image;
            }

            public int getEvaluation_good_star() {
                return evaluation_good_star;
            }

            public void setEvaluation_good_star(int evaluation_good_star) {
                this.evaluation_good_star = evaluation_good_star;
            }

            public int getEvaluation_count() {
                return evaluation_count;
            }

            public void setEvaluation_count(int evaluation_count) {
                this.evaluation_count = evaluation_count;
            }

            public int getIs_fcode() {
                return is_fcode;
            }

            public void setIs_fcode(int is_fcode) {
                this.is_fcode = is_fcode;
            }

            public int getIs_presell() {
                return is_presell;
            }

            public void setIs_presell(int is_presell) {
                this.is_presell = is_presell;
            }

            public int getHave_gift() {
                return have_gift;
            }

            public void setHave_gift(int have_gift) {
                this.have_gift = have_gift;
            }

            public String getYggc_sku() {
                return yggc_sku;
            }

            public void setYggc_sku(String yggc_sku) {
                this.yggc_sku = yggc_sku;
            }

            public String getSpec_compose() {
                return spec_compose;
            }

            public void setSpec_compose(String spec_compose) {
                this.spec_compose = spec_compose;
            }

            public List<String> getSpec_name() {
                return spec_name;
            }

            public void setSpec_name(List<String> spec_name) {
                this.spec_name = spec_name;
            }

            public static class GoodsSpecBean {
                /**
                 * 94 : 14寸
                 * 98 : 红色
                 */

                @SerializedName("94")
                private String _$94;
                @SerializedName("98")
                private String _$98;

                public String get_$94() {
                    return _$94;
                }

                public void set_$94(String _$94) {
                    this._$94 = _$94;
                }

                public String get_$98() {
                    return _$98;
                }

                public void set_$98(String _$98) {
                    this._$98 = _$98;
                }
            }
        }

        public static class ImageMoreBean {
            /**
             * big_thumb : http://web.fl.cn:8088/upload/picture/goodsImage20190522thumbbig_85e80760a06c98be7d60663188cd259e.jpg
             * medium_thumb : http://web.fl.cn:8088/upload/picture/goodsImage20190522thumbmedium_85e80760a06c98be7d60663188cd259e.jpg
             * small_thumb : http://web.fl.cn:8088/upload/picture/goodsImage20190522thumbsmall_85e80760a06c98be7d60663188cd259e.jpg
             */

            private String big_thumb;
            private String medium_thumb;
            private String small_thumb;

            public String getBig_thumb() {
                return big_thumb;
            }

            public void setBig_thumb(String big_thumb) {
                this.big_thumb = big_thumb;
            }

            public String getMedium_thumb() {
                return medium_thumb;
            }

            public void setMedium_thumb(String medium_thumb) {
                this.medium_thumb = medium_thumb;
            }

            public String getSmall_thumb() {
                return small_thumb;
            }

            public void setSmall_thumb(String small_thumb) {
                this.small_thumb = small_thumb;
            }
        }
    }
}
