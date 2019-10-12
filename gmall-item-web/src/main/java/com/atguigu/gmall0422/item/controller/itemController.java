package com.atguigu.gmall0422.item.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.atguigu.gmall0422.bean.SkuImage;
import com.atguigu.gmall0422.bean.SkuInfo;
import com.atguigu.gmall0422.bean.SkuSaleAttrValue;
import com.atguigu.gmall0422.bean.SpuSaleAttr;
import com.atguigu.gmall0422.service.ManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
public class itemController {
    @Reference
    private ManageService manageService;

    @RequestMapping("{skuId}.html")
    public String getItem(@PathVariable String skuId, HttpServletRequest request){
        System.out.println("skuId:"+skuId);

     SkuInfo skuInfo= manageService.getSkuInfo(skuId);

     //渲染skuImage
//       List<SkuImage> skuImageList= manageService.getSkuImageList(skuId);
//    request.setAttribute("skuImageList",skuImageList);

        //保存SpuSaleAttr
        List<SpuSaleAttr> spuSaleAttrList =manageService.getSpuSaleAttrListCheckBySku(skuInfo);

        //查询所有的销售属性值能够组成的商品id
      List<SkuSaleAttrValue> skuSaleAttrValueList  =manageService.getSkuSaleAttrValueListBySpu(skuInfo.getSpuId());

        String key="";
        HashMap<String, String> map = new HashMap<>();
        if(skuSaleAttrValueList!=null&&skuSaleAttrValueList.size()>0) {
            for (int i = 0; i < skuSaleAttrValueList.size(); i++) {
                //获取集合中的每一条销售属性值
                SkuSaleAttrValue skuSaleAttrValue = skuSaleAttrValueList.get(i);

                if (key.length() > 0) {
                    key += "|";
                }
                key += skuSaleAttrValue.getSaleAttrValueId();

                if (i + 1 == skuSaleAttrValueList.size() || !skuSaleAttrValue.getSkuId().equals(skuSaleAttrValueList.get(i + 1).getSkuId())) {
                    map.put(key, skuSaleAttrValue.getSkuId());
                    key = "";
                }

            }
        }
        //将map转换为json字符串
        String valuesSkuJson  = JSON.toJSONString(map);
        request.setAttribute("valuesSkuJson",valuesSkuJson);
        System.out.println("valuesSkuJson==="+valuesSkuJson);

        request.setAttribute("spuSaleAttrList",spuSaleAttrList);
        //保存spuInfo
     request.setAttribute("skuInfo",skuInfo);
        return "item";
    }
}
