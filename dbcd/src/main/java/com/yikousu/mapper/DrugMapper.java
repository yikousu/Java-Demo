package com.yikousu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yikousu.pojo.Drug;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DrugMapper extends BaseMapper<Drug> {
    List<Drug> searchDrugByName(String drugName);
}
