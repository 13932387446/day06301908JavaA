package com.zyl.controller;

import com.zyl.pojo.Dept;
import com.zyl.pojo.Role;
import com.zyl.service.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class DeptController {

    @Resource
    private DeptService deptService;

    @RequestMapping(value = "findDept")
    public String findDept(Model model){
        List<Dept> deptList = deptService.findDept();
        model.addAttribute("dlist",deptList);
        return "dept_list";
    }
    @RequestMapping(value = "/toDeptRole")
    public String  toDeptRole(Long deptid,Model model){
        Dept dept = deptService.findDeptById(deptid);
        List<Role> roleList = deptService.findRoleList();
        List<Long> rid = deptService.findRidByPid(deptid);
        model.addAttribute("dept",dept);
        model.addAttribute("list",roleList);
        model.addAttribute("rid",rid);
        return "updDeptRole";
    }



    @RequestMapping(value = "/saveDeptRole")
    public String  saveDeptRole(Long deptid,Long[] rids){
        deptService.saveDeptRole(deptid,rids);
        return "redirect:findDept.do";
    }
}
