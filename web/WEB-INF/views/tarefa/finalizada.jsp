<%@ taglib prefix="jstl-formatting" uri="http://java.sun.com/jsp/jstl/fmt" %>
<td>${tarefa.id}</td>
<td>${tarefa.descricao}</td>
<td>Finalizado</td>
<td><jstl-formatting:formatDate value="${tarefa.datafinalizacao}" pattern="dd/MM/yyyy"/></td>
<td><a href="tarefa/altere?id=${tarefa.id}">Alterar</a></td>
<td><a href="tarefa/remove?id=${tarefa.id}">Excluir</a></td>
<td align="center">-</td>