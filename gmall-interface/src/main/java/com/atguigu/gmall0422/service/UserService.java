package com.atguigu.gmall0422.service;



import com.atguigu.gmall0422.bean.UserAddress;
import com.atguigu.gmall0422.bean.UserInfo;

import java.util.List;

public interface UserService {

    //查询所有数据
    List<UserInfo> findAll();

    //根据用户输入的条件查询
    List<UserInfo> findByUserInfo(UserInfo userInfo);

    //模糊查询
    //根据用户输入的条件范围查找
    List<UserInfo> findByLoginName(String loginName);

    void  addUser(UserInfo userInfo);
    //修改
    void  updUser(UserInfo userInfo);
    void  delUser(UserInfo userInfo);

    /**
     * 根据用户id
     * @param userId
     * @return
     */
    List<UserAddress> findUserAddressByUserId(String userId);
}
