<%@ taglib prefix="jstl-core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring-form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login</title>
    <style>

        body {
            font-size: 25px
        }

        h2 {
            font-family: sans-serif;
            text-align: center;
            margin-top: 150px;
        }

        #box-form {
            margin: 0 auto;
            width: 500px;
            border: 1px solid black;
        }

        section {
            margin-left: 155px
        }

        input {
            margin-bottom: 5px;
            display: block;
            height: 30px;
            width: 200px;
        }

        input[type="text"] {

        }

        input[type="password"] {
        }

        input[type="submit"] {
            font-size: 20px;
            margin-top: 15px;
        }

        #sucessos {
            margin: 0 auto;
            border: 1px solid darkgreen;
            background-color: lightgreen;
            border-radius: 3px;
        }

        #messages {
            width: 500px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<h2>Pagina de Login - Tarefas</h2>
<div id="messages">
    <jstl-core:if test="${not empty sucesso}">
        <span id="sucessos">Cadastro realizado com sucesso!</span>
    </jstl-core:if>
    <spring-form:errors cssStyle="color: red" path="usuario.senha"/>
    <spring-form:errors cssStyle="color: red" path="usuario.login"/>
</div>
<div id="box-form">
    <section>
        <form action="${pageContext.request.contextPath}/login" method="post">
            Login:<input type="text" name="login"/>
            Senha:<input type="password" name="senha"/>
            <input type="submit" value="Entrar"/>
        </form>
        <p><a href="login/cadastreUsuario">Nao sou cadastrado</a></p>
    </section>
</div>
</body>
</html>