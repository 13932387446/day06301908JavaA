package com.zyl.mapper;

import com.zyl.pojo.Dept;
import com.zyl.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {

    List<Dept> findDept();

    Dept findDeptById(Long deptid);

    List<Role> findRoleList();

    List<Long> findRidByPid(Long deptid);

    void deleteRoleByDeptid(@Param("deptid") Long deptid);

    void saveDeptRole(@Param("deptid") Long deptid,@Param("rid") Long rid);
}
