<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <title>查询成功</title>
    </head>
    <body>
        Hello:
        name:<s:property value="name"/>
        gender:<s:property value="gender"/>
        age:<s:property value="age"/>
        address:<s:property value="address"/>
        qq:<s:property value="qq"/>
        email:<s:property value="email"/>
    </body>
</html>