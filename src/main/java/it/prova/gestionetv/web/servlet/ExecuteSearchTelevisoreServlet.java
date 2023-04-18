package it.prova.gestionetv.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionetv.service.MyServiceFactory;

/**
 * Servlet implementation class ExecuteSearchTelevisoreServlet
 */
@WebServlet("/ExecuteSearchTelevisoreServlet")
public class ExecuteSearchTelevisoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String marcaDaPagina = request.getParameter("marcaInput");
		String modelloDaPagina = request.getParameter("modelloInput");
		if (marcaDaPagina.isBlank() && modelloDaPagina.isBlank()) {
			String messaggioDaInviareAPagina = "Attenzione! E' necessario valorizzare almeno un campo";
			request.setAttribute("messaggioDiErrore", messaggioDaInviareAPagina);
			request.getRequestDispatcher("searchForm.jsp").forward(request, response);
			return;
		}
		request.setAttribute("listaTelevisoreAttributeName",
				MyServiceFactory.getTelevisoreServiceInstance().cercaPerMarcaEModello(marcaDaPagina, modelloDaPagina));
		request.getRequestDispatcher("results.jsp").forward(request, response);
	}

}
