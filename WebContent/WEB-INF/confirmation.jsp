
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Produits</title>
<link href="./assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">

</head>

<body>
<%@include file="header.jsp" %>
<div class="container col-md-10 col-md-offset-1">
	<div class="panel panel-primary">		
		<div class="panel-heading"> Saisie d'un produit</div>		
	
			<div class="panel-body"> 
				<div class="form-group">
					<label>ID</label>
					<label>${produit.idProduit}</label>
					
				</div>	
				
				<div class="form-group">
					<label>NomProduit:</label>
					<label>${produit.nomProduit}</label>
					
				</div>	    				  	
			
				<div class="form-group">
					<label>Prix:</label>
					<label>${produit.prixUnitaire}</label>
					
				</div>
				
				<div class="form-group">
					<label>Quantite:</label>
					<label>${produit.quantiteStock}</label>
					
				</div>	
				
				
			 </div>
			</div>
					
					
	</div>
				
</body>
</html>
