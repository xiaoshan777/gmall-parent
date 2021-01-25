package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.model.product.BaseCategory1;
import com.atguigu.gmall.model.product.BaseCategory2;
import com.atguigu.gmall.model.product.BaseCategory3;
import com.atguigu.gmall.product.service.BaseCategoryService;
import com.atguigu.gmall.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author gaoxishan
 * @date 2021/1/20 18:16
 */
@RestController
@RequestMapping("admin/product/")
@CrossOrigin
public class BaseCategoryController {
    @Autowired
    private BaseCategoryService baseGetCategory1;
    @RequestMapping("getCategory1")
    public Result getCategory1(){
       List<BaseCategory1> baseCategory1 =baseGetCategory1.selectGetCategory1();
        return Result.ok(baseCategory1);
    }
    //111
    @RequestMapping("getCategory2/{category1Id}")
    public Result getCategory2(@PathVariable Long category1Id){
        List<BaseCategory2> baseCategory2 =baseGetCategory1.selectGetCategory2(category1Id);
        return Result.ok(baseCategory2);
    }
    @RequestMapping("getCategory3/{category2Id}")
    public Result getCategory3(@PathVariable Long category2Id){
        List<BaseCategory3> baseCategory3 =baseGetCategory1.selectGetCategory3(category2Id);
        return Result.ok(baseCategory3);
    }

}
