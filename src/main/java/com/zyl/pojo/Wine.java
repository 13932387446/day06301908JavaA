package com.zyl.pojo;

/**
 * @创建人 张亚玲
 * @创建时间 2020/4/20 0020
 * @描述
 **/

public class Wine {

    private Integer id;
    private String cardno;

    private String madeDate;

    private String address;
    private String name;
    private String price;

    private String vol;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getAddress() {
        return address;
    }

    public String getMadeDate() {
        return madeDate;
    }

    public void setMadeDate(String madeDate) {
        this.madeDate = madeDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVol() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol = vol;
    }

    public Wine(String cardno, String madeDate, String address, String name, String price, String vol) {
        this.cardno = cardno;
        this.madeDate = madeDate;
        this.address = address;
        this.name = name;
        this.price = price;
        this.vol = vol;
    }

    public Wine() {
    }
}
