package com.fpx.model;

/**
 * @author qfc
 *t_avgpv_num表对应的javaBean
 * 创建对象对表数据进行封装
 */
public class   AvgPvNum {
    private Long id;
    private String dateStr;
    private Float  avgPvNum;
    public AvgPvNum(){

    }

    public AvgPvNum(Long id, String dateStr, Float avgPvNum) {
        this.id = id;
        this.dateStr = dateStr;
        this.avgPvNum = avgPvNum;
    }

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

    public Float getAvgPvNum() {
        return avgPvNum;
    }

    public void setAvgPvNum(Float avgPvNum) {
        this.avgPvNum = avgPvNum;
    }
    @Override
    public String toString() {
        return "AvgPvNum{" +
                "id=" + id +
                ", dateStr='" + dateStr + '\'' +
                ", avgPvNum=" + avgPvNum +
                '}';
    }
}
