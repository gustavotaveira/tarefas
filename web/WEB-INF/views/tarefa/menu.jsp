<%--
  Created by IntelliJ IDEA.
  User: Gustavo Vinicius
  Date: 18/02/2019
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logado</title>
    <style>
        div {
            border: 1px solid black;
            width: 500px;
            margin: 0 auto;
        }

        #logout {

        }

    </style>
</head>
<body>
<div>
    <h2>Pagina inicial</h2>
    <p>Seja bem-vindo ${usuarioLogado.login}</p>
    <p>Clique <a href="${pageContext.request.contextPath}/tarefa/lista">aqui</a> para acessar a listagem de tarefas</p>
    <a id="logout" href="${pageContext.request.contextPath}/login/logout">Sair</a>
</div>
</body>
</html>
