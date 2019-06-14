package com.example.admin.leiyun_ic.Base;

public interface BaseUrl {

    String uri = "http://www.helibuy.cn/mall_api/index.php?app=wap_index";
    String startUp = "http://fl.weboo.top/member/getVisitorToken";
    String baseUrl ="http://api.weboo.top/index/floor";//
    String iconUrl ="http://api.weboo.top/index/nav";//手机首页导航
    String testUrl="http://www.baidu.com";
    String recyclerViewUrl = "http://api.weboo.top/index/guessLike?per_page=20";//猜你喜欢page= per_page=

    String loginUrl = "http://fl.weboo.top/Member/appLoginByUserName";//登录
    String orderNumUrl = "http://api.weboo.top/Member/getOrderNum";//订单状态数量
    String UserPersonalUrl = "http://api.weboo.top/Member/gerUserInfo";//用户个人信息
    String AddressListUrl = "http://api.weboo.top/Member/getAddressList";//用户地址列表
    String SelectAddressUrl = "http://api.weboo.top/Publicauth/getAllAreaTree";//查询省份地址
    String SubmissionAddressUrl = "http://api.weboo.top/Member/addUserAddress";//提交收货地址
    String modifyAddressUrl = "http://api.weboo.top/Member/saveMemberAddress";//修改收货地址
    String deleteAddressUrl = "http://api.weboo.top/Member/delMemberAddress";//删除地址
    String goodsDetailUrl = "http://api.weboo.top/goods/goodsDetail";//商品详情
    String viewDetailUrl = "http://api.weboo.top/Goods/getGoodsEvaluate";//全部评论详情


}
