package com.fpx.dao;

import com.fpx.model.FlowNum;

import java.util.List;

/**
 * @author qfc
 * t_flow_num表dao层接口
 */
public interface FlowNumDao {
    /**
     * 查询获取FlowNum对象集合
     * @return
     */
    List<FlowNum> queryFlowNumList();
}
