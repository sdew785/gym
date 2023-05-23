package com.ustb.gym.pojo;
/**
 * @ClassName： Time
 * @Author: xumin
 * @Date: 2023/5/19 17:07
 * @Description: 必须描述类做什么事情, 实现什么功能
 */
public class Time {
    private Integer id;
    private String begin;
    private String over;
    private String notes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getOver() {
        return over;
    }

    public void setOver(String over) {
        this.over = over;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
