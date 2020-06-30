<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/8
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Title</title>

    <link href="<c:url value='/css/style.css'/>" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="<c:url value='/csstree/zTreeStyle.css'/>" type="text/css">
    <link rel="stylesheet" href="<c:url value='../../bootstrap-3.3.7-dist/css/bootstrap.css'/>" type="text/css">

    <!-- tree.js 树的js文件，jquery不能删，jquery和tree的结合的 -->
    <script type="text/javascript" src="<c:url value='/js/tree.js'/>"></script>
    <script type="text/javascript" src="<c:url value='../../js/jquery-1.8.2.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/jquery.ztree.all-3.3.js'/>"></script>
    <script type="text/javascript" src="../../js/calendarTime.js"></script>

    <script>

        // function deleteUser(id) {
        //     var username = $(this).parent().siblings().eq(1).val();
        //     var confirm = window.confirm("确认删除姓名为【"+username+"】的用户吗？");
        //     console.log(username);
        //     if(confirm){
        //        // window.location = "deleteUser.do?id="+id;
        //     }
        //
        // }

    </script>
</head>
<body>
<center>
    <form action="findUser.do" method="post">
        按照名字:<input type="text" placeholder="输入用户名查询" name="mohu"><br><br>
        按照生日:<input type="text" name="sbirthday" onclick="setDay(this)">---
                <input type="text" name="ebirthday" onclick="setDay(this)"><br>
                <input class="btn btn-default" type="submit" value="查询">
    </form>
    <a href="toAddUser.do"><button class="btn btn-default">增加用户</button></a>
        <table style="width: 1000px;height: 350px; text-align: center" class="table table-hover" cellpadding="5" cellspacing="0" border="1">
            <tr>
                <th>编码</th>
                <th>姓名</th>
                <th>密码</th>
                <th>部门</th>
                <th>角色</th>
                <th>年龄</th>
                <th>生日</th>
                <th colspan="3">操作</th>
            </tr>
            <c:forEach var="u" items="${list}">
                <tr>
                    <td>${u.id}</td>
                    <td> ${u.username}</td>
                    <td>${u.password}</td>
                    <td>${u.dept.dname}</td>
                    <td> ${u.role.rname}</td>
                    <td>${u.age}</td>
                    <td><fmt:formatDate value="${u.birthday}" pattern="yyyy-MM-dd"></fmt:formatDate> </td>
                    <td><a href="/toUserDeptRole.do?id=${u.id}"><button class="btn btn-default">分配部门和角色</button></a></td>
                    <td><a href="/deleteUser.do?id=${u.id}"><button class="btn btn-danger">删除</button></a></td>
                    <td><a href="/toUpdateUser.do?id=${u.id}&deptid=${u.dept.deptid}"><button class="btn btn-warning">修改</button></a></td>
                </tr>
            </c:forEach>
        </table>
    <jsp:include page="/page.jsp"></jsp:include>
</center>
</body>
</html>
