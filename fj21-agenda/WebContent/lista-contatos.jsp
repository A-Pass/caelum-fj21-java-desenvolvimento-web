<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
table {
	border-collapse: collapse;
}

td, th {
	border: solid 1px black;
}

.odd {
	background-color: #eee;
}

.even {
	background-color: #bbb;
}
</style>
</head>
<body>
	<c:import url="cabecalho.jsp" />

	<jsp:useBean id="dao" class="br.com.caelum.agenda.dao.ContatoDAO"></jsp:useBean>

	<display:table name="${dao.lista}" id="tblContato">
		<display:column title="Nome" property="nome" />
		<display:column title="E-mail" property="email" />
		<display:column title="Endereco" property="endereco" />
		<display:column title="Data de Nascimento">
			<fmt:formatDate value="${tblContato.dataNascimento.time}" pattern="dd/MM/yyyy" />
		</display:column>
	</display:table>

	<c:import url="rodape.jsp" />
</body>
</html>