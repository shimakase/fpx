package com.fpx.service.impl;

import com.fpx.dao.AvgPvNumDao;
import com.fpx.dao.impl.AvgPvNumDaoimpl;
import com.fpx.model.AvgPvNum;
import com.fpx.model.AvgReturnPojo;
import com.fpx.service.AvgPvNumService;

import java.util.ArrayList;
import java.util.List;

public class AvgPvNumServiceimpl implements AvgPvNumService {

    private AvgPvNumDaoimpl avgPvNumDaoimpl =new AvgPvNumDaoimpl();

    @Override
    public AvgReturnPojo getAvgReturnPojo() {
        //具体业务逻辑
        //2.使用pojo领域模型对象，封装服务器端发送给前端页面的数据
        List<AvgPvNum>avgPvNumList =avgPvNumDaoimpl.getAvPvNumList();
        //业务方面数据
        AvgReturnPojo avgReturnPojo = new AvgReturnPojo();
        ArrayList<String> dateStrArrays = new ArrayList<>();
        ArrayList<String> pvStrArrays = new ArrayList<>();
        for(AvgPvNum avgPvNum:avgPvNumList){
            dateStrArrays.add(avgPvNum.getDateStr());
            pvStrArrays.add(String.valueOf(avgPvNum.getAvgPvNum()));
        }
        avgReturnPojo.setDates(dateStrArrays);
        avgReturnPojo.setData(pvStrArrays);
        System.out.println(avgReturnPojo);
        return avgReturnPojo;
    }
}
