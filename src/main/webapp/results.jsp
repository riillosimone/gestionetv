<%@page import="it.prova.gestionetv.model.Televisore"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Risultati</title>
		<style type="text/css">
			table, th, td {
			  border: 1px solid black;
			}
	
			th, td {
			  padding: 10px;
			}
			.center {
				margin-left: auto;
				margin-right: auto;
			}
	
			.margin-top-10px {
			    margin-top: 10px;
			}
		</style>

	</head>
	<body>
		<table class="center">
		<thead>
			<tr>
				<th>Marca</th>
				<th>Modello</th>
				<th>Azione</th>
			</tr>
		</thead>
		
		<% List<Televisore> listaDaServlet = (List<Televisore>)request.getAttribute("listaTelevisoreAttributeName");
							for(Televisore televisoreItem : listaDaServlet){
				%>
				<tr>
					<td><%=televisoreItem.getMarca() %></td>
					<td><%=televisoreItem.getModello() %></td>
					<td>
						<a href="ExecuteShowTelevisoreServlet?idDaInviareComeParametro=<%=televisoreItem.getIdTelevisore() %>">Dettaglio</a>
						<a href="PrepareEditTelevisoreServlet?idDaInviareComeParametro=<%=televisoreItem.getIdTelevisore() %>">Modifica</a>
						<a href="PrepareDeleteTelevisoreServlet?idDaInviareComeParametro=<%=televisoreItem.getIdTelevisore() %>">Cancella</a>
					</td>
				</tr>
		<%	}%>
	
		</table>
		<div align="center" class="margin-top-10px">
			<a href="searchForm.jsp" >Torna alla Ricerca</a>
		</div>
		<div align="center" class="margin-top-10px">
			<a href="PrepareInsertTelevisoreServlet" >Inserisci Nuovo</a>
		</div>
	
	
	</body>
</html>