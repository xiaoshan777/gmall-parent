package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.BaseTrademark;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * @author gaoxishan
 * @date 2021/1/22 19:54
 */
public interface TrademarkService {
    IPage<BaseTrademark> getTrademarkList(Long page, Long limit);

    void save(BaseTrademark baseTrademark);

    void remove(Long id);

    BaseTrademark get(Long id);

    void update(BaseTrademark baseTrademark);

    List<BaseTrademark> getTrademark();
}
