package com.zyl.mapper;

import com.zyl.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> findUser(@Param("mohu") String mohu, @Param("sbirthday") String sbirthday, @Param("ebirthday") String ebirthday);

    List<Power> findPower();

    User findUserById(long id);

    List<Dept> findDept();

    List<Role> findRoleByDept(Long deptid);

    void saveUserDeptRole(@Param("id") Long id, @Param("deptid") Long deptid, @Param("rid") Long rid);

    void deleteUser(Long id);

    void addUser(@Param("username") String username,@Param("password") String password,@Param("deptid") Long deptid,@Param("rid") Long rid,@Param("age") Integer age,@Param("birthday") String birthday);

    User toUpdateUser(Long id);

    void updateUser(@Param("id") Long id,@Param("username") String username,@Param("password") String password,@Param("deptid") Long deptid,@Param("rid") Long rid,@Param("age") Integer age,@Param("birthday") String birthday);

    User getLogin(User user);

    List<Power> findPowerById(Long id);

    RsBean querySmoke(String cardno);

    RsBean queryWine(String cardno);

    void saveSmoke(Smoke smoke);

    void saveWine(Wine wine);

    Integer insertPorcess(Porcess porcess);

    Grade findGradeByGid(Integer gid);

    void insertProcessPmx(Pmx pmx);

    List<QjVo> getStuQjListBySid(Long id);

    Integer findUseridByPid(Integer pid);

    Integer findUseridByPidMaxShunxu(Integer pid);

    Integer findPidByNopass(Integer pid);

    QjVo findUnameRnameByid(Integer id);

    List<Integer> findQjStuListByUserid(Long id);

    QjVo findProcessById(Integer pid);

    QjVo findStuInfoBySid(Integer sid);

    void updateProcessStatus(@Param("pid") Integer pid, @Param("shstatus") Integer shstatus);

    void updatePmxStatus(@Param("pid") Integer pid, @Param("id") Long id, @Param("shstatus") Integer shstatus);

    Integer findQjmxInfo(@Param("pid") Integer pid, @Param("id") Long id);

    Integer findMaxShunxu(Integer pid);

    void updatePmxShunxu(@Param("pid") Integer pid, @Param("pshunxu") Integer pshunxu);
}
