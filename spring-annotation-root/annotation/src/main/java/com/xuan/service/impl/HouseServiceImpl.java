package com.xuan.service.impl;

import com.xuan.dao.HouseDao;
import com.xuan.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/18 11:03  七月
 * @Description:
 * @ModifyBy:
 */
@Transactional
@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    HouseDao houseDao;
    @Override
    public void insert() {
        houseDao.insert();
        int i = 10/0;
    }

    @Override
    public void delete() {

    }
}
