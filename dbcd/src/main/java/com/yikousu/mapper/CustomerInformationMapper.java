package com.yikousu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yikousu.pojo.CustomerInformation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerInformationMapper extends BaseMapper<CustomerInformation> {
    /**
     * 查询总条数
     */
    int searchCount();
}
