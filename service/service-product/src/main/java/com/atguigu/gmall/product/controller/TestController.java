package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.result.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;

/**
 * @author gaoxishan
 * @date 2021/1/20 18:16
 */
@RestController
@RequestMapping("admin/product/")
@CrossOrigin
public class TestController {
    @RequestMapping("test")
    public String test(){
        return "123";
    }
    @RequestMapping("getCategory1")
    public Result getCategory1(){
        return Result.ok("123");
    }
}
