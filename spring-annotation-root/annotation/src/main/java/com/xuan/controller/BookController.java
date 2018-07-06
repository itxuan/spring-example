package com.xuan.controller;

import com.xuan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author: xuanzhongliang
 * @Date: 2018/7/5 09:22  七月
 * @Description:
 * @ModifyBy:
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

}
