<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/1
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>发送邮件</title>
</head>
<body>
    <em>The form below uses Google's SMTP server.
        So you need to enter a gemil username and password.
    </em>
    <form action="emailer.action" method="post">

        <label for="from">
            From:
            <input type="text" name="from" id="from">
        </label>
        <br/>
        <label for="password">password: </label><input type="password" name="password" id="password"><br/>
        <label for="to">To: </label><input type="text" name="to" id="to"><br/>
        <label for="subject">subject: </label><input type="text" name="subject" id="subject"><br/>
        <label for="body">body: </label><input type="text" name="body" id="body"><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
