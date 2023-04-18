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
 * Servlet implementation class ExecuteInsertTelevisoreServlet
 */
@WebServlet("/ExecuteInsertTelevisoreServlet")
public class ExecuteInsertTelevisoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Binding
		String marcaDaPagina = request.getParameter("marcaNuovoInput");
		String modelloDaPagina = request.getParameter("modelloNuovoInput");
		String prezzoDaPagina = request.getParameter("prezzoNuovoInput");
		Double prezzoInDouble = UtilityForm.doubleParseFromString(prezzoDaPagina);
		String numeroPolliciDaPagina = request.getParameter("numeroPolliciNuovoInput");
		Integer numeroPolliciInInt = UtilityForm.integerParseFromString(numeroPolliciDaPagina);
		String codiceDaPagina = request.getParameter("codiceNuovoInput");
		Televisore nuovoTelevisore = new Televisore(marcaDaPagina, modelloDaPagina, prezzoInDouble, numeroPolliciInInt,
				codiceDaPagina);

		// validazione
		if (marcaDaPagina.isBlank() || modelloDaPagina.isBlank() || prezzoDaPagina.isBlank() || prezzoInDouble == null
				|| numeroPolliciDaPagina.isBlank() || numeroPolliciInInt == null || codiceDaPagina.isBlank()) {
			String messaggioDaInviareAPagina = "Attenzione! E' necessario valorizzare TUTTI i campi in maniera corretta.";
			request.setAttribute("messaggioDiErrore", messaggioDaInviareAPagina);
			request.getRequestDispatcher("insert.jsp").forward(request, response);
			return;
		}
		
		//business
		MyServiceFactory.getTelevisoreServiceInstance().inserisciNuovo(nuovoTelevisore);
		request.setAttribute("listaTelevisoreAttributeName", MyServiceFactory.getTelevisoreServiceInstance().listaCompleta());
		request.getRequestDispatcher("results.jsp").forward(request, response);
	}

}
