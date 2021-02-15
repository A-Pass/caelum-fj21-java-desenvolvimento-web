<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<c:url value="/resources/js/jquery-3.5.1.min.js" />"></script>

<script>
function finalizaTarefa(id) {
	$.post('finalizaTarefa', {id}, function(resposta) {
		$('#tarefa_' + id).html(resposta);
	})
}

function removeTarefa(el) {
	$.get('removeTarefa', {id}, function() {
		$(this).closest("tr").remove();
	})
}
</script>
</head>
<body>

<a href="novaTarefa">Adicionar nova tarefa</a>

<table>
	<thead>
		<tr>
			<td>Id</td>
			<td>Descrição</td>
			<td>Finalizado?</td>
			<td>Data de finalização</td>
			<td>Opções</td>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${tarefas}" var="tarefa">
			<tr id="tarefa_${tarefa.id}">
				<%@ include file="finalizada.jsp" %>
			</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>