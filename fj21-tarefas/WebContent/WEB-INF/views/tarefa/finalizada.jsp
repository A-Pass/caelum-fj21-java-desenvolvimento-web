<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<td>${tarefa.id}</td>
<td>${tarefa.descricao}</td>
<td id="tarefa_${tarefa.id}_finalizado">
	<c:if test="${tarefa.finalizado eq true}">
		Finalizado
	</c:if>
	<c:if test="${tarefa.finalizado eq false}">
		<a href="#" onclick="finalizaTarefa(${tarefa.id})">Finalizar agora</a>
	</c:if>
</td>
<td>
	<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>
</td>
<td>
	<a href="#" onclick="removeTarefa(${tarefa.id})">Remover</a>
	<a href="mostraTarefa?id=${tarefa.id}" ">Alterar</a>
</td>