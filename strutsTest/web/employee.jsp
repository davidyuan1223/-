<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/1
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>雇员</title>
</head>
<body>
    <s:form action="empinfo" method="POST">
        <s:textfield name="name" label="Name" size="20"/>
        <s:textfield name="age" label="Age" size="20"/>
        <s:submit name="submit" label="Submit" align="center"/>
    </s:form>
</body>
</html>
