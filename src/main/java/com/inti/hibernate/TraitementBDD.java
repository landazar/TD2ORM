package com.inti.hibernate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.inti.model.Paiement;
import com.inti.model.Utilisateur;

public class TraitementBDD {
	private static final Logger logger = LogManager.getLogger();
	
	private Session session;
	
	public TraitementBDD() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	public List<Utilisateur> getListeUtilisateur()
	{
		List<Utilisateur> listeU = new ArrayList<>();
		
		try {
			session.beginTransaction();
			
			logger.info("début de la transaction pour afficher utilisateur");
			
			listeU = session.createNativeQuery("select * from Utilisateur", Utilisateur.class).list();
			
			session.getTransaction().commit();
			
			} catch (Exception e) {
				session.getTransaction().rollback();
				logger.error("Erreur lors de l'affichage utilisateur");
				e.printStackTrace();
			}
		
		return listeU;
	}
	
	
	public void deleteUtilisateur(int id)
	{
		try {
			session.beginTransaction();
			
			logger.info("début de la transaction pour supprimer un utilisateur");
			
			//on recupère le paramètre dans l'URL et pas celui dans la classe
			Utilisateur u1 = session.load(Utilisateur.class, id);
			
			session.delete(u1);
			
			
			session.getTransaction().commit();
			
			} catch (Exception e) {
				session.getTransaction().rollback();
				logger.error("Erreur lors de la suppression d'un utilisateur");
				e.printStackTrace();
			}
	}
	
	public Utilisateur getUtilisateurById(int id)
	{
		Utilisateur u1 = null;
		try {
			session.beginTransaction();
			
			logger.info("début de la transaction pour modifier un utilisateur");
			
			//on recupère le paramètre dans l'URL et pas celui dans la classe
			u1 = session.load(Utilisateur.class, id);
		
			session.getTransaction().commit();
			
			} catch (Exception e) {
				session.getTransaction().rollback();
				logger.error("Erreur lors de la modification d'un utilisateur");
				e.printStackTrace();
			}
		
		return u1;
	}
	
	public void UpdateUtilisateurById(int id, String login, String mdp, String adresse, String ville, int cp, String tel, String email)
	{
		Utilisateur u1 = null;
		try {
			session.beginTransaction();
			
			logger.info("début de la transaction pour modifier un utilisateur");
			
			//on recupère le paramètre dans l'URL et pas celui dans la classe
			u1 = session.load(Utilisateur.class, id);
			u1.setLogin(login);
			u1.setMdp(mdp);
			u1.getUtilisateurDetails().setAdresse(adresse);
			u1.getUtilisateurDetails().setVille(ville);
			u1.getUtilisateurDetails().setCp(cp);
			u1.getUtilisateurDetails().setTel(tel);
			u1.getUtilisateurDetails().setEmail(email);
			
			session.update(u1);
		
			session.getTransaction().commit();
			
			} catch (Exception e) {
				session.getTransaction().rollback();
				logger.error("Erreur lors de la modification d'un utilisateur");
				e.printStackTrace();
			}
		
		
	}
	
	public void enregistrerPaiement(Paiement p)
	{
		
		try {
			session.beginTransaction();
			
			logger.info("début de la transaction pour insérer un paiement");
			
			
			
			session.save(p);
			
			session.getTransaction().commit();
			
			} catch (Exception e) {
				session.getTransaction().rollback();
				logger.error("Erreur lors de l'enregistrement d'un paiement");
				e.printStackTrace();
			}
	}
	
	
	
	
}
