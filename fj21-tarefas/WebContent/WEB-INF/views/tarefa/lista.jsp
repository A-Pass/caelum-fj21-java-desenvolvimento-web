<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de terefas</title>

<link rel="stylesheet" href="<c:url value="/resources/css/tarefas.css" />" />

<script src="<c:url value="/resources/js/jquery-3.5.1.min.js" />"></script>

<script>
function finalizaTarefa(id) {
	$.post('finalizaTarefa', {id}, function(resposta) {
		$('#tarefa_' + id).html(resposta);
	})
}

function removeTarefa(id) {
	$.get('removeTarefa', {id}, function() {
		$('#tarefa_' + id).remove();
	})
}
</script>
</head>
<body>

<a href="novaTarefa">Adicionar nova tarefa</a>

<table>
	<thead>
		<tr>
			<th>Id</th>
			<th>Descrição</th>
			<th>Finalizado?</th>
			<th>Data de finalização</th>
			<th>Opções</th>
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