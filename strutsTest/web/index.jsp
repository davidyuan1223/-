<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/31
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>FileUpload</title>
  </head>
  <body>
    <form action="upload.action" method="post" enctype="multipart/form-data">
      <%--@declare id="myfile"--%><label for="myFile">Upload your file</label>
      <input type="file" name="myFile">
      <input type="submit" value="UpLoad">
    </form>
  </body>
</html>
