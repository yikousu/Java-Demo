package com.yikousu.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yikousu.mapper.IncomingInformationMapper;
import com.yikousu.pojo.IncomingInformation;
import com.yikousu.service.IncomingInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class IncomingInformationServiceImpl extends ServiceImpl<IncomingInformationMapper, IncomingInformation> implements IncomingInformationService {

}
