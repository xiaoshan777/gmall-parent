package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.model.product.BaseAttrValue;
import com.atguigu.gmall.product.mapper.attrMapper.AttrMapper;
import com.atguigu.gmall.product.mapper.attrMapper.BaseAttrValueMapper;
import com.atguigu.gmall.product.service.AttrService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gaoxishan
 * @date 2021/1/22 14:28
 */
@Service
public class AttrServiceImpl implements AttrService {
    @Autowired
    private AttrMapper attrMapper;
    @Autowired
    BaseAttrValueMapper baseAttrValueMapper;
    @Override
    public List<BaseAttrInfo> selectAttr(Long category3Id) {
        QueryWrapper<BaseAttrInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("category_id",category3Id);
        List<BaseAttrInfo> baseAttrInfos = attrMapper.selectList(wrapper);
        if(baseAttrInfos!=null&&baseAttrInfos.size()>0){
            for (BaseAttrInfo baseAttrInfo : baseAttrInfos) {
                Long attrInfoId = baseAttrInfo.getId();
                QueryWrapper<BaseAttrValue> wrapper1 = new QueryWrapper<>();
                wrapper1.eq("attr_id",attrInfoId);
                List<BaseAttrValue> baseAttrValues = baseAttrValueMapper.selectList(wrapper1);
                baseAttrInfo.setAttrValueList(baseAttrValues);
            }
        }
        return baseAttrInfos;
    }

    @Override
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {
        Long id = baseAttrInfo.getId();
        if(id!=null&&id!=-1){
            //删除+新增=修改
            // 删除+新增=修改
            QueryWrapper<BaseAttrValue> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("attr_id",id);
            baseAttrValueMapper.delete(queryWrapper);
        }else{
            //保存
            attrMapper.insert(baseAttrInfo);
            Long attr_id=baseAttrInfo.getId();
            id = attr_id;
        }
        List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();
        if(attrValueList!=null&&attrValueList.size()>0) {
            for (BaseAttrValue baseAttrValue : attrValueList) {
                baseAttrValue.setAttrId(id);
                baseAttrValueMapper.insert(baseAttrValue);
            }
        }
    }

    @Override
    public List<BaseAttrValue> getAttrValueList(Long attrId) {
        QueryWrapper<BaseAttrValue> wrapper = new QueryWrapper<>();
        wrapper.eq("attr_id",attrId);
        List<BaseAttrValue> baseAttrValues = baseAttrValueMapper.selectList(wrapper);
        return baseAttrValues;
    }
}
