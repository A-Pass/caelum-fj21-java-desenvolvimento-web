<%@ page
	import="java.util.List,
				 java.text.SimpleDateFormat,
				 br.com.caelum.agenda.dao.ContatoDAO, 
				 br.com.caelum.agenda.modelo.Contato"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>E-mail</th>
				<th>Endereço</th>
				<th>Data de Nascimento</th>
			</tr>
		</thead>
		<%
		List<Contato> contatos = new ContatoDAO().getLista();
		for (Contato contato : contatos) {
		%>
		<tr>
			<td><%=contato.getNome()%></td>
			<td><%=contato.getEmail()%></td>
			<td><%=contato.getEndereco()%></td>
			<td><%=new SimpleDateFormat("dd/MM/yyyy").format(contato.getDataNascimento().getTime())%></td>
		</tr>
		<%
		}
		%>

	</table>
</body>
</html>