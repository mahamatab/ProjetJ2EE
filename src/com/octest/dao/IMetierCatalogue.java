package com.octest.dao;

import java.util.List;

import com.octest.beans.Produit;


public interface IMetierCatalogue {
	public Produit addProduit(Produit p);
	public List<Produit> listProduits();
    public List<Produit> getProduitsParMC(String mc);
    public Produit getProduit(int ref);
    public void updateProduit(Produit p);
    public void deleteProduit(int id);
	//public List<Produit> lister();
	
	
}
