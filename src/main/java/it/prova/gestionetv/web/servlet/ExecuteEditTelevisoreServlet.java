package it.prova.gestionetv.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionetv.model.Televisore;
import it.prova.gestionetv.service.MyServiceFactory;
import it.prova.gestionetv.utility.UtilityForm;

/**
 * Servlet implementation class ExecuteEditTelevisoreServlet
 */
@WebServlet("/ExecuteEditTelevisoreServlet")
public class ExecuteEditTelevisoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Binding
		String marcaDaPagina = request.getParameter("marcaEditInput");
		String modelloDaPagina = request.getParameter("modelloEditInput");
		String prezzoDaPagina = request.getParameter("prezzoEditInput");
		Double prezzoInDouble = UtilityForm.doubleParseFromString(prezzoDaPagina);
		String numeroPolliciDaPagina = request.getParameter("numeroPolliciEditInput");
		Integer numeroPolliciInInt = UtilityForm.integerParseFromString(numeroPolliciDaPagina);
		String codiceDaPagina = request.getParameter("codiceEditInput");
		String parametroIdTelevisore = request.getParameter("idEditInput");
		Long idTelevisore = Long.parseLong(parametroIdTelevisore);
		Televisore nuovoTelevisore = new Televisore(idTelevisore, marcaDaPagina, modelloDaPagina, prezzoInDouble,
				numeroPolliciInInt, codiceDaPagina);

		// validazione
		if (marcaDaPagina.isBlank() || modelloDaPagina.isBlank() || prezzoDaPagina.isBlank() || prezzoInDouble == null
				|| numeroPolliciDaPagina.isBlank() || numeroPolliciInInt == null || codiceDaPagina.isBlank()) {
			String messaggioDaInviareAPagina = "Attenzione! E' necessario valorizzare TUTTI i campi in maniera corretta.";
			request.setAttribute("messaggioDiErrore", messaggioDaInviareAPagina);
			request.setAttribute("televisoreDaInviareAPaginaModifica",
					MyServiceFactory.getTelevisoreServiceInstance().caricaSingolo(idTelevisore));
			request.getRequestDispatcher("edit.jsp").forward(request, response);
			return;
		}

		MyServiceFactory.getTelevisoreServiceInstance().aggiorna(nuovoTelevisore);
		request.setAttribute("listaTelevisoreAttributeName", MyServiceFactory.getTelevisoreServiceInstance().listaCompleta());
		
		request.getRequestDispatcher("results.jsp").forward(request, response);
	}

}
