package com.fpx.dao;

import com.fpx.model.AvgPvNum;

import java.util.List;

/**
 * @author qfc
 * AvgPvNumDao的数据接口操作
 *
 */
public interface AvgPvNumDao {
    /*获取每日访问流量*/

    List<AvgPvNum> getAvPvNumList();
}
