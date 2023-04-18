package it.prova.gestionetv.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionetv.service.MyServiceFactory;

/**
 * Servlet implementation class PrepareDeleteTelevisoreServlet
 */
@WebServlet("/PrepareDeleteTelevisoreServlet")
public class PrepareDeleteTelevisoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// binding id
		String parametroIdTelevisoreDaEliminare = request.getParameter("idDaInviareComeParametro");
		Long idTelevisore = Long.parseLong(parametroIdTelevisoreDaEliminare);

		request.setAttribute("televisoreDaInviareARimuovi", MyServiceFactory.getTelevisoreServiceInstance().caricaSingolo(idTelevisore));
		request.getRequestDispatcher("delete.jsp").forward(request, response);
	}


}
