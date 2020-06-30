<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/8
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <table class="table table-hover" cellpadding="5" cellspacing="0" border="1">
        <font size="8px" color="#008b8b">下面是我的请假明细</font>
        <tr>
            <%--要是我们前台需要这些展示的数据，那么就需要去后台想办法给我查询这个数据--%>
            <th>编号</th>
            <th>请假时长(天)</th>
            <th>请假时间</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>请假原因</th>
            <th>角色</th>
            <th>操作者</th>
            <th>审批状态</th>
        </tr>
        <c:forEach var="qj" items="${list}">
            <tr>
                <td>${qj.id}</td>
                <td>${qj.qjtime}</td>
                <td></td>
                <td><fmt:formatDate value="${qj.stime}" pattern="yyyy-MM-dd HH"/></td>
                <td><fmt:formatDate value="${qj.etime}" pattern="yyyy-MM-dd HH"/></td>
                <td>${qj.qjcause}</td>
                <td>${qj.rname}</td>
                <td>${qj.uname}</td>
                <td>${qj.statusStr}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="100"><a href="toStuQj.do">新增请假</a></td>
        </tr>
    </table>
</center>
</body>
</html>
