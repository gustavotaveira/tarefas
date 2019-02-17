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
    <script src="<jstl-core:url value="/resources/js/jquery-3.3.1.js"/>"></script>
    <script>
        function finaliza(id) {
            $.ajax({
                url: "/tarefas/tarefa/finalizar",
                type: "POST",
                data: {"id": id},
                success: function () {
                    $("#tarefa_" + id).html("Finalizado");
                    $("#finaliza_" + id).html("");
                    $("#datafinalizacao_" + id).html()
                },
                error: function () {
                    alert("Nao funfou");
                }
            });
        }
    </script>
</head>
<body>
<p id="joao"></p>
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
        <th>Opcoes</th>
    </tr>
    </thead>
    <tbody>
    <jstl-core:forEach items="${tarefas}" var="tarefa">
        <tr>
            <td>${tarefa.id}</td>
            <td>${tarefa.descricao}</td>
            <td id="tarefa_${tarefa.id}">
                <jstl-core:choose>
                    <jstl-core:when test="${tarefa.finalizado}">
                        Finalizado
                    </jstl-core:when>
                    <jstl-core:otherwise>
                        Não finalizado
                    </jstl-core:otherwise>
                </jstl-core:choose>
            </td>
            <td id="datafinalizacao_${tarefa.id}">
                <jstl-formatting:formatDate value="${tarefa.datafinalizacao}" pattern="dd/MM/yyyy"/>
            </td>
            <td>
                <a href="altere?id=${tarefa.id}">Alterar</a>
            </td>
            <td>
                <a href="remove?id=${tarefa.id}">Excluir</a>
            </td>
            <td id="finaliza_${tarefa.id}">
                <jstl-core:if test="${tarefa.finalizado eq false}">
                    <a href="#" onclick="finaliza(${tarefa.id})">Finaliza agora</a>
                </jstl-core:if>
            </td>
        </tr>
    </jstl-core:forEach>
    </tbody>
</table>
</body>
</html>
