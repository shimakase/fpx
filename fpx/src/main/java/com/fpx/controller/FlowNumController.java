package com.fpx.controller;

import com.fpx.model.FlowReturnPojo;
import com.fpx.service.FlowNumService;
import com.fpx.service.impl.FlowNumServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author qfc
 * t_flow_num表对应的Controller层
 */
@WebServlet(name = "FlowNumController",value = "/FlowNum")
public class FlowNumController extends HttpServlet {
    private FlowNumService flowNumService =new FlowNumServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FlowReturnPojo flowReturnPojo = flowNumService.getFlowReturnPojo();
        Gson gson=new Gson();
        String json=gson.toJson(flowReturnPojo);
        response.setContentType("text/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer =response.getWriter();
        writer.println(json);
        writer.flush();
        writer.close();
    }
}
