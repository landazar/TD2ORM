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
import org.hibernate.query.NativeQuery;

import com.inti.hibernate.HibernateUtil;
import com.inti.hibernate.TraitementBDD;
import com.inti.model.Utilisateur;

/**
 * Servlet implementation class modifierUtilisateurServlet
 */
@WebServlet("/modifierUtilisateur")
public class modifierUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LogManager.getLogger(CreerCompteServlet.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifierUtilisateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TraitementBDD tbdd = new TraitementBDD();
		Utilisateur u1 = tbdd.getUtilisateurById(Integer.parseInt(request.getParameter("id")));
		
		request.setAttribute("utilisateur", u1);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifierUtilisateur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TraitementBDD tbdd = new TraitementBDD();
		tbdd.UpdateUtilisateurById(Integer.parseInt(request.getParameter("id")), request.getParameter("login"),
									request.getParameter("mdp"), request.getParameter("adresse"), 
									request.getParameter("ville"), Integer.parseInt(request.getParameter("cp")),
									request.getParameter("telephone"), request.getParameter("email"));
		
		response.sendRedirect("afficherUtilisateur");
	}

}
