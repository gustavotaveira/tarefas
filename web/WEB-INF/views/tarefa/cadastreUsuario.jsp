<%--
  Created by IntelliJ IDEA.
  User: Gustavo Vinicius
  Date: 18/02/2019
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastre</title>
    <style>
        div {
            width: 500px;
            margin: 0 auto;
            font-size: 25px;
        }
    </style>
</head>
<body>
<div>
    <h2>Cadastre um novo usuario</h2>
    <form action="${pageContext.request.contextPath}/login/cadastre" method="post">
        Login:<input type="text" name="login">
        Senha:<input type="password" name="senha">
        <input type="submit" value="Cadastrar">
    </form>
    (
</div>
</body>
</html>
