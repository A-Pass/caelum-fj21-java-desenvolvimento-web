<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/resources/css/tarefas.css" />" />
</head>
<body>
<form action="efetuaLogin" method="post">
	<div>
		<label for="login">Usuário:</label>
		<input name="login" type="text" required="required"/>
	</div>
	
	<div>
		<label for="senha">Senha:</label>
		<input name="senha" type="password" required="required"/>
	</div>
	
	<button type="submit">Entrar nas tarefas</button>
</form>
</body>
</html>