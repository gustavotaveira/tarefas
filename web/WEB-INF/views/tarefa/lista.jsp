<%--
  Created by IntelliJ IDEA.
  User: Gustavo Vinicius
  Date: 11/02/2019
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl-core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jstl-formatting" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Listagem de Tarefas</title>
</head>
<body>
<h2>Listagem de tarefas</h2>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Descricao</th>
        <th>Finalizado</th>
        <th>Data de finalizacao</th>
        <th>Opcoes</th>
        <th>Opcoes</th>
    </tr>
    </thead>
    <tbody>
    <jstl-core:forEach items="${tarefas}" var="tarefa">
        <tr>
            <td>${tarefa.id}</td>
            <td>${tarefa.descricao}</td>
            <td>
                <jstl-core:choose>
                    <jstl-core:when test="${tarefa.finalizado}">
                        Finalizado
                    </jstl-core:when>
                    <jstl-core:otherwise>
                        Não finalizado
                    </jstl-core:otherwise>
                </jstl-core:choose>
            </td>
            <td>
                <jstl-formatting:formatDate value="${tarefa.datafinalizacao}" pattern="dd/MM/yyyy"/>
            </td>
            <td>
                <a href="altere?id=${tarefa.id}">Alterar</a>
            </td>
            <td>
                <a href="remove?id=${tarefa.id}">Excluir</a>
            </td>
        </tr>
    </jstl-core:forEach>
    </tbody>
</table>
</body>
</html>
