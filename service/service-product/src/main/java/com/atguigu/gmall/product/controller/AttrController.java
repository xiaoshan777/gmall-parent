package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.model.product.BaseAttrValue;
import com.atguigu.gmall.product.service.AttrService;
import com.atguigu.gmall.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author gaoxishan
 * @date 2021/1/22 14:23
 */
@RestController
@RequestMapping("admin/product/")
@CrossOrigin
public class AttrController {
    @Autowired
    private AttrService attrService;
    @RequestMapping("attrInfoList/{category1Id}/{category2Id}/{category3Id}")
    public Result attrInfoList(@PathVariable Long category1Id, @PathVariable Long category2Id, @PathVariable Long category3Id){
        List<BaseAttrInfo> baseAttrInfo =attrService.selectAttr(category3Id);
        return Result.ok(baseAttrInfo);
    }
    @RequestMapping("saveAttrInfo")
    public Result saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo){
        attrService.saveAttrInfo(baseAttrInfo);
        return Result.ok();
    }
    @RequestMapping("getAttrValueList/{attrId}")
    public Result getAttrValueList(@PathVariable Long attrId){
        List<BaseAttrValue> baseAttrValues=attrService.getAttrValueList(attrId);
        return Result.ok(baseAttrValues);
    }
}
