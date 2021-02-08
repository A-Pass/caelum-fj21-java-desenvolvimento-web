<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Adiciona Contato</title>

<link rel="stylesheet" href="<c:url value="/css/jquery-ui-1.12.1.min.css" />" />
<script src="<c:url value="/js/jquery-3.5.1.min.js" />"></script>
<script src="<c:url value="/js/jquery-ui-1.12.1.min.js" />"></script>

</head>
<body>

	<c:import url="cabecalho.jsp" />

	<form action="adicionaContato">
		<div>
			<label>Nome:<input type="text" name="nome" /></label>
		</div>

		<div>
			<label>E-mail:<input type="text" name="email" /></label>
		</div>

		<div>
			<label>Endereço: <input type="text" name="endereco" /></label>
		</div>

		<div>
			<label>Data de Nascimento: 
				<caelum:campoData id="dataNascimento"/>
			</label>
		</div>

		<button type="submit">Salvar</button>

		<c:import url="rodape.jsp" />
	</form>
</body>
</html>