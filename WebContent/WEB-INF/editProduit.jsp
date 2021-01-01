
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
						 <form method="post" action="updateProduit.php">
						
						  <div class="form-group">
						 		<label class="control-label">idProduit</label>
   				  		 		<input type="text"  name="idProduit" value="${produit.idProduit}" class="from-control"/>
   				  			  	<span></span>
   				  			 </div>
						 
						  <div class="form-group">
						 		<label class="control-label">quantiteStock</label>
   				  		 		<input type="text"  name="quantiteStock" value="${produit.quantiteStock}" class="from-control"/>
   				  			  <span></span>
   				  			 </div>
   				  			 
						  <div class="form-group">
						 		<label class="control-label">prixUnitaire</label>
   				  		 		<input type="text" name="prixUnitaire" value="${produit.prixUnitaire}"  class="from-control"/>
   				  			 <span></span>
   				  			 </div>
   				  			 
						  <div class="form-group">
						 		<label class="control-label">nomProduit</label>
   				  		 		<input type="text" name="nomProduit" required="required" value="${produit.nomProduit}" class="from-control"/>
   				  			 <span></span>
   				  			 </div>
   				  			 
   				  			 <div>
   				  			 	<button type=submit class ="btn btn-primary">Save</button>
   				  			 </div>
   				  			 
   				  		 </form> 

   				  
					</div>
			</div>
					
					
	</div>
				
</body>
</html>
