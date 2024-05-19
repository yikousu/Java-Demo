package com.yikousu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yikousu.pojo.Drug;
import com.yikousu.pojo.IncomingInformation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IncomingInformationMapper extends BaseMapper<IncomingInformation> {
    Drug residuleById(int id);
}
