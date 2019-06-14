package com.example.admin.leiyun_ic.Details.Bean;

import java.util.List;

public class ViewDetailBean {


    /**
     * code : 200
     * msg : 请求成功
     * data : {"listCount":{"all":5,"image":5,"eval_again":3,"good":2,"normal":1,"bad":0,"good_percent":40,"avg_star":"3.0000"},"list":[{"geval_id":5,"geval_goodsid":121474,"geval_goodsname":"富士（FUJIFILM）INSTAX 一次成像相机  MINI相纸（胶片）黑白","geval_scores":1,"geval_content":"asdasdasdas错哦","geval_isanonymous":0,"geval_addtime":1554342065,"geval_frommemberid":1,"geval_explain":"好的呢亲","geval_addtime_again":null,"geval_content_again":null,"geval_explain_again":null,"member_avatar":"/upload/picture/memberImg/20190613/40418a7344852e63d2e0484e6922ae93.png","nickname":"哈哈哈","geval_image":["http://img11.360buyimg.com/n1/jfs/t18847/306/478451043/74502/7c02f653/5a83d2edNbfce59aa.jpg"],"geval_image_again":[null]},{"geval_id":4,"geval_goodsid":121474,"geval_goodsname":"富士（FUJIFILM）INSTAX 一次成像相机  MINI相纸（胶片）黑白","geval_scores":2,"geval_content":"不错哦","geval_isanonymous":0,"geval_addtime":1554342060,"geval_frommemberid":1,"geval_explain":"好的呢亲","geval_addtime_again":"1554286187","geval_content_again":"","geval_explain_again":"好的呢亲","member_avatar":"/upload/picture/memberImg/20190613/40418a7344852e63d2e0484e6922ae93.png","nickname":"哈哈哈","geval_image":["http://img11.360buyimg.com/n1/jfs/t18847/306/478451043/74502/7c02f653/5a83d2edNbfce59aa.jpg"],"geval_image_again":["http://img11.360buyimg.com/n1/jfs/t18847/306/478451043/74502/7c02f653/5a83d2edNbfce59aa.jpg"]},{"geval_id":3,"geval_goodsid":121474,"geval_goodsname":"富士（FUJIFILM）INSTAX 一次成像相机  MINI相纸（胶片）黑白","geval_scores":3,"geval_content":"评价测试","geval_isanonymous":0,"geval_addtime":1554281155,"geval_frommemberid":1,"geval_explain":"好的呢亲","geval_addtime_again":"1554286187","geval_content_again":"不错哦","geval_explain_again":"好的呢亲","member_avatar":"/upload/picture/memberImg/20190613/40418a7344852e63d2e0484e6922ae93.png","nickname":"哈哈哈","geval_image":["http://img11.360buyimg.com/n1/jfs/t18847/306/478451043/74502/7c02f653/5a83d2edNbfce59aa.jpg"],"geval_image_again":["http://img11.360buyimg.com/n1/jfs/t18847/306/478451043/74502/7c02f653/5a83d2edNbfce59aa.jpg"]},{"geval_id":2,"geval_goodsid":121474,"geval_goodsname":"康佳 电视机 LED43G30AE 43寸 分辨率1920*1080 配底座 智能电视","geval_scores":4,"geval_content":"还不错吧","geval_isanonymous":1,"geval_addtime":1553668489,"geval_frommemberid":1,"geval_explain":"好的呢亲","geval_addtime_again":"1553668722","geval_content_again":"就追加一个看看","geval_explain_again":"好的呢亲","member_avatar":"","nickname":"匿名","geval_frommembername":"匿名","geval_image":["http://img11.360buyimg.com/n1/jfs/t18847/306/478451043/74502/7c02f653/5a83d2edNbfce59aa.jpg"],"geval_image_again":["http://img11.360buyimg.com/n1/jfs/t18847/306/478451043/74502/7c02f653/5a83d2edNbfce59aa.jpg"]},{"geval_id":1,"geval_goodsid":121474,"geval_goodsname":"戴尔(DELL)灵越3670\u201c吃鸡\u201d游戏台式电脑主机","geval_scores":5,"geval_content":"很好用呢","geval_isanonymous":1,"geval_addtime":1553668489,"geval_frommemberid":1,"geval_explain":"好的呢亲","geval_addtime_again":"1553668722","geval_content_again":"我还是追加看看","geval_explain_again":"好的呢亲","member_avatar":"","nickname":"匿名","geval_frommembername":"匿名","geval_image":["http://img11.360buyimg.com/n1/jfs/t18847/306/478451043/74502/7c02f653/5a83d2edNbfce59aa.jpg"],"geval_image_again":["http://img11.360buyimg.com/n1/jfs/t18847/306/478451043/74502/7c02f653/5a83d2edNbfce59aa.jpg"]}],"per_page":"10","current_page":"1","total_page":1,"total_item":5}
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
         * listCount : {"all":5,"image":5,"eval_again":3,"good":2,"normal":1,"bad":0,"good_percent":40,"avg_star":"3.0000"}
         * list : [{"geval_id":5,"geval_goodsid":121474,"geval_goodsname":"富士（FUJIFILM）INSTAX 一次成像相机  MINI相纸（胶片）黑白","geval_scores":1,"geval_content":"asdasdasdas错哦","geval_isanonymous":0,"geval_addtime":1554342065,"geval_frommemberid":1,"geval_explain":"好的呢亲","geval_addtime_again":null,"geval_content_again":null,"geval_explain_again":null,"member_avatar":"/upload/picture/memberImg/20190613/40418a7344852e63d2e0484e6922ae93.png","nickname":"哈哈哈","geval_image":["http://img11.360buyimg.com/n1/jfs/t18847/306/478451043/74502/7c02f653/5a83d2edNbfce59aa.jpg"],"geval_image_again":[null]},{"geval_id":4,"geval_goodsid":121474,"geval_goodsname":"富士（FUJIFILM）INSTAX 一次成像相机  MINI相纸（胶片）黑白","geval_scores":2,"geval_content":"不错哦","geval_isanonymous":0,"geval_addtime":1554342060,"geval_frommemberid":1,"geval_explain":"好的呢亲","geval_addtime_again":"1554286187","geval_content_again":"","geval_explain_again":"好的呢亲","member_avatar":"/upload/picture/memberImg/20190613/40418a7344852e63d2e0484e6922ae93.png","nickname":"哈哈哈","geval_image":["http://img11.360buyimg.com/n1/jfs/t18847/306/478451043/74502/7c02f653/5a83d2edNbfce59aa.jpg"],"geval_image_again":["http://img11.360buyimg.com/n1/jfs/t18847/306/478451043/74502/7c02f653/5a83d2edNbfce59aa.jpg"]},{"geval_id":3,"geval_goodsid":121474,"geval_goodsname":"富士（FUJIFILM）INSTAX 一次成像相机  MINI相纸（胶片）黑白","geval_scores":3,"geval_content":"评价测试","geval_isanonymous":0,"geval_addtime":1554281155,"geval_frommemberid":1,"geval_explain":"好的呢亲","geval_addtime_again":"1554286187","geval_content_again":"不错哦","geval_explain_again":"好的呢亲","member_avatar":"/upload/picture/memberImg/20190613/40418a7344852e63d2e0484e6922ae93.png","nickname":"哈哈哈","geval_image":["http://img11.360buyimg.com/n1/jfs/t18847/306/478451043/74502/7c02f653/5a83d2edNbfce59aa.jpg"],"geval_image_again":["http://img11.360buyimg.com/n1/jfs/t18847/306/478451043/74502/7c02f653/5a83d2edNbfce59aa.jpg"]},{"geval_id":2,"geval_goodsid":121474,"geval_goodsname":"康佳 电视机 LED43G30AE 43寸 分辨率1920*1080 配底座 智能电视","geval_scores":4,"geval_content":"还不错吧","geval_isanonymous":1,"geval_addtime":1553668489,"geval_frommemberid":1,"geval_explain":"好的呢亲","geval_addtime_again":"1553668722","geval_content_again":"就追加一个看看","geval_explain_again":"好的呢亲","member_avatar":"","nickname":"匿名","geval_frommembername":"匿名","geval_image":["http://img11.360buyimg.com/n1/jfs/t18847/306/478451043/74502/7c02f653/5a83d2edNbfce59aa.jpg"],"geval_image_again":["http://img11.360buyimg.com/n1/jfs/t18847/306/478451043/74502/7c02f653/5a83d2edNbfce59aa.jpg"]},{"geval_id":1,"geval_goodsid":121474,"geval_goodsname":"戴尔(DELL)灵越3670\u201c吃鸡\u201d游戏台式电脑主机","geval_scores":5,"geval_content":"很好用呢","geval_isanonymous":1,"geval_addtime":1553668489,"geval_frommemberid":1,"geval_explain":"好的呢亲","geval_addtime_again":"1553668722","geval_content_again":"我还是追加看看","geval_explain_again":"好的呢亲","member_avatar":"","nickname":"匿名","geval_frommembername":"匿名","geval_image":["http://img11.360buyimg.com/n1/jfs/t18847/306/478451043/74502/7c02f653/5a83d2edNbfce59aa.jpg"],"geval_image_again":["http://img11.360buyimg.com/n1/jfs/t18847/306/478451043/74502/7c02f653/5a83d2edNbfce59aa.jpg"]}]
         * per_page : 10
         * current_page : 1
         * total_page : 1
         * total_item : 5
         */

