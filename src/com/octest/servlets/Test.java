package com.octest.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import com.octest.beans.Produit;
import com.octest.dao.DaoFactory;
import com.octest.dao.IMetierCatalogue;


@WebServlet("/Test")
public class Test extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IMetierCatalogue metier;
    
  

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.metier = daoFactory.getIMetierCatalogue();
    }
   

protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
		doGet(request, response);
    } 

    public void doGet(HttpServletRequest request, HttpServletResponse response ) 
    		throws ServletException, IOException {
    	String path=request.getServletPath();
    	
    	if(path.equals("/recherche.php")) {
    		String motCle = request.getParameter("motCle");
    		ProduitModele modele = new ProduitModele();
    		modele.setMotCle(motCle);
    		List<Produit> produits = metier.getProduitsParMC("%"+motCle+"%");
    		modele.setProduits(produits);
    		request.setAttribute("modele", modele);	
    		this.getServletContext().getRequestDispatcher("/WEB-INF/recherche.jsp").forward(request, response);
    		
    	} else if(path.equals("/saisie.php")) {
		  this.getServletContext().getRequestDispatcher("/WEB-INF/saisieProduit.jsp").forward(request, response);
    	}else if(path.equals("/saveProduit.php")&&(request.getMethod().equals("POST"))) {
    		String nomProduit = request.getParameter("nomProduit");
        	int quantiteStock = Integer.parseInt(request.getParameter("quantiteStock"));
        	double prixUnitaire =Double.parseDouble(request.getParameter("prixUnitaire"));
        	
        	Produit p= metier.addProduit(new Produit(quantiteStock,prixUnitaire,nomProduit));
        	
        	request.setAttribute("produit", p);
    		this.getServletContext().getRequestDispatcher("/WEB-INF/confirmation.jsp").forward(request, response);
        	}
    	else if(path.equals("/supprimer.php")) {
    		int id = Integer.parseInt(request.getParameter("idProduit"));
    		metier.deleteProduit(id);
    		response.sendRedirect("recherche.php?moCle=");
        	}
    	
    	else if(path.equals("/edit.php")) {
    		int id = Integer.parseInt(request.getParameter("idProduit"));
    		Produit p = metier.getProduit(id);
    		request.setAttribute("produit", p);
    		this.getServletContext().getRequestDispatcher("/WEB-INF/editProduit.jsp").forward(request, response);
        	} 
    	
    	else if(path.equals("/updateProduit.php")&&(request.getMethod().equals("POST"))) {
        	
        	int idProduit = Integer.parseInt(request.getParameter("idProduit"));
    		String nomProduit = request.getParameter("nomProduit");
        	int quantiteStock = Integer.parseInt(request.getParameter("quantiteStock"));
        	double prixUnitaire =Double.parseDouble(request.getParameter("prixUnitaire"));
        	Produit p= new Produit(quantiteStock,prixUnitaire,nomProduit);
        	p.setIdProduit(idProduit);
        	metier.updateProduit(p);
        	request.setAttribute("produit", p);
    		this.getServletContext().getRequestDispatcher("/WEB-INF/editProduit.jsp").forward(request, response);

        	}
    	
    	else {
    		response.sendError(Response.SC_NOT_FOUND);
    	}
    }
    
}




