<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Nova Tarefa</title>
</head>
<body>
	<form action="adicionaTarefa" method="post">
		<label for="descricao">Descrição</label> <br />
		<textarea id="descricao" name="descricao" type="text" require="required" rows="5" cols="50"></textarea> <br />
		<form:errors path="tarefa.descricao" /> <br />
		
		<button type="submit">Criar</button>
	</form>	
</body>
</html>