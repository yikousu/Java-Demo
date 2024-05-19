package com.yikousu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yikousu.mapper.CustomerInformationMapper;
import com.yikousu.pojo.CustomerInformation;
import com.yikousu.service.CustomerInformationService;
import org.springframework.stereotype.Service;

@Service
public class CustomerInformationServiceImpl extends ServiceImpl<CustomerInformationMapper, CustomerInformation> implements CustomerInformationService {

}
