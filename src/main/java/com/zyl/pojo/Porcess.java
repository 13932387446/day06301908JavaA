package com.zyl.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @创建人 张亚玲
 * @创建时间 2020/6/24 0024 21:34
 * @描述
 **/
public class Porcess {

    private Integer id;
    private Integer sid;
    private Double qjtime;
    //发起假条的时间
    private Date qjdate = new Date();

    @DateTimeFormat(pattern = "yyyy-MM-dd HH")
    private Date stime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH")
    private Date etime;
    private String qjcause;
    private Integer qjstatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Double getQjtime() {
        return qjtime;
    }

    public void setQjtime(Double qjtime) {
        this.qjtime = qjtime;
    }

    public Date getStime() {
        return stime;
    }

    public void setStime(Date stime) {
        this.stime = stime;
    }

    public Date getEtime() {
        return etime;
    }

    public void setEtime(Date etime) {
        this.etime = etime;
    }

    public String getQjcause() {
        return qjcause;
    }

    public void setQjcause(String qjcause) {
        this.qjcause = qjcause;
    }

    public Integer getQjstatus() {
        return qjstatus;
    }

    public void setQjstatus(Integer qjstatus) {
        this.qjstatus = qjstatus;
    }

    public Date getQjdate() {
        return qjdate;
    }

    public void setQjdate(Date qjdate) {
        this.qjdate = qjdate;
    }

    @Override
    public String toString() {
        return "Porcess{" +
                "id=" + id +
                ", sid=" + sid +
                ", qjtime=" + qjtime +
                ", qjdate=" + qjdate +
                ", stime=" + stime +
                ", etime=" + etime +
                ", qjcause='" + qjcause + '\'' +
                ", qjstatus=" + qjstatus +
                '}';
    }
}
