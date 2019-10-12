package com.atguigu.gmall0422.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class SkuInfo implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    String id;

    @Column
    String spuId;

    @Column
    BigDecimal price;

    @Column
    String skuName;

    @Column
    BigDecimal weight;

    @Column
    String skuDesc;

    @Column
    String catalog3Id;

    @Column
    String skuDefaultImg;

    @Transient
    List<SkuImage> skuImageList;

    // 平台属性对象
    @Transient
    List<SkuAttrValue> skuAttrValueList;

    // 销售属性对象
    @Transient
    List<SkuSaleAttrValue> skuSaleAttrValueList;

}
