<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/2
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>多种语言环境</title>
</head>
<body>
    <h1><s:text name="global.heading"/></h1>
    <s:url id="indexEN" namespace="/" action="locale">

    </s:url>
    <s:url id="indexES" namespace="/" action="locale">

    </s:url>
    <s:url id="indexFR" namespace="/" action="locale">

    </s:url>
    <s:a href="%{indexEN}">English</s:a>
    <s:a href="%{indexES}" >Spanish</s:a>
    <s:a href="%{indexFR}" >France</s:a>
    <s:form action="employee" method="post" namespace="/">
        <s:textfield name="name" key="global.name" size="20"/>
        <s:textfield name="age" key="global.age" size="20"/>
        <s:submit name="submit" key="global.submit"/>
    </s:form>
</body>
</html>
