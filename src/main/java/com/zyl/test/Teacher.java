package com.zyl.test;

/**
 * @创建人 张亚玲
 * @创建时间 2020/4/20 0020
 * @描述
 **/
public class Teacher extends Person {

    private String kemu;
    private String school;

    public String getKemu() {
        return kemu;
    }

    public void setKemu(String kemu) {
        this.kemu = kemu;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public void disPlay() {
        super.disPlay();
    }
}
