package com.fpx.model;

/**
 * @author qfc
 * t_flow_num表对应的流量概况模型
 */
public class FlowNum {
    private Long id;
    private String dateStr;
    private int pvNum;
    private int uvNum;
    private int ipNum;
    private int newUvNum;
    private int visitNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public int getPvNum() {
        return pvNum;
    }

    public void setPvNum(int pvNum) {
        this.pvNum = pvNum;
    }

    public int getUvNum() {
        return uvNum;
    }

    public void setUvNum(int uvNum) {
        this.uvNum = uvNum;
    }

    public int getIpNum() {
        return ipNum;
    }

    public void setIpNum(int ipNum) {
        this.ipNum = ipNum;
    }

    public int getNewUvNum() {
        return newUvNum;
    }

    public void setNewUvNum(int newUvNum) {
        this.newUvNum = newUvNum;
    }

    public int getVisitNum() {
        return visitNum;
    }

    public void setVisitNum(int visitNum) {
        this.visitNum = visitNum;
    }

    public FlowNum(Long id, String dateStr, int pvNum, int uvNum, int ipNum, int newUvNum, int visitNum) {
        this.id = id;
        this.dateStr = dateStr;
        this.pvNum = pvNum;
        this.uvNum = uvNum;
        this.ipNum = ipNum;
        this.newUvNum = newUvNum;
        this.visitNum = visitNum;
    }
}
