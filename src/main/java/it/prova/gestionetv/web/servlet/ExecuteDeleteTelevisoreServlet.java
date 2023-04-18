package it.prova.gestionetv.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionetv.service.MyServiceFactory;

/**
 * Servlet implementation class ExecuteDeleteTelevisoreServlet
 */
@WebServlet("/ExecuteDeleteTelevisoreServlet")
public class ExecuteDeleteTelevisoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametroIdTelevisoreDaEliminare = request.getParameter("idDaRimuovere");
		Long idTelevisoreDaRimuovere = Long.parseLong(parametroIdTelevisoreDaEliminare);
		MyServiceFactory.getTelevisoreServiceInstance().elimina(idTelevisoreDaRimuovere);
		request.setAttribute("listaTelevisoreAttributeName",
				MyServiceFactory.getTelevisoreServiceInstance().listaCompleta());
		request.getRequestDispatcher("results.jsp").forward(request, response);

	}

}
