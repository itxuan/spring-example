package com.xuan.service;

import com.xuan.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/5 09:23  七月
 * @Description:
 * @ModifyBy:
 */
@Service
public class BookService {

//    @Qualifier("bookDao1104")  //用来测试  (required = false)
//    @Autowired(required = false)

    //name 来指定要注入的组件 按名称查找
//    @Resource(name = "bookDao")
    @Inject
    private BookDao bookDao;

    public void print(){
        System.out.println("BookService...print..." + bookDao);
    }

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao +
                '}';
    }
}
