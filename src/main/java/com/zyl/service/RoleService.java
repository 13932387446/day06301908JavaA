package com.zyl.service;

import com.zyl.pojo.Power;
import com.zyl.pojo.Role;

import java.util.List;

public interface RoleService {

    List<Role> findRole();

    List<Role> findAllRole(Long deptid);

    List<Power> findPowerByRid(Long rid);

    void insertRolePower(Long rid,String ids);
}
