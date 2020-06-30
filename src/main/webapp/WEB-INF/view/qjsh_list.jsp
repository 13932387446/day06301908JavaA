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
        <font size="8px" color="#008b8b">下面是需要我审核的请假条</font>
        <tr>
            <%--要是我们前台需要这些展示的数据，那么就需要去后台想办法给我查询这个数据--%>
            <th>编号</th>
            <th>学生姓名</th>
            <th>学生班级</th>
            <th>请假时长(天)</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>请假原因</th>
            <th colspan="100">操 作</th>
        </tr>
        <c:forEach var="qj" items="${list}">
            <tr>
                <td>${qj.id}</td>
                <td>${qj.uname}</td>
                <td>${qj.gname}</td>
                <td>${qj.qjtime}</td>
                <td><fmt:formatDate value="${qj.stime}" pattern="yyyy-MM-dd HH"/></td>
                <td><fmt:formatDate value="${qj.etime}" pattern="yyyy-MM-dd HH"/></td>
                <td>${qj.qjcause}</td>
                <td>
                    <input type="radio" name="shstatus" value="1">&nbsp;&nbsp;通过&nbsp;&nbsp;
                    <input type="radio" name="shstatus" value="2">&nbsp;&nbsp;不通过&nbsp;&nbsp;
                    <input type="submit" value="提交" onclick="savewdsh(${qj.id})"></td>
            </tr>
        </c:forEach>
    </table>
</center>
</body>
<script>
    function savewdsh(pid) {
        var obj = document.getElementsByName("shstatus");
        // 获取选中的值
        for (var i = 0; i < obj.length; i++) {
            if(obj[i].checked){
                var shstatus = obj[i].value;
                location.href="saveWdsh.do?pid="+pid+"&shstatus="+shstatus;
            }
         }
      }
</script>
</html>
