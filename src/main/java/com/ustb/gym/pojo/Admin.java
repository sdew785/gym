package com.ustb.gym.pojo;

/**
 * @ClassName： Admin
 * @Author: xumin
 * @Date: 2023/5/19 15:44
 * @Description: 必须描述类做什么事情, 实现什么功能
 */
public class Admin {
    private Integer aid;
    private String name;
    private String pwd;
    private String notes;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
