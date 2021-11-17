package com.fpx.dao.impl;

import com.fpx.dao.FlowNumDao;
import com.fpx.model.FlowNum;
import com.fpx.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author qfc
 */
public class FlowNumDaoImpl implements FlowNumDao {
    @Override
    public List<FlowNum> queryFlowNumList(){
        ArrayList<FlowNum> flowNumList =new ArrayList<>();
        try {
            Connection connection = JdbcUtils.getConnection();
            Statement statement =connection.createStatement();
            String sql="select * from t_flow_num";
            ResultSet resultSet =statement.executeQuery(sql);
            while (resultSet.next()){
                long id = resultSet.getLong(1);
                String dateStr = resultSet.getString(2);
                int pvNum = resultSet.getInt(3);
                int uvNum = resultSet.getInt(4);
                int ipNum = resultSet.getInt(5);
                int newUvNum = resultSet.getInt(6);
                int visitNum = resultSet.getInt(7);
                FlowNum flowNum = new FlowNum(id, dateStr, pvNum, uvNum, ipNum, newUvNum, visitNum);
                flowNumList.add(flowNum);
            }
            JdbcUtils.close(connection,statement,resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flowNumList;
    }
}
