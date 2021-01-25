package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.BaseCategory1;
import com.atguigu.gmall.model.product.BaseCategory2;
import com.atguigu.gmall.model.product.BaseCategory3;
import com.atguigu.gmall.product.mapper.BaseCategoryMapper.BaseCategory1Mapper;
import com.atguigu.gmall.product.mapper.BaseCategoryMapper.BaseCategory2Mapper;
import com.atguigu.gmall.product.mapper.BaseCategoryMapper.BaseCategory3Mapper;
import com.atguigu.gmall.product.service.BaseCategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gaoxishan
 * @date 2021/1/22 12:21
 */
@Service
public class BaseCategoryServiceImpl implements BaseCategoryService {

    @Autowired
    private BaseCategory1Mapper baseCategory1Mapper;
    @Autowired
    private BaseCategory2Mapper baseCategory2Mapper;
    @Autowired
    private BaseCategory3Mapper baseCategory3Mapper;
    @Override
    public List<BaseCategory1> selectGetCategory1() {
        List<BaseCategory1> baseCategory1 = baseCategory1Mapper.selectList(null);
        return baseCategory1;
    }

    @Override
    public List<BaseCategory2> selectGetCategory2(Long category1Id) {
        QueryWrapper<BaseCategory2> wrapper = new QueryWrapper<>();
        wrapper.eq("category1_id",category1Id);
        List<BaseCategory2> baseCategory2 = baseCategory2Mapper.selectList(wrapper);
        return baseCategory2;
    }

    @Override
    public List<BaseCategory3> selectGetCategory3(Long category2Id) {
        QueryWrapper<BaseCategory3> wrapper = new QueryWrapper<>();
        wrapper.eq("category2_id",category2Id);
        List<BaseCategory3> baseCategory3 = baseCategory3Mapper.selectList(wrapper);
        return baseCategory3;
    }
}
