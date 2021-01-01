package com.octest.beans;

import java.io.Serializable;

public class Produit implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idProduit;
	private double quantiteStock;
	private double prixUnitaire;
	private String nomProduit;

	
	public double getQuantiteStock() {
		return quantiteStock;
	}
	public void setQuantiteStock(double quantiteStock) {
		this.quantiteStock = quantiteStock;
	}
	public Produit(double quantiteStock, double prixUnitaire, String nomProduit) {
		super();
		this.quantiteStock = quantiteStock;
		this.prixUnitaire = prixUnitaire;
		this.nomProduit = nomProduit;
	}
	
	
	
	public Produit() {
		super();
		
	}
	public double getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	
}


