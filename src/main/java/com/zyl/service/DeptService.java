package com.zyl.service;

import com.zyl.pojo.Dept;
import com.zyl.pojo.Role;

import java.util.List;

public interface DeptService {

    List<Dept> findDept();

    Dept findDeptById(Long deptid);

    List<Role> findRoleList();

    List<Long> findRidByPid(Long deptid);

    void saveDeptRole(Long deptid,Long[] rids);
}
