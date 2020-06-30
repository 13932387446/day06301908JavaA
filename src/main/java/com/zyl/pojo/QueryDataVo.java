package com.zyl.pojo;

/**
 * @创建人 张亚玲
 * @创建时间 2020/4/16 0016
 * @描述
 **/
public class QueryDataVo {

    private String uname;

    private String pwd;

    private String code;

    private String cardno;

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public QueryDataVo(String uname, String pwd, String code) {
        this.uname = uname;
        this.pwd = pwd;
        this.code = code;
    }
}
