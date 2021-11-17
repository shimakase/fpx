package com.fpx.test;

import com.google.gson.Gson;
import com.fpx.model.AvgPvNum;
import com.fpx.model.AvgReturnPojo;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author qfc
 */
public class JDBSTest {
    public static void main(String[] args)  {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //jdbc规范
            //1.导入jdbc的jar包
            //2.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //3.获取连接对象
            //http://www.baidu.com/
            String URL = "jdbc:mysql://127.0.0.1:3306/web_log_view";
            String USER = "root";
            String PASSWORD = "123456";
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            //4.创建sql的运算器
            statement = connection.createStatement();
            //5.通过sql的运算器执行sql语句(获取结果集)
            String sql = "select * from t_avgpv_num;";
            resultSet = statement.executeQuery(sql);
            ArrayList<AvgPvNum> avgPvNumList = new ArrayList<>();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String dateStr = resultSet.getString("dateStr");
                Float avgPvNum = resultSet.getFloat("avgPvNum");
                AvgPvNum avgPvNumDb = new AvgPvNum(id, dateStr, avgPvNum);
                avgPvNumList.add(avgPvNumDb);
            }
            System.out.println(avgPvNumList);
            //6.关闭资源

            //1.将avgPvNumList集合里面的数据封装成一个pojo对象
            ArrayList<String> datesArrays = new ArrayList<>();
            ArrayList<String> dataArrays = new ArrayList<>();
            for(AvgPvNum avgPvNum:avgPvNumList){
                datesArrays.add(avgPvNum.getDateStr());
                dataArrays.add(String.valueOf(avgPvNum.getAvgPvNum()));
            }
            AvgReturnPojo avgReturnPojo = new AvgReturnPojo();
            avgReturnPojo.setDates(datesArrays);
            avgReturnPojo.setData(dataArrays);

            //2.将pojo对象转换成前端需要的json格式的字符串数据
            Gson gson = new Gson();
            String json = gson.toJson(avgReturnPojo);
            System.out.println(json);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
