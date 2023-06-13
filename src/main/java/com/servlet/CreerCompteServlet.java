package com.servlet;

import java.io.IOException;

import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;


import com.Hibernate.Util.HibernateUtil;
import com.Hibernate.model.Role;
import com.Hibernate.model.Utilisateur;
import com.Hibernate.model.UtilisateurDetails;

import org.apache.logging.log4j.*;

/**
 * Servlet qui va être appelé par l'url seterminant par : CreerCompte
 * objectif : redirigé la requête http vers une page jsp contenant un formulaire pour
 * saisir les propriétés d'un utilisateur avec les détails.
 * De plus, le rôle minimum client sera affecté par défaut à tous les utilisateurs.
 * 
 * @author ED
 */
@WebServlet("/CreerCompte")
public class CreerCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Logger logger = LogManager.getLogger(CreerCompteServlet.class);
    
    public CreerCompteServlet() {
        super();
        
    }

	/**
	 * Permet de rediriger les objects request et response vers la page creerCompte.jsp
	 * 
	 * @param request : la requête htpp qu'on récupère
	 * @param response : l'object utilisé pour envoyer la réponse au client, au navigateur
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	this.getServletContext().getRequestDispatcher("/WEB-INF/creerCompte.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionfactory().openSession();
    	
    	
    	try {
    		
    		session.beginTransaction();
    		
    		Utilisateur u = new Utilisateur(request.getParameter("login"), request.getParameter("mdp"));
        	UtilisateurDetails ud = new UtilisateurDetails(request.getParameter("adresse"), request.getParameter("ville"), Integer.parseInt(request.getParameter("cp")), Integer.parseInt(request.getParameter("tel")), request.getParameter("email"));
        	
        	u.setUtilisateurDetails(ud);
        	
//        	List<Role> listeRole = List.of(new Role("client"));
        	Role r = session.get(Role.class, 1);
        	List<Role> listeRole = List.of(r);
        	u.setListeRoles(listeRole);
        	
        	
//        	session.save(u);
//        	session.save(ud); //Pas besoin car on a mis la cascade
			
    		
    		session.getTransaction().commit();
    		
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Erreur d'enregistrement d'un utilisateur");
			
			session.getTransaction().rollback();
		}
    	
    	
  	}

}
