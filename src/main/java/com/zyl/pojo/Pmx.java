package com.zyl.pojo;

import java.util.Date;

/**
 * @创建人 张亚玲
 * @创建时间 2020/6/25 0025 09:11
 * @描述
 **/
public class Pmx {

    private Integer id;
    private Integer pid;
    private Integer userid;
    private Integer status;
    private String pyijian;
    private Integer pstatus;
    private Integer pshunxu;
    private Date shdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPyijian() {
        return pyijian;
    }

    public void setPyijian(String pyijian) {
        this.pyijian = pyijian;
    }

    public Integer getPstatus() {
        return pstatus;
    }

    public void setPstatus(Integer pstatus) {
        this.pstatus = pstatus;
    }

    public Integer getPshunxu() {
        return pshunxu;
    }

    public void setPshunxu(Integer pshunxu) {
        this.pshunxu = pshunxu;
    }

    public Date getShdate() {
        return shdate;
    }

    public void setShdate(Date shdate) {
        this.shdate = shdate;
    }

    @Override
    public String toString() {
        return "Pmx{" +
                "id=" + id +
                ", pid=" + pid +
                ", userid=" + userid +
                ", status=" + status +
                ", pyijian='" + pyijian + '\'' +
                ", pstatus=" + pstatus +
                ", pshunxu=" + pshunxu +
                ", shdate=" + shdate +
                '}';
    }
}
