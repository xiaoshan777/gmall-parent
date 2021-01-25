package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.model.product.BaseSaleAttr;
import com.atguigu.gmall.model.product.SpuInfo;
import com.atguigu.gmall.product.service.SpuService;
import com.atguigu.gmall.result.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author gaoxishan
 * @date 2021/1/22 19:20
 */
@RestController
@RequestMapping("admin/product/")
@CrossOrigin
public class SpuController {
    @Autowired
    private SpuService spuService;
    @RequestMapping("{page}/{limit}")
    public Result spuList(@PathVariable("page") Long page,@PathVariable("limit") Long limit,Long category3Id){
       IPage<SpuInfo> iPage = spuService.spuList(page,limit,category3Id);
       return Result.ok(iPage);
    }
    @RequestMapping("baseSaleAttrList")
    public Result getBaseSaleAttrList(){
        List<BaseSaleAttr> baseSaleAttrList=spuService.getBaseSaleAttrList();
        return Result.ok(baseSaleAttrList);
    }
    @RequestMapping("saveSpuInfo")
    public Result saveSpuInfo(@RequestBody SpuInfo spuInfo){
        spuService.saveSpuInfo(spuInfo);
        return Result.ok();
    }
}
