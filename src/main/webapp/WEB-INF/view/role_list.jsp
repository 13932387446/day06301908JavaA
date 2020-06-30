<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/8
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>

    <link href="<c:url value='/css/style.css'/>" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="<c:url value='/csstree/zTreeStyle.css'/>" type="text/css">
    <link rel="stylesheet" href="<c:url value='../../bootstrap-3.3.7-dist/css/bootstrap.css'/>" type="text/css">

    <!-- tree.js 树的js文件，jquery不能删，jquery和tree的结合的 -->
    <script type="text/javascript" src="<c:url value='/js/tree.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/jquery-1.8.2.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/jquery.ztree.all-3.3.js'/>"></script>
</head>
<body>
<center>
    <table style="width: 500px;height: 400px; text-align: center" class="table table-hover" cellpadding="5" cellspacing="0" border="1">
        <tr>
            <th>编码</th>
            <th>名称</th>
            <th>部门</th>
            <th colspan="2">操作</th>
        </tr>
        <c:forEach var="u" items="${roleList}">
            <tr>
                <td>${u.rid}</td>
                <td>${u.rname}</td>
                <td>${u.dept.dname}</td>
                <td><a href="toDeptRole.do?deptid=${u.rid}"><button class="btn btn-default">选择部门</button></a></td>
                <td><a href="findPowerByRid.do?rid=${u.rid}"><button class="btn btn-default">选择角色</button></a></td>
            </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>
