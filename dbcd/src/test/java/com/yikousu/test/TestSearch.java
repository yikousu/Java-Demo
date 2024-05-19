package com.yikousu.test;

import com.yikousu.DBCDApplication;
import com.yikousu.mapper.CustomerInformationMapper;
import com.yikousu.mapper.IncomingInformationMapper;
import com.yikousu.pojo.CustomerInformation;
import com.yikousu.pojo.Drug;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = DBCDApplication.class)
@RunWith(SpringRunner.class)
public class TestSearch {
    @Autowired
    private CustomerInformationMapper customerInformationMapper ;
    @Autowired
    private IncomingInformationMapper incomingInformationMapper;

    @Test
    public void searchCount() {
        int count = customerInformationMapper.searchCount();
        System.out.println("数据总条数:"+count);

    }

    @Test
    public void test(){
        List<CustomerInformation> customerInformations = customerInformationMapper.selectList(null);
        for (CustomerInformation customerInformation : customerInformations) {
            System.out.println(customerInformation);
        }
    }

    @Test
    public void Residule(){
        Drug drug = incomingInformationMapper.residuleById(3);
        System.out.println(drug.getDrugName()+":"+drug.getQuantity());
    }
}
