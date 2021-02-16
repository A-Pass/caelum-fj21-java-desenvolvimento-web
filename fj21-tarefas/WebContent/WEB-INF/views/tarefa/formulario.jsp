<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Nova Tarefa</title>

<link rel="stylesheet" href="<c:url value="/resources/css/tarefas.css" />" />

</head>
<body>
	<form action="adicionaTarefa" method="post">
		<label for="descricao">Descri��o</label> <br />
		<textarea id="descricao" name="descricao" required="required" rows="5" cols="50"></textarea> <br />
		<form:errors path="tarefa.descricao" /> <br />
		
		<button type="submit">Criar</button>
	</form>	
</body>
</html>