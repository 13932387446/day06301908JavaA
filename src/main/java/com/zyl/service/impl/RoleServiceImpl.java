package com.zyl.service.impl;

import com.zyl.mapper.RoleMapper;
import com.zyl.pojo.Power;
import com.zyl.pojo.Role;
import com.zyl.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> findRole() {
        List<Role> roleList = roleMapper.findRole();
        return roleList;
    }

    @Override
    public List<Role> findAllRole(Long deptid) {
        List<Role> roleList = roleMapper.findAllRole(deptid);
        return roleList;
    }

    @Override
    public List<Power> findPowerByRid(Long rid) {
        /**
         * 把权限的所有的List全部查出来
         * 把该角色的权限全部查出来
         * 回显
         */

        // SELECT id FROM t_power,只查了id
        List<Power> powerList = roleMapper.getPowerList();
        List<Long> roleByRid = roleMapper.getRoleByRid(rid);

        if(roleByRid!=null&&roleByRid.size()>=1){
            if(powerList!=null&&powerList.size()>=1){
                //查到的id
                for (Long id : roleByRid) {
                    for (Power power : powerList) {
                        if(id.equals(power.getId())){
                            power.setChecked(true);
                            break;
                        }
                    }
                }
            }
        }
        return powerList;
    }

    @Override
    public void insertRolePower(Long rid, String ids) {
        roleMapper.deleteRolePowerByRid(rid);
        if(ids!=null&&ids.length()>=1){
            String[] split = ids.split(",");
            for (String s : split) {
                roleMapper.insertRolePower(rid,s);
            }
        }
    }
}
