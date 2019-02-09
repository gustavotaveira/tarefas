<%--
  Created by IntelliJ IDEA.
  User: Gustavo Vinicius
  Date: 09/02/2019
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
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

        p {
            margin: 200px auto;
            border: 1px solid black;
        }

        textarea {
            display: block;
        }
    </style>
</head>
<body>
<div>
    <form action="tarefa" method="post">
        <label for="descricaoid">Descricao:</label>
        <textarea id="descricaoid" name="descricao"></textarea>
        <input id="button-submit" type="submit" value="Salvar"/>
    </form>
</div>
</body>
</html>
