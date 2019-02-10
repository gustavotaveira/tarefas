<%--
  Created by IntelliJ IDEA.
  User: Gustavo Vinicius
  Date: 09/02/2019
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring-form" %>
<%@ taglib prefix="jstl-formatting" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Nova Tarefa</title>
    <style>
        #descricaoid {
            height: 200px;
            width: 300px;
            border-radius: 5px;
        }

        input {
            display: block;
        }

        #button-submit {
            width: 300px;
            text-align: center;
        }

        div {
            margin: 10px auto;
            border: 1px solid black;
            padding: 5px;
            width: 500px;
        }

        textarea {
            display: block;
        }
    </style>
</head>
<body>
<div>
    <spring-form:errors cssStyle="color:red" path="tarefa.descricao"/>
    <form action="tarefa" method="post">
        <label for="descricaoid">Descricao:</label>
        <textarea id="descricaoid" name="descricao"></textarea>
        <input id="button-submit" type="submit" value="Salvar"/>
    </form>
</div>
</body>
</html>
