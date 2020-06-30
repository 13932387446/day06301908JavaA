package com.zyl.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.zyl.pojo.*;
import com.zyl.service.DeptService;
import com.zyl.service.RoleService;
import com.zyl.service.UserService1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {

    @Resource
    private UserService1 userService;

    @Resource
    private DeptService deptService;

    @Resource
    private RoleService roleService;

    @RequestMapping(value = "/saveWdsh")
    public String saveWdsh(HttpSession session,Integer pid,Integer shstatus){
        User user = (User) session.getAttribute("user");
        System.out.println(user+"=====");
        userService.saveWdsh(pid,shstatus,user.getId());
        return "redirect:findQjStuList.do";
    };

    @RequestMapping(value = "/findQjStuList")
    public String findQjStuList(HttpSession session,Model model){
        User user = (User) session.getAttribute("user");
        /**
         * 先拿着我的id去审核明细表中查询一下有没有需要我审核的流程，有的话再去流程表中把流程拿出来
         * 和学生是相反的，学生是先查询流程在查询明细，老师先查询明细在查询流程
         */
        List<QjVo> list = userService.findQjStuListByUserid(user.getId());
        model.addAttribute("list",list);
        return "qjsh_list";
    }

    @RequestMapping(value = "/getStuJtList")
    public String getStuJtList(HttpSession session,Model model){
        User user = (User) session.getAttribute("user");
        /**
         * 我们需要写一个请假的vo类
         */
        /**
         * 这是我今天测试git写的
         */
        List<QjVo> list = userService.getStuQjListBySid(user.getId());
        model.addAttribute("list",list);
        return "stuqj_list";
    }

    @RequestMapping(value = "/toStuQj")
    public String toStuQj(HttpSession session,Model model){
        User user = (User) session.getAttribute("user");
        model.addAttribute("stu",user);
        return "stu_qj";
    }

    /**
     * 直接使用实体类来接收
     */
    @RequestMapping(value = "/saveStuQj")
    public String saveStuQj(Porcess porcess){
        userService.saveStuQj(porcess);
        return "redirect:getStuJtList.do";
    }



    @RequestMapping(value = "/testGetOne")
    public String testGetOne(String str){
        return "";
    }

    @RequestMapping(value = "/findUser")
    public String findUser(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize, String mohu, String sbirthday, String ebirthday, Model model){
        PageInfo<User> userList = userService.findUser(pageNum,pageSize,mohu, sbirthday, ebirthday);

        List<User> list = userList.getList();
        int pages = userList.getPages();
        long total = userList.getTotal();

        model.addAttribute("list", list);
        model.addAttribute("count", total);
        model.addAttribute("totalPage", pages);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("pageSize", pageSize);

        return "user_list";
    }

    @RequestMapping(value = "/findPower")
    public String findPower(Model model,HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user!=null){
            List<Power> powerList = userService.findPowerById(user.getId());

            Set<String> set = new HashSet<String>();
            for (int i=0;i<powerList.size();i++) {
                Power power = powerList.get(i);
                if(power.getUrl()!=null){
                    set.add(power.getUrl().trim());
                }
                /**
                 * 把url放进set之后再次判断，如果这个是按钮
                 * 就再次删掉
                 */
                if(power.getIsbutton()==1){
                    powerList.remove(power);
                    i--;
                }
            }
            session.setAttribute("set",set);
            String jsonString = JSON.toJSONString(powerList);
            model.addAttribute("power",jsonString);
        }
        return "left";
    }

    @RequestMapping(value = "/toUserDeptRole")
    public String toUserDeptRole(Long id,Model model){
        //查询员工信息
        User user = userService.findUserById(id);
        //查询部门列表
        List<Dept> deptList = userService.findDept();
        //查询角色列表
        List<Role> roleList = userService.findRoleByDept(user);
        model.addAttribute("user",user);
        model.addAttribute("dlist",deptList);
        model.addAttribute("rolist",roleList);

        return "user_deptrole";
    }

    @RequestMapping(value = "/findRoleByDeptId")
    @ResponseBody
    public List<Role> findRoleByDeptId(Long deptid){
        List<Role> roleList = userService.findRoleByDeptId(deptid);
        return roleList;
    }

    @RequestMapping(value = "/saveUserDeptRole")
    public String  saveUserDeptRole(Long id,Long deptid,Long rid){
        userService.saveUserDeptRole(id,deptid,rid);
        return "redirect:findUser.do";
    }

    @RequestMapping(value = "/deleteUser")
    public String  deleteUser(Long id){
        userService.deleteUser(id);
        return "redirect:findUser.do";
    }

    @RequestMapping(value = "/toAddUser")
    public String  toAddUser(Model model){
        List<Dept> deptList = deptService.findDept();
        model.addAttribute("deptList",deptList);
        return "addUser";
    }

    @RequestMapping(value = "/addUser")
    public String  addUser(String username, String password,Long deptid,Long rid,Integer age, String birthday){
      userService.addUser(username,password,deptid,rid,age,birthday);
        return "redirect:findUser.do";
    }

    @RequestMapping(value = "/updateUser")
    public String  updateUser(Long id, String username, String password, Long deptid, Long rid, Integer age, String birthday){
      userService.updateUser(id,username,password,deptid,rid,age,birthday);
        return "redirect:findUser.do";
    }

    @RequestMapping(value = "/toUpdateUser")
    public String toUpdateUser(Long id,Long deptid,Model model){
        User user = userService.toUpdateUser(id);
        System.out.println(user);
        //查询部门列表
        List<Dept> deptList = userService.findDept();
        //查询角色列表
        List<Role> roleList = roleService.findAllRole(deptid);
        model.addAttribute("user",user);
        model.addAttribute("dlist1",deptList);
        model.addAttribute("rlist1",roleList);
        return "updateUser";
    }

    @RequestMapping(value = "/getLogin")
    public String getLogin(User user, HttpSession session){
        User login = userService.getLogin(user);
        if(login!=null){
            session.setAttribute("user",login);
            return "main";
        }
        return "../../index";
    }


}
