package it.prova.gestionetv.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionetv.service.MyServiceFactory;

/**
 * Servlet implementation class ExecuteShowTelevisoreServlet
 */
@WebServlet("/ExecuteShowTelevisoreServlet")
public class ExecuteShowTelevisoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//binding dell'Id
		String parametroIdTelevisoreDaVisualizzare = request.getParameter("idDaInviareComeParametro");
		Long idTelevisore = Long.parseLong(parametroIdTelevisoreDaVisualizzare);
		
		request.setAttribute("televisoreDaInviareAPaginaDettalio", MyServiceFactory.getTelevisoreServiceInstance().caricaSingolo(idTelevisore));
		request.getRequestDispatcher("dettaglio.jsp").forward(request, response);
	}


}
