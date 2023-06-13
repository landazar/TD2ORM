package com.inti.servlet;

import java.io.IOException;
import java.time.LocalDate;
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
import com.inti.hibernate.TraitementBDD;
import com.inti.model.CB;
import com.inti.model.Paiement;
import com.inti.model.Paypal;
import com.inti.model.Role;
import com.inti.model.Utilisateur;
import com.inti.model.UtilisateurDetails;

/**
 * Servlet implementation class paiementServlet
 */
@WebServlet("/paiement")
public class paiementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LogManager.getLogger();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public paiementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/paiement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TraitementBDD tbdd = new TraitementBDD();
		Paiement p1 = null;
		
		if(request.getParameter("typeP").equals("Paypal"))
		{
			p1 = new Paypal(Double.parseDouble(request.getParameter("montant")), LocalDate.now(), 
					Integer.parseInt(request.getParameter("numPaypal")));
		}
		else if(request.getParameter("typeP").equals("CB"))
		{
			p1 = new CB(Double.parseDouble(request.getParameter("montant")), LocalDate.now(), 
					Long.parseLong(request.getParameter("numeroCB")), LocalDate.parse(request.getParameter("dateE")));
		}
		else
		{
			p1 = new Paiement(Double.parseDouble(request.getParameter("montant")), LocalDate.now());
		}
		
		tbdd.enregistrerPaiement(p1);
		
		
		
		response.sendRedirect("index.jsp");
		
	}

}
