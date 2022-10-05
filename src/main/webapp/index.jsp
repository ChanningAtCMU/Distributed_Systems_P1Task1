<%--
  Created by IntelliJ IDEA.
  User: Channing Zheng
  Date: 2022/9/23
  Time: 1:00
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title> Hash Converter </title>
</head>
<body>
    <h1>Welcome to Hash Converter</h1><br><br>
    <%-- Create a form to get all the inputs--%>
    <form action="input" method="GET">
        Enter anything: <input type = "text" name = "anyInput" value="This is a default input."/>
        <br><br>

        Select your hash mode:
        <input type = "radio" name = "hashMode" value = "MD5" checked>MD5
        <input type = "radio" name = "hashMode" value = "SHA-256">SHA-256 <br><br>
        <input type = "submit" value = "Let's GO Hash!" />

    </form>
</body>
</html>