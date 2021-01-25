package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.BaseTrademark;
import com.atguigu.gmall.product.mapper.spuMapper.TrademarkMapper;
import com.atguigu.gmall.product.service.TrademarkService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gaoxishan
 * @date 2021/1/22 19:54
 */
@Service
public class TrademarkServiceImpl implements TrademarkService {
    @Autowired
    private TrademarkMapper trademarkMapper;
    @Override
    public IPage<BaseTrademark> getTrademarkList(Long page, Long limit) {
        Page<BaseTrademark> pageParam = new Page<>();
        pageParam.setCurrent(page);
        pageParam.setSize(limit);
        IPage<BaseTrademark> iPage = trademarkMapper.selectPage(pageParam, null);
        return iPage;
    }

    @Override
    public void save(BaseTrademark baseTrademark) {
        trademarkMapper.insert(baseTrademark);
    }

    @Override
    public void remove(Long id) {
        trademarkMapper.deleteById(id);
    }

    @Override
    public BaseTrademark get(Long id) {
        QueryWrapper<BaseTrademark> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        return trademarkMapper.selectById(id);
    }

    @Override
    public void update(BaseTrademark baseTrademark) {
        trademarkMapper.updateById(baseTrademark);
    }

    @Override
    public List<BaseTrademark> getTrademark() {
        List<BaseTrademark> baseTrademarks = trademarkMapper.selectList(null);
        return baseTrademarks;
    }
}
