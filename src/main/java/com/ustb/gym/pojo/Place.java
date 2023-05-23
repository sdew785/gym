package com.ustb.gym.pojo;

/**
 * @ClassName： Place
 * @Author: xumin
 * @Date: 2023/5/17 19:17
 * @Description: 必须描述类做什么事情, 实现什么功能
 */
public class Place {
    private Integer pid;
    private String type;
    private String name;
    private String number;
    private String notes;
    private double stu;
    private double th;
    private double tem;
    private Integer statu;

    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    public double getStu() {
        return stu;
    }

    public void setStu(double stu) {
        this.stu = stu;
    }

    public double getTh() {
        return th;
    }

    public void setTh(double th) {
        this.th = th;
    }

    public double getTem() {
        return tem;
    }

    public void setTem(double tem) {
        this.tem = tem;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
