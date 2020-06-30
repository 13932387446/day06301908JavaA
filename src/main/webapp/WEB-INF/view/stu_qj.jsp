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
    <script src="../../js/calendarTime.js"></script>
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
    <form action="saveStuQj.do" method="post">
        <table class="table table-hover" cellpadding="5" cellspacing="0" border="1">
            <tr>
                <font size="5px" color="#008b8b">${stu.username}的请假信息</font>
                <input type="hidden" name="sid" value="${stu.id}"/>
            </tr>
            <tr>
                <td>请假时间</td>
                <td><input name="qjtime" type="text"></td>
            </tr>
            <tr>
                <td>选择</td>
                <td>
                    开始时间：<input type="text" name="stime" onclick="setDayH(this)">
                    结束时间：<input type="text" name="etime" onclick="setDayH(this)">
                </td>
            </tr>
            <tr>
                <td>请假原因</td>
                <td><input type="text" name="qjcause"></td>
            </tr>
            <tr>
                <td colspan="100">
                    <input type="submit" value="提交">
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
