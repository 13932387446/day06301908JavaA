package com.zyl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyl.mapper.UserMapper;
import com.zyl.pojo.*;
import com.zyl.service.UserService1;
import com.zyl.utils.DataVoUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService1Impl1 implements UserService1 {

    @Resource
    private UserMapper userMapper;

    @Override
    public PageInfo<User> findUser(Integer pageNum, Integer pageSize, String mohu, String sbirthday, String ebirthday) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userMapper.findUser(mohu, sbirthday, ebirthday);
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        return pageInfo;
    }

    @Override
    public List<Power> findPower() {
        List<Power> powerList = userMapper.findPower();
        return powerList;
    }

    @Override
    public User findUserById(long id) {
        User user = userMapper.findUserById(id);
        return user;
    }

    @Override
    public List<Dept> findDept() {
        List<Dept> dept = userMapper.findDept();
        return dept;
    }

    @Override
    public List<Role> findRoleByDept(User user) {
        if (user.getDept().getDeptid() != null) {
            List<Role> list = userMapper.findRoleByDept(user.getDept().getDeptid());
            return list;
        }
        return null;
    }

    @Override
    public List<Role> findRoleByDeptId(Long deptid) {
        List<Role> roleList = userMapper.findRoleByDept(deptid);
        return roleList;
    }

    @Override
    public void saveUserDeptRole(Long id, Long deptid, Long rid) {
        userMapper.saveUserDeptRole(id, deptid, rid);
    }

    @Override
    public void deleteUser(Long id) {
        userMapper.deleteUser(id);
    }

    @Override
    public void addUser(String username, String password, Long deptid, Long rid, Integer age, String birthday) {
        userMapper.addUser(username, password, deptid, rid, age, birthday);
    }

    @Override
    public User toUpdateUser(Long id) {
        User user = userMapper.toUpdateUser(id);
        return user;
    }

    @Override
    public void updateUser(Long id, String username, String password, Long deptid, Long rid, Integer age, String birthday) {
        userMapper.updateUser(id, username, password, deptid, rid, age, birthday);
    }

    /**
     * 登录
     *
     * @param user
     * @return
     */
    @Override
    public User getLogin(User user) {
        if (user.getUsername() != null && !"".equals(user.getUsername())) {
            if (user.getPassword() != null && !"".equals(user.getPassword())) {
                User login = userMapper.getLogin(user);
                return login;
            }
        }
        return null;
    }

    @Override
    public List<Power> findPowerById(Long id) {
        List<Power> powerList = userMapper.findPowerById(id);
        return powerList;
    }

    @Override
    public QueryDataVo parseStr1(String str1) {
        QueryDataVo queryDataVo = DataVoUtils.parseStr1(str1);
        return queryDataVo;
    }

    @Override
    public String parseStr2(String str2) {
        return DataVoUtils.parseStr2(str2);
    }

    @Override
    public String getInfo(QueryDataVo queryDataVo) {
        // 01表示香烟，则去查询香烟并且去香烟的数据库进行查询
        RsBean rsBean = null;
        if ("01".equals(queryDataVo.getCode())) {
            //查询香烟
            rsBean = userMapper.querySmoke(queryDataVo.getCardno());
            //  02表示酒水则去查询酒水并且去酒水的数据库查询酒水
        } else if ("02".equals(queryDataVo.getCode())) {
            //查询酒水
            rsBean = userMapper.queryWine(queryDataVo.getCardno());
        }
        String parseXml = DataVoUtils.parseXml(queryDataVo.getCode(), rsBean);
        if (parseXml != null) {
            return parseXml;
        }
        return null;
    }

    @Override
    public String saveData(QueryDataVo parseStr1, String str2) {
        /**
         * 判断，01是香烟，02是酒水
         */
        if ("01".equals(parseStr1.getCode())) {
            //解析参数2
            Smoke smoke = DataVoUtils.ParseStr2Smoke(str2);
            //判断是否为空
            if (smoke == null) {
                return "<MEG><CODE>0</CODE><CONTENT>参数2解析失败</CONTENT></MEG>";
            } else {
                try {
                    //解析成功
                    //保存数据
                    userMapper.saveSmoke(smoke);
                    return "<MEG><CODE>1</CODE><CONTENT>数据保存成功</CONTENT></MEG>";
                } catch (Exception e) {
                    e.printStackTrace();
                    return "<MEG><CODE>0</CODE><CONTENT>数据保存失败</CONTENT></MEG>";
                }
            }

        } else if ("02".equals(parseStr1.getCode())) {
            //解析参数2
            Wine wine = DataVoUtils.ParseStr2SWine(str2);
            //判断是否为空
            if (wine == null) {
                return "<MEG><CODE>0</CODE><CONTENT>参数2解析失败</CONTENT></MEG>";
            } else {
                try {
                    //解析成功
                    //保存数据
                    userMapper.saveWine(wine);
                    return "<MEG><CODE>1</CODE><CONTENT>保存成功了</CONTENT></MEG>";
                } catch (Exception e) {
                    e.printStackTrace();
                    return "<MEG><CODE>0</CODE><CONTENT>保存失败了</CONTENT></MEG>";
                }
            }
        }
        return null;
    }

    @Override
    public void saveStuQj(Porcess porcess) {
        // 时间的判断，可以使用两个日期，进行加减判断，做差，也可以直接使用填写的 qjtime，
        // 如果直接使用，需要在页面固定单位：天
        // 判断学生请假的天数是用来判断审核的流程
        //先把流程的id保存进去，需要我们把流程的id拿回来，因为我们在保存明细的时候需要流程的id

        /**
         * 流程的状态
         * 0.正在审核中  1.审核通过  2.审核未通过
         */
        porcess.setQjstatus(0);
        userMapper.insertPorcess(porcess);
        // 流程保存成功，根据请假时间保存流程明细，要先根据学生的id把班级信息查询出来，
        // 因为需要学生班级的讲师以及辅导员id，查询到学生班级情况后，就有了讲师id和辅导员id。这样可以生成明细了
        // 流程顺序码，0表示还没有到我审核，1表示到我审核了，2表示我已经审核过了

        User user = userMapper.findUserById(porcess.getSid());
        //需要查询出该学生的班级信息，否则请假流程无法进行
        if (user != null && user.getGid() != null) {
            // 需要去查询班级
            Grade grade = userMapper.findGradeByGid(user.getGid());
            //班级里边有讲师和辅导员了，如果班级没有讲师和辅导员，
            Pmx pmx = new Pmx();
            pmx.setPid(porcess.getId());
            pmx.setPstatus(0);

            // 有两个状态码，status是表示该流程审核的状态 0正在审核 1审核通过 2审核未通过
            // pstatus是流程处理的状态码，0表示未到我审核，1表示该我处理了，2表示我已经处理过了
            // 需要判断流程是否结束 处理顺序 使用1234来判断

            pmx.setStatus(0);
            pmx.setPstatus(1);
            //处理的顺序,讲师的顺序为1
            pmx.setPshunxu(1);
            //处理人得id,班级的讲师的id
            pmx.setUserid(grade.getTid());

            //保存讲师的流程明细
            userMapper.insertProcessPmx(pmx);

            //处理辅导员的流程
            pmx.setPshunxu(2);
            pmx.setPstatus(0);
            pmx.setUserid(grade.getFid());

            userMapper.insertProcessPmx(pmx);

            if(porcess.getQjtime()>1) {
                pmx.setPshunxu(3);
                // 目前我们没有在班级里添加主任和院长的id，所以写死，当然也可以在班级里边增加id进去
                pmx.setUserid(1);
                userMapper.insertProcessPmx(pmx);
            }
            if (porcess.getQjtime() > 3) {
                pmx.setPshunxu(4);
                pmx.setUserid(2);
                userMapper.insertProcessPmx(pmx);
            }
        }
    }

    @Override
    public List<QjVo> getStuQjListBySid(Long id) {
        List<QjVo> list = userMapper.getStuQjListBySid(id);
        for (QjVo qjVo : list) {
            Integer qjstatus = qjVo.getQjstatus();
            Integer userid = 0;
            if(qjstatus==0){
                qjVo.setStatusStr("正在审核中");
                //需要查询目前是谁正在审核，使用流程id去明细表中查询状态(pstatus)等于1的，就是正在审核
                //能查出来userid
                userid = userMapper.findUseridByPid(qjVo.getId());
                //三种状态中都要用户ID查出来，所以用户信息我们最后统一查询，一个状态下就一个用户
            }
            if(qjstatus==1){
                qjVo.setStatusStr("审核已通过");
                //审核通过了，肯定是最后一个人审核的，也就是审核码最大的那个人
                // select userid from t_pmx where pshunxu =
                // (select MAX(pshunxu) from t_pmx where pid = 52) AND pid = 52
                userid = userMapper.findUseridByPidMaxShunxu(qjVo.getId());
            }
            if(qjstatus==2){
                qjVo.setStatusStr("审核未通过");
                //审核未通过，去找谁审核没有通过，找审核码等于2的
                userid = userMapper.findPidByNopass(qjVo.getId());
            }
            QjVo vo = userMapper.findUnameRnameByid(userid);
            qjVo.setUname(vo.getUname());
            qjVo.setRname(vo.getRname());
        }
        return list;
    }

    @Override
    public List<QjVo> findQjStuListByUserid(Long id) {
        /**
         * 去查询有没有需要我审核的流程d的集合
         */
        List<Integer> pids = userMapper.findQjStuListByUserid(id);
        List<QjVo> list = null;
        if(pids!=null && pids.size()>=1){
            list = new ArrayList<QjVo>();
                for (Integer pid : pids) {
                    QjVo qjVo = new QjVo();
                    // 先按照流程id去查询流程表里面有的信息
                    QjVo vo = userMapper.findProcessById(pid);
                    // 查询出来的vo中，只有学生的id，没有学生的名字和班级的名字
                    // 又要去查询这个学生的另外两个字段
                    QjVo qjvo = userMapper.findStuInfoBySid(vo.getSid());
                    vo.setUname(qjvo.getUname());
                    vo.setGname(qjvo.getGname());
                    list.add(vo);
                }
        }
        return list;
    }

    @Override
    public void saveWdsh(Integer pid, Integer shstatus, Long id) {
        //保存我的审核
        if(shstatus==1){
            // 审核通过，要判断我是不是最后一个，如果是最后一个，则需要把流程审核表中的状态改为 审核通过
            // 要是不是最后一个人就把流程审核明细表中的状态改为已处理，然后把自己的审核状态加进去，交给
            // 下一个人处理，把pstatus改为1，怎么样判断下一个人，把pshunxu加一就是下一个人
            // 如何判断自己是不是流程审核的最后一个人，把流程审核最后一个人的pshunxu(max())查出来和自己的
            // pshunxu比较，不相等自己就不是最后一个人
            /**
             * 接下来，我们需要使用流程pid和id去明细表中查询，先查询目前我审核的这个流程的详细信息
             * 在查询，目前审核的这个整个流程的最大的顺序，要判断是不是最后一个
             * vo里边没有顺序，直接使用integer来表示就ok了
             */
            Integer pshunxu = userMapper.findQjmxInfo(pid,id);
            Integer maxshunxu = userMapper.findMaxShunxu(pid);
            /**
             * 他两要是相等，就是最后一步了，要是不相等，就不是最后一步
             */
            if(pshunxu==maxshunxu){
                userMapper.updateProcessStatus(pid,shstatus);
            }else{
                //如果不通过，把流程明细改成一下，然后把任务交给下一个
                //流程交给下一步，有自己的流程顺序，pshunxu + 1，就是下一个人
                userMapper.updatePmxShunxu(pid,pshunxu+1);
            }
            userMapper.updatePmxStatus(pid,id,shstatus);
        }else {
            /**
             * 审核不通过，直接把流程该更流程明细和流程就OK啦，直接结束流程
             * 直接改成两张表就ok
             * 要是想写方法复用，那么就不要在xml中把状态写死，传递给xml
             */
            userMapper.updateProcessStatus(pid,shstatus);
            userMapper.updatePmxStatus(pid,id,shstatus);
        }
    }
}