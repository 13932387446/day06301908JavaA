package com.zyl.pojo;

/**
 * @创建人 张亚玲
 * @创建时间 2020/6/25 0025 08:49
 * @描述
 **/
public class Grade {

    private Integer gid;
    private String gname;
    private Integer fid;
    private Integer tid;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                ", fid=" + fid +
                ", tid=" + tid +
                '}';
    }
}
