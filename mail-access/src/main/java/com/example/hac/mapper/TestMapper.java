package com.example.hac.mapper;

import com.example.hac.pojo.Registry;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {

    void saveRegistry(Registry registry);

    Registry selectByEmail(String email);
}
