package com.zyl.controller;

import com.alibaba.fastjson.JSON;
import com.zyl.pojo.Power;
import com.zyl.pojo.Role;
import com.zyl.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class RoleController {

    @Resource
    private RoleService roleService;

    @RequestMapping(value = "/findRole")
    public String findRole(Model model){
        List<Role> roleList = roleService.findRole();
        model.addAttribute("roleList",roleList);
        return "role_list";
    }

    @RequestMapping(value = "/findPowerByRid")
    public String findPowerByRid(Long rid,Model model){
        List<Power> powerByRid = roleService.findPowerByRid(rid);

        String jsonString = JSON.toJSONString(powerByRid);

        model.addAttribute("json",jsonString);
        model.addAttribute("rid",rid);
        return "role_power";
    }

    @RequestMapping(value = "/saveRolePower")
    public String saveRolePower(Long rid,String ids){
        System.out.println(rid+"=rid");
        System.out.println(ids+"=ids");
        roleService.insertRolePower(rid,ids);
        return "redirect:findRole.do";
    }

}
