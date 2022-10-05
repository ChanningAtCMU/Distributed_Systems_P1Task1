<%--
  Created by IntelliJ IDEA.
  User: Channing Zheng
  Date: 2022/9/23
  Time: 1:00
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
    <title>Hash Outputs</title>
</head>
    <body>
        <%-- Display outputs by getting parameters and attributes from request --%>
        <h2>Input: <%= request.getParameter("anyInput") %> <br><br>
            Hash Mode: <%= request.getParameter("hashMode") %> <br><br>
            Hash Result: <%= request.getAttribute("finalHashMode") %> <br><br>
            Base 64 Notation: <%= request.getAttribute("finalBase64") %> </h2><br>

        <%-- Again ask users to input  --%>
        <form action="input" method="GET">
            <input type="text" name="anyInput" value="This is a default input."/><br><br>
            <input type="radio" name="hashMode" value="MD5" checked>MD5
            <input type="radio" name="hashMode" value="SHA-256">SHA-256 <br><br>
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>


