package com.zyl.test;

import org.junit.Test;

/**
 * @创建人 张亚玲
 * @创建时间 2020/4/14 0014
 * @描述
 **/
public class Test1 {
    Teacher teacher = new Teacher();

    @Test
    public void test1(){
        teacher.setKemu("数学");
        teacher.setSchool("一中");
        System.out.println("所教科目"+teacher.getKemu());
        teacher.disPlay();
    }
}
