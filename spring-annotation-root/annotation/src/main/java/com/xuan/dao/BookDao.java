package com.xuan.dao;

import org.springframework.stereotype.Repository;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/5 09:23  七月
 * @Description:
 * @ModifyBy:
 */
@Repository
public class BookDao {

    private String flag = "new bean";

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "BookDao{" +
                "flag='" + flag + '\'' +
                '}';
    }
}
