package com.fpx.dao.impl;

import com.fpx.dao.AvgPvNumDao;
import com.fpx.model.AvgPvNum;
import com.fpx.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AvgPvNumDaoimpl implements AvgPvNumDao {
    @Override
    public List<AvgPvNum> getAvPvNumList() {

        ArrayList<AvgPvNum> avgPvNumList = null;
            //http请求的响应逻辑代码
        try {
            //连接sql数据库
            Connection connection= JdbcUtils.getConnection();
            //1.5创建sql运算器
            Statement statement = connection.createStatement();
            String sql = "select * from t_avgpv_num;";
            //1.6执行sql语句
            ResultSet resultSet = statement.executeQuery(sql);
            avgPvNumList = new ArrayList<>();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String dateStr = resultSet.getString("dateStr");
                Float avgPvNum = resultSet.getFloat("avgPvNum");
                AvgPvNum avgPvNumDb = new AvgPvNum(id, dateStr, avgPvNum);
                avgPvNumList.add(avgPvNumDb);
            }
            System.out.println(avgPvNumList);
            JdbcUtils.close(connection,statement,resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return avgPvNumList;
    }

}
