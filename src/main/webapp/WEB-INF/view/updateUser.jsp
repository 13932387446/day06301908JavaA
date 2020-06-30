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
    <form action="/updateUser.do" method="post">
        <input type="file" name="file"><br><br>
        <input type="submit" value="上传">
        <input type="hidden" name="id" value="${user.id}">
        <p>姓名:<input type="text" value="${user.username}" name="username"></p>
        <p>密码:<input type="password" value="${user.password}" name="password"></p>
        <p>年龄:<input type="text" value="${user.age}" name="age"></p>
        部门:<select name="deptid"  onchange="findRoleDept(this)">
        <option value="-1">--请选择--</option>
        <c:forEach items="${dlist1}" var="d">
            <option value="${d.deptid}" ${user.dept.deptid == d.deptid?'selected':''}>${d.dname}</option>
        </c:forEach>
    </select><br>
        角色:<select name="rid">
        <option value="-1">--请选择--</option>
        <c:forEach items="${rlist1}" var="r">
            <option value="${r.rid}" ${user.role.rid == r.rid?'selected':''}>${r.rname}</option>
        </c:forEach>
    </select>
        <p>生日:<input type="text" name="birthday" onclick="setDayHM(this)"></p>
        <input type="submit" value="提交">
    </form>
</center>
</body>
</html>
