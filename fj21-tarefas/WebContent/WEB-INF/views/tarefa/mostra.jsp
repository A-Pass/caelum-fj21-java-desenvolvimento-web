<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="custom" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui-1.12.1.min.css" />" />
<script src="<c:url value="/resources/js/jquery-3.5.1.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery-ui-1.12.1.min.js" />"></script>
</head>
<body>
	<h3>Alterar tarefa - ${tarefa.id}</h3>

	<form action="alteraTarefa" method="post">
		<input id="id" name="id" type="hidden" value="${tarefa.id}"/>

		<div>
			<label for="descricao">Descrição</label> <br />
			<textarea id="descricao" name="descricao" cols="30" rows="10">${tarefa.descricao}</textarea>
		</div>
		<div>
			<label for="finalizado">Finalizado?</label>
			<input id="finalizado" name="finalizado" type="checkbox" ${tarefa.finalizado ? "checked=\"checked\"" : ""} />
		</div>
		
		<div>
			<custom:campoData id="dataFinalizacao" value="${tarefa.dataFinalizacao.time}"></custom:campoData>
		</div>
		<button type="submit">Alterar</button>
	</form>
</body>
</html>