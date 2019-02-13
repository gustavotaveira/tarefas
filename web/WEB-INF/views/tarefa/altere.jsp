<%--
  Created by IntelliJ IDEA.
  User: Gustavo Vinicius
  Date: 11/02/2019
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl-core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jstl-formatting" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tag-utils" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Alteracao do contato</title>
    <style>
        input {
            display: block;
        }

        textarea {
            display: block;
        }
    </style>
</head>
<body>
<h1>Altere o contato</h1>
<%--suppress HtmlUnknownTarget --%>
<form action="alterar" method="post">
    <input type="number" value="${tarefa.id}" name="id" title="id" hidden>
    Descricao:<textarea cols="20" rows="6" name="descricao" title="Descricao">${tarefa.descricao}</textarea>
    Finalizado:<input type="checkbox" title="Finalizado" name="finalizado" ${tarefa.finalizado? 'checked':''}>
    <tag-utils:campo-data id="datafinalizacao" label="Data de finalizacao:" value="${tarefa.datafinalizacao}"/>
    <input type="submit" value="Alterar">
</form>
</body>
</html>
