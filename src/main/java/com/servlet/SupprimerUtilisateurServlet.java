package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.Hibernate.Util.HibernateUtil;
import com.Hibernate.Util.TraitementBDD;
import com.Hibernate.model.Utilisateur;

/**
 * Servlet implementation class SupprimerUtilisateurServlet
 */
@WebServlet("/SupprimerUtilisateur")
public class SupprimerUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = LogManager.getLogger(CreerCompteServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerUtilisateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		TraitementBDD tbdd = new TraitementBDD();
		
		tbdd.deleteUtilisateur(Integer.parseInt(request.getParameter("id")));
		
		response.sendRedirect("AfficherUtilisateur");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
