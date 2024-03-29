package com.atguigu.gmall0422.manage.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall0422.bean.*;
import com.atguigu.gmall0422.service.ManageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ManagerController {

    @Reference
    private ManageService manageService;

    @RequestMapping("getCatalog1")
    public List<BaseCatalog1>getCatalog1(){

    return manageService.getCatalog1();
    }
    @RequestMapping("getCatalog2")
    public List<BaseCatalog2>getCatalog2(String catalog1Id){

        return manageService.getCatalog2(catalog1Id);
    }

    @RequestMapping("getCatalog3")
    public List<BaseCatalog3> getCatalog3(String catalog2Id){
        return manageService.getCatalog3(catalog2Id);
    }
    @RequestMapping("attrInfoList")
    public List<BaseAttrInfo> attrInfoList(String catalog3Id){
        return manageService.getAttrList(catalog3Id);
    }

    @RequestMapping("saveAttrInfo")
    public String saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo){
        manageService.saveBaseAttrInfo(baseAttrInfo);
        return "ok";
    }

    @RequestMapping("getAttrValueList")
    public List<BaseAttrValue> getAttrValueList(String attrId){
     BaseAttrInfo baseAttrInfo=manageService.getBaseAttrInfo(attrId);
       return baseAttrInfo.getAttrValueList();
    }

    @RequestMapping("spuList")
    public List<SpuInfo> spuList(SpuInfo spuInfo){

       return manageService.getSpuInfoList(spuInfo);
    }


}
