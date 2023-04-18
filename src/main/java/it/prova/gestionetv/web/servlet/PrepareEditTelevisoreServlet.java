package it.prova.gestionetv.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionetv.service.MyServiceFactory;

/**
 * Servlet implementation class PrepareEditTelevisoreServlet
 */
@WebServlet("/PrepareEditTelevisoreServlet")
public class PrepareEditTelevisoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametroIdTelevisoreDaModificare = request.getParameter("idDaInviareComeParametro");
		Long idTelevisoreDaModificare = Long.parseLong(parametroIdTelevisoreDaModificare);
		request.setAttribute("televisoreDaInviareAPaginaModifica", MyServiceFactory.getTelevisoreServiceInstance().caricaSingolo(idTelevisoreDaModificare));
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}

}
