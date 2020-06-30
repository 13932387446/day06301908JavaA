package com.zyl.pojo;

/**
 * @创建人 张亚玲
 * @创建时间 2020/4/20 0020
 * @描述
 **/

public class Smoke {

    private Integer id;
    private String cardno;

    private String madeDate;

    private String address;
    private String name;
    private String price;

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

    public String getMadeDate() {
        return madeDate;
    }

    public void setMadeDate(String madeDate) {
        this.madeDate = madeDate;
    }

    public String getAddress() {
        return address;
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

    public Smoke() {
    }

    public Smoke(String cardno, String madeDate, String address, String name, String price) {
        this.cardno = cardno;
        this.madeDate = madeDate;
        this.address = address;
        this.name = name;
        this.price = price;
    }
}
