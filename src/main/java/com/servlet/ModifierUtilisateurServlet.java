package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Hibernate.Util.TraitementBDD;
import com.Hibernate.model.Utilisateur;

/**
 * Servlet implementation class ModifierUtilisateurServlet
 */
@WebServlet("/ModifierUtilisateur")
public class ModifierUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierUtilisateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		TraitementBDD tbdd = new TraitementBDD();
		
		Utilisateur u = tbdd.getUtilisateurById(Integer.parseInt(request.getParameter("id")));
		
		request.setAttribute("utilisateur", u);
    	
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifierUtilisateur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		TraitementBDD tdbb = new TraitementBDD();
		
		tdbb.updateUtilisateur(Integer.parseInt(request.getParameter("id")), 
				request.getParameter("login"), request.getParameter("email"), 
				Long.parseLong(request.getParameter("tel")), request.getParameter("adresse"), 
				request.getParameter("ville"), Integer.parseInt(request.getParameter("cp")), request.getParameter("mdp"));
		
		response.sendRedirect("AfficherUtilisateur");
	}

}
