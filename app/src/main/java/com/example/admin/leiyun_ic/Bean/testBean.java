package com.example.admin.leiyun_ic.Bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class testBean {


    /**
     * code : 200
     * msg : 操作成功
     * data : {"0":[[1,"北京"],[2,"天津"],[3,"河北"],[4,"山西"],[5,"内蒙古"],[6,"辽宁"],[7,"吉林"],[8,"黑龙江"],[9,"上海"],[10,"江苏"],[11,"浙江"],[12,"安徽"],[13,"福建"],[14,"江西"],[15,"山东"],[16,"河南"],[17,"湖北"],[18,"湖南"],[19,"广东"],[20,"广西"],[21,"海南"],[22,"重庆"],[23,"四川"],[24,"贵州"],[25,"云南"],[26,"西藏"],[27,"陕西"],[28,"甘肃"],[29,"青海"],[30,"宁夏"],[31,"新疆"],[32,"台湾"],[33,"香港"],[34,"澳门"],[35,"海外"]],"1":[[36,"北京市"]],"36":[[37,"东城区"],[38,"西城区"],[41,"朝阳区"],[42,"丰台区"],[43,"石景山区"],[44,"海淀区"],[45,"门头沟区"],[46,"房山区"],[47,"通州区"],[48,"顺义区"],[49,"昌平区"],[50,"大兴区"],[51,"怀柔区"],[52,"平谷区"],[53,"密云县"],[54,"延庆县"],[566,"其他"]],"9":[[39,"上海市"]],"2":[[40,"天津市"]],"40":[[55,"和平区"],[56,"河东区"],[57,"河西区"],[58,"南开区"],[59,"河北区"],[60,"红桥区"],[61,"塘沽区"],[64,"东丽区"],[65,"西青区"],[66,"津南区"],[67,"北辰区"],[68,"武清区"],[69,"宝坻区"],[70,"宁河县"],[71,"静海县"],[72,"蓟县"]],"22":[[62,"重庆市"]],"3":[[73,"石家庄市"],[74,"唐山市"],[75,"秦皇岛市"],[76,"邯郸市"],[77,"邢台市"],[78,"保定市"],[79,"张家口市"],[80,"承德市"],[81,"衡水市"],[82,"廊坊市"],[83,"沧州市"]],"4":[[84,"太原市"],[85,"大同市"],[86,"阳泉市"],[87,"长治市"],[88,"晋城市"],[89,"朔州市"],[90,"晋中市"],[91,"运城市"],[92,"忻州市"],[93,"临汾市"],[94,"吕梁市"]]}
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
        @SerializedName("0")
        private List<List<Integer>> _$0;
        @SerializedName("1")
        private List<List<Integer>> _$1;
        @SerializedName("36")
        private List<List<Integer>> _$36;
        @SerializedName("9")
        private List<List<Integer>> _$9;
        @SerializedName("2")
        private List<List<Integer>> _$2;
        @SerializedName("40")
        private List<List<Integer>> _$40;
        @SerializedName("22")
        private List<List<Integer>> _$22;
        @SerializedName("3")
        private List<List<Integer>> _$3;
        @SerializedName("4")
        private List<List<Integer>> _$4;

        public List<List<Integer>> get_$0() {
            return _$0;
        }

        public void set_$0(List<List<Integer>> _$0) {
            this._$0 = _$0;
        }

        public List<List<Integer>> get_$1() {
            return _$1;
        }

        public void set_$1(List<List<Integer>> _$1) {
            this._$1 = _$1;
        }

        public List<List<Integer>> get_$36() {
            return _$36;
        }

        public void set_$36(List<List<Integer>> _$36) {
            this._$36 = _$36;
        }

        public List<List<Integer>> get_$9() {
            return _$9;
        }

        public void set_$9(List<List<Integer>> _$9) {
            this._$9 = _$9;
        }

        public List<List<Integer>> get_$2() {
            return _$2;
        }

        public void set_$2(List<List<Integer>> _$2) {
            this._$2 = _$2;
        }

        public List<List<Integer>> get_$40() {
            return _$40;
        }

        public void set_$40(List<List<Integer>> _$40) {
            this._$40 = _$40;
        }

        public List<List<Integer>> get_$22() {
            return _$22;
        }

        public void set_$22(List<List<Integer>> _$22) {
            this._$22 = _$22;
        }

        public List<List<Integer>> get_$3() {
            return _$3;
        }

        public void set_$3(List<List<Integer>> _$3) {
            this._$3 = _$3;
        }

        public List<List<Integer>> get_$4() {
            return _$4;
        }

        public void set_$4(List<List<Integer>> _$4) {
            this._$4 = _$4;
        }
    }
}
