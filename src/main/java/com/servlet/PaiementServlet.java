package com.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Hibernate.Util.TraitementBDD;
import com.Hibernate.model.CB;
import com.Hibernate.model.Paiement;
import com.Hibernate.model.Paypal;

/**
 * Servlet implementation class PaiementServlet
 */
@WebServlet("/Paiement")
public class PaiementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaiementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		this.getServletContext().getRequestDispatcher("/WEB-INF/payement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		TraitementBDD tbdd = new TraitementBDD();
		Paiement p1 = null;
		
		
		if(request.getParameter("typeP2") != null && request.getParameter("typeP2").equals("Paypal")) {
			p1 = new Paypal(Double.parseDouble(request.getParameter("montant")), LocalDate.now(), Integer.parseInt(request.getParameter("numPaypal")));
		}
		else if(request.getParameter("typeP2") != null && request.getParameter("typeP1").equals("CB")) {
			p1 = new CB(Double.parseDouble(request.getParameter("montant")), 
					LocalDate.parse(request.getParameter("dateE")), 
					Long.parseLong(request.getParameter("numeroCB")), LocalDate.now());
		}
		else {
			p1 = new Paiement(Double.parseDouble(request.getParameter("montant")), LocalDate.now());
		}
		
		tbdd.enregistrerPaiement(p1);
		
		response.sendRedirect("index.jsp");
		
	}

}
