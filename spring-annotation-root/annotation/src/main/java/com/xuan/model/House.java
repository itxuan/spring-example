package com.xuan.model;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/18 11:33  七月
 * @Description:
 * @ModifyBy:
 */
public class House {

    private Long id;

    private String name;

    private LocalDateTime createTime;

    private String area;

    private int isDelete;

    private String houseType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }
}
