package com.fpx.service;

import com.fpx.model.AvgReturnPojo;

/**
 * @author qfc
 * AvgPvNumService的业务接口
 */
public interface AvgPvNumService {

 //获取日平均访问量
    public AvgReturnPojo getAvgReturnPojo();

}
