package com.zyl.pojo;

import lombok.Data;

/**
 * @创建人 张亚玲
 * @创建时间 2020/4/15 0015
 * @描述
 **/

@Data
public class InfoBean {

    private Integer id;
    private String username;
    private String userpwd;
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "InfoBean{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userpwd='" + userpwd + '\'' +
                ", age=" + age +
                '}';
    }
}
