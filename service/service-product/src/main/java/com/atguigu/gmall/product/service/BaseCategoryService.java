package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.BaseCategory1;
import com.atguigu.gmall.model.product.BaseCategory2;
import com.atguigu.gmall.model.product.BaseCategory3;

import java.util.List;

/**
 * @author gaoxishan
 * @date 2021/1/22 12:18
 */
public interface BaseCategoryService {
    List<BaseCategory1> selectGetCategory1();

    List<BaseCategory2> selectGetCategory2(Long category1Id);

    List<BaseCategory3> selectGetCategory3(Long category2Id);
}
