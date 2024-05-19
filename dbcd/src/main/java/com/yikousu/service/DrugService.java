package com.yikousu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yikousu.config.R;
import com.yikousu.pojo.Drug;

import java.util.List;

public interface DrugService extends IService<Drug> {
    R<String>  searchDrugs();

    List<Drug> searchDrugByName(String drugName);
}
