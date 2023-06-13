package com.Hibernate.Util;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.*;
import org.hibernate.Session;

import com.Hibernate.model.Paiement;
import com.Hibernate.model.Utilisateur;
import com.servlet.CreerCompteServlet;

public class TraitementBDD {
	
	private Session session;
	
	private Logger logger = LogManager.getLogger();

	
	
	public TraitementBDD() {
		session = HibernateUtil.getSessionfactory().openSession();
	}
	
	
	public List<Utilisateur> getlisteUtilisateur() {
		
		List<Utilisateur> listeU = new ArrayList<>();
		
		try {
    		
    		session.beginTransaction();
    		
    		listeU = session.createNativeQuery("select * from utilisateur", Utilisateur.class).list();
    		
    		logger.debug("Récupération de la liste des utilisateurs");
    		
    		session.getTransaction().commit();
    		
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Erreur d'enregistrement d'un utilisateur");
			
			session.getTransaction().rollback();
		}
		
		return listeU;
	}
	
	
	public void deleteUtilisateur(int id) {
		
		try {
    		
    		session.beginTransaction();
    		
    		Utilisateur u = session.load(Utilisateur.class, id);
    		
    		session.delete(u);
    		
    		logger.debug("Suppresion de l'utilisateur : " + u);
    		
    		session.getTransaction().commit();
    		
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Erreur de suppression d'un utilisateur");
			
			session.getTransaction().rollback();
		}
		
	}
	
	
	public Utilisateur getUtilisateurById(int id) {
		 Utilisateur u = null;
		 
		 try {
			 
			 session.beginTransaction();
			 
			 u = session.load(Utilisateur.class, id);
			 
			 session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			logger.debug("Erreur de récupération de l'utilisateur avec l'id : " +id);
		}
		 
		return u;
	}
	
	public void updateUtilisateur(int id, String login, String email, long tel, String adresse, String ville, int cp, String password) {
		 
		 try {
			 
			 session.beginTransaction();
			 
			 Utilisateur u = session.load(Utilisateur.class, id);
			 u.setLogin(login);
			 u.getUtilisateurDetails().setEmail(email);
			 u.getUtilisateurDetails().setTel(tel);
			 u.getUtilisateurDetails().setAdresse(adresse);
			 u.getUtilisateurDetails().setVille(ville);
			 u.getUtilisateurDetails().setCp(cp);
			 u.setMdp(password);
			 
			 logger.debug("Modification de l'utilisateur : " + u);
			 
			 session.update(u);
			 
			 session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			logger.debug("Erreur de récupération de l'utilisateur avec l'id : " +id);
		}
		
	}
	
	
	public void enregistrerPaiement(Paiement p) {
		 
		 
		 try {
			 
			 session.beginTransaction();
			 
			 session.save(p);
			 
			 logger.debug("Enregistrement d'un paiement : " + p);
			 session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			logger.debug("Erreur d'enregistrement paiement : " + p);
		}
		 
	}
	

}
