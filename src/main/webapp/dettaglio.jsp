<%@page import="it.prova.gestionetv.model.Televisore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Dettaglio Televisore</title>
	</head>
	<body>
		<div align="center">
			<h1>Televisore selezionato</h1>
			<% Televisore televisoreInPagina = (Televisore)request.getAttribute("televisoreDaInviareAPaginaDettalio"); %>
			<p>Marca: <%=televisoreInPagina.getMarca() %></p>
			<p>Modello: <%=televisoreInPagina.getModello() %></p>
			<p>Prezzo: <%=televisoreInPagina.getPrezzo() %></p>
			<p>Numero Pollici: <%=televisoreInPagina.getNumeroPollici() %></p>
			<p>Codice: <%=televisoreInPagina.getCodice() %></p>
			<br>
			<br>
			<a href="searchForm.jsp">Home</a>
			<a href="PrepareListAllTelevisoreServlet">Lista Televisori</a>
		</div>
	</body>
</html>