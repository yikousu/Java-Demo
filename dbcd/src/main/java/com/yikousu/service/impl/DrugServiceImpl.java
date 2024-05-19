package com.yikousu.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yikousu.config.R;
import com.yikousu.mapper.DrugMapper;
import com.yikousu.pojo.Drug;
import com.yikousu.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugServiceImpl extends ServiceImpl<DrugMapper, Drug> implements DrugService {
    @Autowired
    private DrugMapper drugMapper;

    @Override
    public R<String> searchDrugs() {
        List<Drug> drugs = drugMapper.selectList(null);
        return R.success(JSON.toJSONString(drugs));
    }

    @Override
    public List<Drug> searchDrugByName(String drugName) {
        return drugMapper.searchDrugByName(drugName);
    }


}
