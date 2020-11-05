<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/2
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>submit</title>
</head>
<body>
    <h1>Hello World</h1>
    <form action="helloWorld.action">
        <label for="name">Please pick a name</label>
        <br>
            <select name="name" id="name">
                <option name="Mile">Mike</option>
                <option name="Jason">Jason</option>
                <option name="Mark">Mark</option>
            </select>
        <input type="submit" value="submit">
    </form>
</body>
</html>
