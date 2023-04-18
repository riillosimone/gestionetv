<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Inserisci nuovo</title>
	</head>
	<body>
		<div align="center">
			<% if(request.getAttribute("messaggioDiErrore") != null){ %>
			<p style="color: red;"><%=request.getAttribute("messaggioDiErrore") %></p>
			<%  }else{ %>
			<h1>Inserisci nuovo televisore</h1>
			<%}    %>
				
			<form action="ExecuteInsertTelevisoreServlet" method="post">
				<label for="marcaNuovoInputId">Marca:</label>
				<input type="text" name="marcaNuovoInput" id="marcaNuovoInputId">
				<br>
				<br>
				<label for="modelloNuovoInputId">Modello:</label>
				<input type="text" name="modelloNuovoInput" id="modelloNuovoInputId">
				<br>
				<br>
				<label for="prezzoNuovoInputId">Prezzo:</label>
				<input type="text" name="prezzoNuovoInput" id="prezzoNuovoInputId">
				<br>
				<br>
				<label for="numeroPolliciNuovoInputId">Numero Pollici:</label>
				<input type="text" name="numeroPolliciNuovoInput" id="numeroPolliciNuovoInputId">
				<br>
				<br>
				<label for="codiceNuovoInputId">Codice:</label>
				<input type="text" name="codiceNuovoInput" id="codiceNuovoInputId">
				<br>
				<br>
				<a href="PrepareListAllTelevisoreServlet">Back</a>
				<br>
				<br>
				<input type="submit" value="Inserisci"> 
				
			</form>
		</div>
	</body>
</html>