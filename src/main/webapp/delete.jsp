<%@page import="it.prova.gestionetv.model.Televisore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Rimuovi Televisore</title>
	</head>
	<body>
		<div align="center">
			<h1>Televisore da eliminare</h1>
			<% Televisore televisoreInPagina = (Televisore)request.getAttribute("televisoreDaInviareARimuovi"); %>
			<p>Marca: <%=televisoreInPagina.getMarca() %></p>
			<p>Modello: <%=televisoreInPagina.getModello() %></p>
			<p>Prezzo: <%=televisoreInPagina.getPrezzo() %></p>
			<p>Numero Pollici: <%=televisoreInPagina.getNumeroPollici() %></p>
			<p>Codice: <%=televisoreInPagina.getCodice() %></p>
			<br>
			<br>
			<a href="PrepareListAllTelevisoreServlet">Back</a>
			<br>
			<br>
			<form action="ExecuteDeleteTelevisoreServlet" method="post" >
			<input type="hidden" name="idDaRimuovere" value="<%= televisoreInPagina.getIdTelevisore()%>">
			<input type="submit" value="OK">
			</form>
		</div>
	</body>
</html>