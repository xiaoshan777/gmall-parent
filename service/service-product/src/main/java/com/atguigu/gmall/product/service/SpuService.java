package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.BaseSaleAttr;
import com.atguigu.gmall.model.product.SpuInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * @author gaoxishan
 * @date 2021/1/22 19:25
 */
public interface SpuService {
    IPage<SpuInfo> spuList(Long page, Long limit, Long category3Id);

    List<BaseSaleAttr> getBaseSaleAttrList();

    void saveSpuInfo(SpuInfo spuInfo);
}
