<%@ page language="java" contentType="text/html; ISO-8859-1" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <title>
            Example of if and Else
        </title>
    </head>
<body>
    <b>Example of If and Else</b>
    <s:if test="name=='Mike">
        You have selected 'Mike'.
    </s:if>
    <s:elseif test="name=='Jason'">
        You have selected 'Jason'
    </s:elseif>
    <s:else>
        You have not selected 'Mike' or 'Jason'.
    </s:else>
</body>
</html>