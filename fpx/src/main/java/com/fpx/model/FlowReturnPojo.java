package com.fpx.model;

import java.util.List;

/**
 * @author qfc
 * pojo领域模型，用于封装服务端发送给客户端页面的数据
 */
public class FlowReturnPojo {
    private List<String> dateArrays;
    private List<String> pvArrays;
    private List<String> uvArrays;
    private List<String> ipArrays;
    private List<String> newUvArrays;

    public List<String> getDateArrays() {
        return dateArrays;
    }

    public void setDateArrays(List<String> dateArrays) {
        this.dateArrays = dateArrays;
    }

    public List<String> getPvArrays() {
        return pvArrays;
    }

    public void setPvArrays(List<String> pvArrays) {
        this.pvArrays = pvArrays;
    }

    public List<String> getUvArrays() {
        return uvArrays;
    }

    public void setUvArrays(List<String> uvArrays) {
        this.uvArrays = uvArrays;
    }

    public List<String> getIpArrays() {
        return ipArrays;
    }

    public void setIpArrays(List<String> ipArrays) {
        this.ipArrays = ipArrays;
    }

    public List<String> getNewUvArrays() {
        return newUvArrays;
    }

    public void setNewUvArrays(List<String> newUvArrays) {
        this.newUvArrays = newUvArrays;
    }

    public List<String> getVisitArrays() {
        return visitArrays;
    }

    public void setVisitArrays(List<String> visitArrays) {
        this.visitArrays = visitArrays;
    }

    private List<String> visitArrays;
}
