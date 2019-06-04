package com.example.admin.leiyun_ic.HomePage.model;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    public long id;

    public String name;

    public int hasFollow;

    public String imageUrl;

    public int isLeaf;

    public List<Category> subCategoryList;

    /** 判断是否为二级分类 */
    public boolean isSubCategory() {
        return isLeaf == 1;
    }
}
