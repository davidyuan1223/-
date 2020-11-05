<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/1
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>查询</title>
</head>
<body>
    <form action="query.action" method="post">
        <label>
            name:
            <input type="text" name="name">
        </label><br>
        <input type="submit" value="query">
    </form>
</body>
</html>
