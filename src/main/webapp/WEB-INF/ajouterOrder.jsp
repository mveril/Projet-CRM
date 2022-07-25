<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajout d'une commande</title>
</head>
<body >
<c:import url="/WEB-INF/menu.jsp" />
<div class="form">
		<form method="post" action="<c:url value="/ajouterOrder"/>">	
		<fieldset>
			<legend> Créer une commande</legend>
			
				<c:import url="/WEB-INF/OrderFields.jsp" />
				
				
		</fieldset>

			<input type="submit" value="Valider" /> 
			<input type="reset" value="Remettre a zero " />

		</form>
	</div>
</body>
</html>