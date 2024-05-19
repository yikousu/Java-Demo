package com.yikousu.controller;

import com.alibaba.fastjson.JSON;
import com.yikousu.config.R;
import com.yikousu.mapper.DrugMapper;
import com.yikousu.pojo.Drug;
import com.yikousu.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping(value = "/api")
public class DrugController {
    @Autowired
    private DrugService drugService;
    @Autowired
    private DrugMapper drugMapper;

    /**
     * 测试
     */
    @GetMapping(value="/sh")
    public R fun(){

        return  R.success(drugMapper.selectList(null));
    }

    /**
     * 查所有
     */
    @GetMapping(value = "/drugs")
    public R<String> searchDrugs() {
        return drugService.searchDrugs();
    }

    /**
     * 删除一行
     */
    @DeleteMapping(value = "/drugs/{id}")
    public R deleteById(@PathVariable(value = "id") Integer id) {
        drugMapper.deleteById(id);
        return R.success("删除成功");
    }

    /**
     * 修改
     * 传Drug对象过来+id【假定id不可变】
     */
    @PutMapping(value = "/drugs/{id}")
    public R updateBy(@RequestBody Drug dto) {
        drugMapper.updateById(dto);
        return R.success("修改成功");
    }

    /**
     * 添加
     */
    @PostMapping(value = "/drugs")
    public R insert(@RequestBody Drug dto) {
        dto.setProductionDate(new Date());
        drugMapper.insert(dto);
        return R.success("添加成功");
    }


    /**
     * 根据药物名称查询
     */
    @GetMapping(value = "/drugs/{drugName}")
    public R searchDrugByName(@PathVariable("drugName") String drugName){
        return R.success(JSON.toJSONString(drugService.searchDrugByName(drugName)));
    }
}
