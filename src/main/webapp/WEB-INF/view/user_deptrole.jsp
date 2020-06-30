<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/9 0009
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../../js/jquery-1.8.2.js"></script>
    <link href="../../bootstrap-3.3.7-dist/css/bootstrap.css">
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

<form action="saveUserDeptRole.do" method="post">
    <input type="hidden" name="id" value="${user.id}">
    <font>选择部门</font><select name="deptid"  onchange="findRoleDept(this)">
                                <option value="-1">--请选择--</option>
                            <c:forEach items="${dlist}" var="d">
                                <option value="${d.deptid}" ${user.dept.deptid == d.deptid?'selected':''} >${d.dname}</option>
                            </c:forEach>
                            </select>
    <font>选择角色</font><select name="rid">
                            <option value="-1">--请选择--</option>
                            <c:forEach items="${rolist}" var="r">
                                <option value="${r.rid}" ${user.role.rid == r.rid?'selected':''} >${r.rname}</option>
                            </c:forEach>
</select>
    <input type="submit" value="保存">
</form>

</body>
</html>
