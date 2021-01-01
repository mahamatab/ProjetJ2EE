package com.octest.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.octest.beans.Produit;



public class MetierImpl implements IMetierCatalogue {
	
	private DaoFactory daoFactory;

	MetierImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
	
	public MetierImpl() {
		
	}
	
	@Override
	public List<Produit> getProduitsParMC(String mc){
		
			List <Produit> produits =new ArrayList<Produit>();
	        Connection connexion = null;
	        PreparedStatement preparedStatement = null;
		
		try {
			

			 connexion = daoFactory.getConnection();  
	         preparedStatement = connexion.prepareStatement("SELECT * FROM Produit WHERE nomProduit LIKE ?;");
	         preparedStatement.setString(1,mc);
	     	 ResultSet rs =preparedStatement.executeQuery();
			while(rs.next()) {
				Produit p=new Produit();
				p.setIdProduit(rs.getInt("idProduit"));
				p.setQuantiteStock(rs.getDouble("quantiteStock"));
				p.setPrixUnitaire(rs.getDouble("prixUnitaire"));
				p.setNomProduit(rs.getString("nomProduit"));
	            produits.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produits;
	}
	
	

	 @Override
	    public Produit addProduit(Produit p) {
	        Connection connexion = null;
	        PreparedStatement preparedStatement = null;
	        PreparedStatement preparedStatement2 = null;


	        try {
	            connexion = daoFactory.getConnection();
	            preparedStatement = connexion.prepareStatement("INSERT INTO Produit (quantiteStock,prixUnitaire,nomProduit) VALUES(?,?,?);");
	            preparedStatement.setDouble(1, p.getQuantiteStock());
	            preparedStatement.setDouble(2, p.getPrixUnitaire());
	            preparedStatement.setString(3, p.getNomProduit());
	        
	            preparedStatement.executeUpdate();
	            
	            preparedStatement2 = connexion.prepareStatement("SELECT MAX(idProduit) AS MAX_idProduit FROM Produit;");
	            ResultSet rs= preparedStatement2.executeQuery();
	            if(rs.next()) {
	            	p.setIdProduit(rs.getInt("MAX_idProduit"));
	            }
	            preparedStatement.close();
	            
	        } catch (SQLException e) {
	        	
	            e.printStackTrace();
	        } 
	        return p;
	    } 
	 
	 
	 
	 
	 

	@Override
	public Produit getProduit(int ref) {
		Produit p=null;
		Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement  = connexion.prepareStatement("SELECT * FROM  Produit WHERE idProduit LIKE ?;");
            preparedStatement.setInt(1, ref);
            ResultSet rs= preparedStatement.executeQuery();
            
            if(rs.next()) {
            	p=new Produit();
				p.setIdProduit(rs.getInt("idProduit"));
				p.setQuantiteStock(rs.getDouble("quantiteStock"));
				p.setPrixUnitaire(rs.getDouble("prixUnitaire"));
				p.setNomProduit(rs.getString("nomProduit"));
            }
            preparedStatement.close();
            
        } catch (SQLException e) {
        	
            e.printStackTrace();
        } 
        
        if(p==null) throw new RuntimeException("Produit introuvable");

		return p;
	}
	
	
	@Override
	public void deleteProduit(int ref) {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement  = connexion.prepareStatement("DELETE FROM Produit WHERE idProduit = ?;");
        
            preparedStatement.setInt(1, ref);
            preparedStatement.executeUpdate();

            preparedStatement.close();
           
            
        } catch (SQLException e) {
        	
            e.printStackTrace();
        } 
		
	}

	
	
	
	
	
	
	
	
	@Override
	public void updateProduit(Produit p) {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            connexion = daoFactory.getConnection();
           
            preparedStatement  = connexion.prepareStatement("UPDATE Produit SET quantiteStock =?, prixUnitaire=?, nomProduit=? WHERE idProduit =?");
           
           
            
            preparedStatement.setDouble(1, p.getQuantiteStock());
            preparedStatement.setDouble(2, p.getPrixUnitaire());
            preparedStatement.setString(3, p.getNomProduit());
            preparedStatement.setInt(4, p.getIdProduit());
          
         
            preparedStatement.executeUpdate();
            preparedStatement.close();
           
            
        } catch (SQLException e) {
        	
            e.printStackTrace();
        } 
		
	}

	@Override
	public List<Produit> listProduits() {
		// TODO Auto-generated method stub
		return null;
	}



	
	/*
	 @Override
	    public List<Produit> lister() {
		 
		 
		 List <Produit> prods =new ArrayList<Produit>();
	        Connection connexion = null;
	        PreparedStatement preparedStatement = null;
		
		try {
			  
			 connexion = daoFactory.getConnection();  
	         preparedStatement = connexion.prepareStatement("SELECT * FROM Produit;");
	     	 ResultSet rs =preparedStatement.executeQuery();

	            while (rs.next()) {
	            	Produit p=new Produit();
					p.setIdProduit(rs.getInt("idProduit"));
					p.setQuantiteStock(rs.getDouble("quantiteStock"));
					p.setPrixUnitaire(rs.getDouble("prixUnitaire"));
					p.setNomProduit(rs.getString("nomProduit"));
		            prods.add(p);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return prods;
	    }
*/


	
	
	
}