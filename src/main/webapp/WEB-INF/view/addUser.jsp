<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/11 0011
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>

    <script src="../../js/jquery-1.8.2.js"></script>
    <script type="text/javascript" src="../../js/calendarTime.js"></script>
<script>
    function findRoleDept(obj) {
        $.post("findRoleByDeptId.do",
        { deptid:obj.value},
        function (data) {
        var reselect = $("[name=rid]");
        // document.getElementsByName("rid")[0].length=1;
        var rList = data;
        $("[name=rid]").empty();
        reselect.append("<option value='-1'>--请选择--</option>");
        for (var i = 0; i < rList.length; i++) {
        reselect.append("<option value="+rList[i].rid+">"+rList[i].rname+"</option>");
        }
        });
    }
</script>
</head>
<body>
<center>
    <form action="/addUser.do" method="post">
        <p>姓名:<input type="text" placeholder="请输入姓名" name="username"></p>
        <p>密码:<input type="password" placeholder="请输入密码" name="password"></p>
        <p>年龄:<input type="text" placeholder="请输入年龄" name="age"></p>
        部门:<select name="deptid"  onchange="findRoleDept(this)">
            <option value="-1">--请选择--</option>
            <c:forEach items="${deptList}" var="d">
                <option value="${d.deptid}">${d.dname}</option>
            </c:forEach>
        </select><br>
        角色:<select name="rid">
            <option value="-1">--请选择--</option>
            <c:forEach items="${rolist}" var="r">
                <option value="${r.rid}" }>${r.rname}</option>
            </c:forEach>
        </select>
        <p>生日:<input type="text" name="birthday" onclick="setDayHM(this)"></p>
        <input type="submit" value="提交">
    </form>
</center>
</body>
</html>
