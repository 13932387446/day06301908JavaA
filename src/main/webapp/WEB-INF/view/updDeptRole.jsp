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

    <!-- tree.js 树的js文件，jquery不能删，jquery和tree的结合的 -->
    <script type="text/javascript" src="<c:url value='/js/tree.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/jquery-1.8.2.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/js/jquery.ztree.all-3.3.js'/>"></script>
</head>
<body>
<center>
       <form action="saveDeptRole.do" method="post" >
           <font size="5" color="#5f9ea0">目前正在给【${dept.dname}】部门选择角色</font><br>
           <input type="hidden" value="${dept.deptid}" name="deptid">
           <c:forEach var="r" items="${list}">
               <input name="rids" type="checkbox" value="${r.rid}"  <c:forEach items="${rid}" var="rr">${r.rid == rr?'checked':''}</c:forEach>
               />${r.rname}<br>
           </c:forEach>
           <input type="submit" value="提交">
       </form>
</center>
</body>
</html>
