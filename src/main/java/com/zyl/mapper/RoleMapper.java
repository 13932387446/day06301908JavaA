package com.zyl.mapper;

import com.zyl.pojo.Power;
import com.zyl.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {

    List<Role> findRole();

    List<Role> findAllRole(Long deptid);

    List<Power> getPowerList();

    List<Long> getRoleByRid(Long rid);

    void deleteRolePowerByRid(Long rid);

    void insertRolePower(@Param("rid") Long rid, @Param("ids") String ids);
}
