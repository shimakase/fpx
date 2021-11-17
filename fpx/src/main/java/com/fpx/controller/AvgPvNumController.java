package com.fpx.controller;
import com.fpx.service.AvgPvNumService;
import com.fpx.service.impl.AvgPvNumServiceimpl;
import com.google.gson.Gson;
import com.fpx.model.AvgPvNum;
import com.fpx.model.AvgReturnPojo;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * @author qfc
 */
@WebServlet(name = "AvgPvNumController",value = "/AvgPvNum")
public class AvgPvNumController extends HttpServlet {

    private AvgPvNumServiceimpl avgPvNumServiceimpl=new AvgPvNumServiceimpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AvgReturnPojo avgReturnPojo = avgPvNumServiceimpl.getAvgReturnPojo();

        //1.将pojo领域模型对象转换成json字符串，响应给view层客户端页面
        Gson gson = new Gson();
        String json = gson.toJson(avgReturnPojo);
        response.setContentType("text/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println(json);
        writer.flush();
        writer.close();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
