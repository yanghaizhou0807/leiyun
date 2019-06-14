package com.example.admin.leiyun_ic.Bean;

import java.util.List;

public class ProvincialCityListBean {


    /**
     * rs_code : 1000
     * rs_msg : 请求成功
     * details : [
     * {"id":110000,"val":"北京",
     * "data":[
     * {"id":110100,"val":"北京市",
     * "data":[
     * {"id":110101,"val":"东城区"},
     * {"id":110102,"val":"西城区"},
     * {"id":110103,"val":"崇文区"},
     * {"id":110104,"val":"宣武区"},
     * {"id":110105,"val":"朝阳区"},
     * {"id":110106,"val":"丰台区"},
     * {"id":110107,"val":"石景山区"},
     * {"id":110108,"val":"海淀区"},
     * {"id":110109,"val":"门头沟区"},
     * {"id":110111,"val":"房山区"},
     * {"id":110112,"val":"通州区"},
     * {"id":110113,"val":"顺义区"},
     * {"id":110114,"val":"昌平区"},
     * {"id":110115,"val":"大兴区"},
     * {"id":110116,"val":"怀柔区"},
     * {"id":110117,"val":"平谷区"},
     * {"id":110228,"val":"密云县"},
     * {"id":110229,"val":"延庆县"}
     * ]}
     * ]}
     * */

    private String rs_code;
    private String rs_msg;
    private List<DetailsBean> details;

    public String getRs_code() {
        return rs_code;
    }

    public void setRs_code(String rs_code) {
        this.rs_code = rs_code;
    }

    public String getRs_msg() {
        return rs_msg;
    }

    public void setRs_msg(String rs_msg) {
        this.rs_msg = rs_msg;
    }

    public List<DetailsBean> getDetails() {
        return details;
    }

    public void setDetails(List<DetailsBean> details) {
        this.details = details;
    }

    public static class DetailsBean {
        /**
         * id : 110000
         * val : 北京
         * data : [{"id":110100,"val":"北京市","data":[{"id":110101,"val":"东城区"},{"id":110102,"val":"西城区"},{"id":110103,"val":"崇文区"},{"id":110104,"val":"宣武区"},{"id":110105,"val":"朝阳区"},{"id":110106,"val":"丰台区"},{"id":110107,"val":"石景山区"},{"id":110108,"val":"海淀区"},{"id":110109,"val":"门头沟区"},{"id":110111,"val":"房山区"},{"id":110112,"val":"通州区"},{"id":110113,"val":"顺义区"},{"id":110114,"val":"昌平区"},{"id":110115,"val":"大兴区"},{"id":110116,"val":"怀柔区"},{"id":110117,"val":"平谷区"},{"id":110228,"val":"密云县"},{"id":110229,"val":"延庆县"}]}]
         */

        private int id;
        private String val;
        private List<DataBeanX> data;

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

        public List<DataBeanX> getData() {
            return data;
        }

        public void setData(List<DataBeanX> data) {
            this.data = data;
        }

        public static class DataBeanX {
            /**
             * id : 110100
             * val : 北京市
             * data : [{"id":110101,"val":"东城区"},{"id":110102,"val":"西城区"},{"id":110103,"val":"崇文区"},{"id":110104,"val":"宣武区"},{"id":110105,"val":"朝阳区"},{"id":110106,"val":"丰台区"},{"id":110107,"val":"石景山区"},{"id":110108,"val":"海淀区"},{"id":110109,"val":"门头沟区"},{"id":110111,"val":"房山区"},{"id":110112,"val":"通州区"},{"id":110113,"val":"顺义区"},{"id":110114,"val":"昌平区"},{"id":110115,"val":"大兴区"},{"id":110116,"val":"怀柔区"},{"id":110117,"val":"平谷区"},{"id":110228,"val":"密云县"},{"id":110229,"val":"延庆县"}]
             */

            private int id;
            private String val;
            private List<DataBean> data;

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

            public List<DataBean> getData() {
                return data;
            }

            public void setData(List<DataBean> data) {
                this.data = data;
            }

            public static class DataBean {
                /**
                 * id : 110101
                 * val : 东城区
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
        }
    }
}
