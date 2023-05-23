package com.ustb.gym.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName： User
 * @Author: xumin
 * @Date: 2023/5/17 18:08
 * @Description: 必须描述类做什么事情, 实现什么功能
 */
public class User {
    private Integer uid;
    private String uname;
    private Integer type;
    private Integer vip;
    private Integer vipBal;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String notes;
    private String pwd;
    private Integer statu;

    public User() {
    }

    public User(Integer uid, String uname, Integer type, Integer vip, Integer vipBal, Date createTime, String notes, String pwd, Integer statu) {
        this.uid = uid;
        this.uname = uname;
        this.type = type;
        this.vip = vip;
        this.vipBal = vipBal;
        this.createTime = createTime;
        this.notes = notes;
        this.pwd = pwd;
        this.statu = statu;
    }

    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    public Integer getVipBal() {
        return vipBal;
    }

    public void setVipBal(Integer vipBal) {
        this.vipBal = vipBal;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
