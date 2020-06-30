package com.zyl.service;

import com.github.pagehelper.PageInfo;
import com.zyl.pojo.*;

import java.util.List;

public interface UserService1 {

    PageInfo<User> findUser(Integer pageNum, Integer pageSize, String mohu, String sbirthday, String ebirthday);

    List<Power> findPower();

    User findUserById(long id);

    List<Dept> findDept();

    List<Role> findRoleByDept(User user);

    List<Role> findRoleByDeptId(Long deptid);

    void saveUserDeptRole(Long id,Long deptid,Long rid);

    void deleteUser(Long id);

    void addUser(String username, String password,Long deptid,Long rid,Integer age, String birthday);

    User toUpdateUser(Long id);

    void updateUser(Long id,String username, String password, Long deptid, Long rid, Integer age, String birthday);

    User getLogin(User user);

    List<Power> findPowerById(Long id);

    QueryDataVo parseStr1(String str1);

    String parseStr2(String str2);

    String getInfo(QueryDataVo queryDataVo);

    String saveData(QueryDataVo parseStr1, String str2);

    void saveStuQj(Porcess porcess);

    List<QjVo> getStuQjListBySid(Long id);

    List<QjVo> findQjStuListByUserid(Long id);

    void saveWdsh(Integer pid, Integer shstatus,Long id);
}
