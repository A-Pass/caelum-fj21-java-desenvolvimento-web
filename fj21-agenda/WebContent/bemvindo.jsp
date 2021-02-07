<!doctype html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8" />
<title>Bem-vindo!</title>
</head>
<body>
	<%-- comentário e JSP aqui: nossa primeira página JSP --%>

	<%
	String mensagem = "Bem vindo ao sistema de agenda do FJ-21!";
	%>
	<% out.println(mensagem); %>

	<br />

	<%
	String desenvolvido = "Desenvolvido por Anderson Passos Silva";
	%>
	<%= desenvolvido %>
	
	<br />
	
	<%
	System.out.println("Tudo foi executado!");
	%>
</body>
</html>