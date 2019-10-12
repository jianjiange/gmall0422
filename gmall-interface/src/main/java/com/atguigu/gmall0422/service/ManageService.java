package com.atguigu.gmall0422.service;

import com.atguigu.gmall0422.bean.*;

import java.util.List;

public interface ManageService {
    public List<BaseCatalog1> getCatalog1();

    public List<BaseCatalog2> getCatalog2(String catalog1Id);

    public List<BaseCatalog3> getCatalog3(String catalog2Id);

    /**
     * 通过三级分类id查询平台属性
     * @param catalog3Id
     * @return
     */
    public List<BaseAttrInfo> getAttrList(String catalog3Id);

    /**
     * 保存平台属性和平台属性值
     * @param baseAttrInfo
     */
    void saveBaseAttrInfo(BaseAttrInfo baseAttrInfo);

    /**
     * 根据平台属性id查询平台属性值集合
     * @param attrId
     * @return
     */
    List<BaseAttrValue> getAttrValueList(String attrId);

    /**
     * 根据平台属性id获取平台属性对象
     * @param attrId
     * @return
     */
    BaseAttrInfo getBaseAttrInfo(String attrId);

    /**
     * 根据spuInfo的属性查询spuInfo列表
     * @param spuInfo
     * @return
     */
    List<SpuInfo> getSpuInfoList(SpuInfo spuInfo);

    // 查询基本销售属性表
    List<BaseSaleAttr> getBaseSaleAttrList();

    /**
     * 保存spuInfo属性
     * @param spuInfo
     */
     void saveSpuInfo(SpuInfo spuInfo);

    /**
     * 根据有spuid查询图片列表
     * @param spuId
     * @return
     */
    List<SpuImage> getSpuImageList(String spuId);

    /**
     * 根据spuId查询销售属性
     * @param spuId
     * @return
     */
    List<SpuSaleAttr> getSpuSaleAttrList(String spuId);

    /**
     * 保存skuInfo
     * @param skuInfo
     */
   void saveSkuInfo(SkuInfo skuInfo);

    /**
     * 根据skuID查询skuInfo
     * @param skuId
     * @return
     */
    SkuInfo getSkuInfo(String skuId);

    /**
     * 根据skuID查询图片
     * @param skuId
     * @return
     */
    List<SkuImage> getSkuImageList(String skuId);

    /**
     * 根据业务需要查询销售属性对象集合
     * @param skuInfo
     * @return
     */
    List<SpuSaleAttr> getSpuSaleAttrListCheckBySku(SkuInfo skuInfo);

    /**
     * 根据skuId查询销售属性值集合对象
     * @param spuId
     * @return
     */
    List<SkuSaleAttrValue> getSkuSaleAttrValueListBySpu(String spuId);
}
