package com.zyl.service.impl;

import com.zyl.mapper.DeptMapper;
import com.zyl.pojo.Dept;
import com.zyl.pojo.Role;
import com.zyl.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findDept() {
        List<Dept> deptList = deptMapper.findDept();
        return deptList;
    }

    @Override
    public Dept findDeptById(Long deptid) {
        Dept dept = deptMapper.findDeptById(deptid);
        return dept;
    }

    @Override
    public List<Role> findRoleList() {
        List<Role> roles = deptMapper.findRoleList();
        return roles;
    }

    @Override
    public List<Long> findRidByPid(Long deptid) {
        List<Long> rid = deptMapper.findRidByPid(deptid);
        return rid;
    }

    @Override
    public void saveDeptRole(Long deptid, Long[] rids) {
        if(deptid != null){
            deptMapper.deleteRoleByDeptid(deptid);
            System.out.println("执行成功");
            if(rids!=null && rids.length>=1){
                for (Long rid : rids) {
                    deptMapper.saveDeptRole(deptid,rid);
                }
            }
        }
    }
}
