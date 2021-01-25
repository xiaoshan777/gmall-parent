package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.model.product.BaseTrademark;
import com.atguigu.gmall.product.service.TrademarkService;
import com.atguigu.gmall.result.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author gaoxishan
 * @date 2021/1/22 19:48
 */
@RestController
@RequestMapping("admin/product/")
@CrossOrigin
public class TrademarkController {
    @Autowired
    private TrademarkService trademarkService;
    @RequestMapping("baseTrademark/{page}/{limit}")
    public Result getTrademarkList(@PathVariable("page") Long page, @PathVariable("limit") Long limit){
       IPage<BaseTrademark> ipage =trademarkService.getTrademarkList(page,limit);
       return Result.ok(ipage);
    }
    @RequestMapping("baseTrademark/save")
    public Result save(@RequestBody BaseTrademark baseTrademark){
        trademarkService.save(baseTrademark);
        return Result.ok();
    }
    @DeleteMapping("baseTrademark/remove/{id}")
    public Result remove(@PathVariable Long id){
        trademarkService.remove(id);
        return Result.ok();
    }
    @GetMapping("baseTrademark/get/{id}")
    public Result get(@PathVariable Long id){
       BaseTrademark baseTrademark =trademarkService.get(id);
       return Result.ok(baseTrademark);
    }
    @PutMapping("baseTrademark/update")
    public Result update(@RequestBody BaseTrademark baseTrademark){
        trademarkService.update(baseTrademark);
        return Result.ok();
    }
    @RequestMapping("baseTrademark/getTrademarkList")
    public Result getTrademarkList(){
        List<BaseTrademark> baseTrademarks=trademarkService.getTrademark();
        return Result.ok(baseTrademarks);
    }
}