        private ListCountBean listCount;
        private String per_page;
        private String current_page;
        private int total_page;
        private int total_item;
        private List<ListBean> list;

        public ListCountBean getListCount() {
            return listCount;
        }

        public void setListCount(ListCountBean listCount) {
            this.listCount = listCount;
        }

        public String getPer_page() {
            return per_page;
        }

        public void setPer_page(String per_page) {
            this.per_page = per_page;
        }

        public String getCurrent_page() {
            return current_page;
        }

        public void setCurrent_page(String current_page) {
            this.current_page = current_page;
        }

        public int getTotal_page() {
            return total_page;
        }

        public void setTotal_page(int total_page) {
            this.total_page = total_page;
        }

        public int getTotal_item() {
            return total_item;
        }

        public void setTotal_item(int total_item) {
            this.total_item = total_item;
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
             * geval_addtime : 1554342065
             * geval_frommemberid : 1
             * geval_explain : 好的呢亲
             * geval_addtime_again : null
             * geval_content_again : null
             * geval_explain_again : null
             * member_avatar : /upload/picture/memberImg/20190613/40418a7344852e63d2e0484e6922ae93.png
             * nickname : 哈哈哈
             * geval_image : ["http://img11.360buyimg.com/n1/jfs/t18847/306/478451043/74502/7c02f653/5a83d2edNbfce59aa.jpg"]
             * geval_image_again : [null]
             * geval_frommembername : 匿名
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
            private Object geval_addtime_again;
            private Object geval_content_again;
            private Object geval_explain_again;
            private String member_avatar;
            private String nickname;
            private String geval_frommembername;
            private List<String> geval_image;
            private List<String> geval_image_again;

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

            public Object getGeval_addtime_again() {
                return geval_addtime_again;
            }

            public void setGeval_addtime_again(Object geval_addtime_again) {
                this.geval_addtime_again = geval_addtime_again;
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

            public String getGeval_frommembername() {
                return geval_frommembername;
            }

            public void setGeval_frommembername(String geval_frommembername) {
                this.geval_frommembername = geval_frommembername;
            }

            public List<String> getGeval_image() {
                return geval_image;
            }

            public void setGeval_image(List<String> geval_image) {
                this.geval_image = geval_image;
            }

            public List<String> getGeval_image_again() {
                return geval_image_again;
            }

            public void setGeval_image_again(List<String> geval_image_again) {
                this.geval_image_again = geval_image_again;
            }
        }
    }
}
