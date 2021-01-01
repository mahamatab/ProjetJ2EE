package com.octest.servlets;

import java.util.ArrayList;
import java.util.List;

import com.octest.beans.Produit;



public class ProduitModele {
	private String motCle;
	private List <Produit> produits = new ArrayList<>();
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	

}
