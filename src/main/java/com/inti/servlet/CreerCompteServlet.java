package com.inti.servlet;

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

import com.inti.hibernate.HibernateUtil;
import com.inti.model.Role;
import com.inti.model.Utilisateur;
import com.inti.model.UtilisateurDetails;

/**
 * Servlet qui va être appelé par URL se terminant par : creerCompte
 * Objectif : redirigé la requête HTPP vers une page JSP contenant un formulaire pour saisir les propriétés
 * d'un utilisateur avec les détails et, de plus, le role minimim client sera affecté par défaut à tous
 * les nouveaux Utilisateurs
 * @author IN-ST-020
 *
 */
@WebServlet("/creerCompte")
public class CreerCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LogManager.getLogger();

    public CreerCompteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Permet de rediriger les objets request et response vers la page creerCompte.jsp
	 * 
	 * @param request : requete HTPP qu'on recupère
	 * @param response : objet utiliser pour envoyer la reponse au navigateur
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		this.getServletContext().getRequestDispatcher("/WEB-INF/creerCompte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
		session.beginTransaction();
		
		logger.info("début de la transaction pour insérer un utilisateur");
		
		String login = request.getParameter("login");
		String mdp = request.getParameter("mdp");
		Utilisateur u = new Utilisateur(login, mdp);
		
		String adresse = request.getParameter("adresse");
		String ville = request.getParameter("ville");
		int cp = Integer.parseInt(request.getParameter("cp"));
		String tel = request.getParameter("telephone");
		String email = request.getParameter("email");
		UtilisateurDetails ud = new UtilisateurDetails(adresse, ville, cp, tel, email);
		
		u.setUtilisateurDetails(ud);
		
//		List<Role> listeRole = List.of(new Role("Client"));
		Role r1 = session.get(Role.class, 1);
		List<Role> listeRole = List.of(r1);
		
		u.setListeRole(listeRole);
		
		session.save(u);
		
		session.getTransaction().commit();
		
		} catch (Exception e) {
			session.getTransaction().rollback();
			logger.error("Erreur lors de l'enregistrement d'un utilisateur");
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/creerCompte.jsp").forward(request, response);
		
	}

}
