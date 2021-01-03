
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Produits</title>
<link href="./assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<%@include file="header.jsp" %>
</head>

<body>
<div class="container col-md-10 col-md-offset-1">
	<div class="panel panel-primary">
					
			<div class="panel-body"> 
				 <form method="get" action="recherche.php">
         			 motCle: <input type="text" name="motCle" value="${modele.motCle}"/>
         			 <button  type="submit" class="btn btn-primary">chercher</button>
   				  </form> 
   				  
<table class="table table-strined">
       <tr>
       		<th> idProduit </th> <th> quantiteStock </th> <th> prixUnitaire </th> <th> nomProduit </th>
       </tr>
    

        <c:forEach items="${ modele.produits}" var ="p">
        	<tr>
           		    <td> ${p.idProduit}   </td>
           		 	<td> ${p.quantiteStock}</td>
                	<td> ${p.prixUnitaire} </td> 
                	<td> ${p.nomProduit} </td>
                	<td> <a onclick="return confirm('Etes-vous sure?')" href="supprimer.php?idProduit=${p.idProduit}">Supprimer</a></td>
                	<td> <a href="edit.php?idProduit=${p.idProduit}">Editer</a></td>
                	
       		 </tr>
       		 
        </c:forEach>
    
 </table>  
 
   				  
			</div>
	</div>
</div>					


   

</body>
</html>
