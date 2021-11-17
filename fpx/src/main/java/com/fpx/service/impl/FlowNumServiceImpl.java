package com.fpx.service.impl;

import com.fpx.dao.FlowNumDao;
import com.fpx.dao.impl.FlowNumDaoImpl;
import com.fpx.model.FlowNum;
import com.fpx.model.FlowReturnPojo;
import com.fpx.service.FlowNumService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qfc
 */
public class FlowNumServiceImpl implements FlowNumService {

    private FlowNumDao flowNumDao = new FlowNumDaoImpl();

    @Override
    public FlowReturnPojo getFlowReturnPojo() {
        List<FlowNum> flowNumList = flowNumDao.queryFlowNumList();
        FlowReturnPojo flowReturnPojo = new FlowReturnPojo();
        ArrayList<String> dateArrays = new ArrayList<>();
        ArrayList<String> pvArrays = new ArrayList<>();
        ArrayList<String> uvArrays = new ArrayList<>();
        ArrayList<String> ipArrays = new ArrayList<>();
        ArrayList<String> newUvArrays = new ArrayList<>();
        ArrayList<String> visitArrays = new ArrayList<>();
        for(FlowNum flowNum:flowNumList){
            dateArrays.add(flowNum.getDateStr());
            pvArrays.add(String.valueOf(flowNum.getPvNum()));
            uvArrays.add(String.valueOf(flowNum.getUvNum()));
            ipArrays.add(String.valueOf(flowNum.getIpNum()));
            newUvArrays.add(String.valueOf(flowNum.getNewUvNum()));
            visitArrays.add(String.valueOf(flowNum.getVisitNum()));
        }
        flowReturnPojo.setDateArrays(dateArrays);
        flowReturnPojo.setPvArrays(pvArrays);
        flowReturnPojo.setUvArrays(uvArrays);
        flowReturnPojo.setIpArrays(ipArrays);
        flowReturnPojo.setNewUvArrays(newUvArrays);
        flowReturnPojo.setVisitArrays(visitArrays);
        return flowReturnPojo;
    }
}
