<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<div class="form">
	
		<form method="post" action="<c:url value="/modifierClient"><c:param name="id" value="${client.id}"/></c:url>">
			<fieldset>
				<legend> Modifier un client </legend>				
				<br/>
				
			    <label for="companyName"> Nom de la compagnie </label> 
				<input type="text" id="companyName" name="companyName" value="${client.companyName}" />
				<br/> 
				

				<label for="firstName"> Prenom </label> 
				<input type="text" id="firstName" name="firstName" value="${ client.firstName }" />
				<br/> 
				 
				 <label for="lastName">Nom </label> 
				 <input type="text" id="lastName" name="lastName" value="${ client.lastName }" />
				<br/>
				
				 <label for="email"> Email </label> 
				 <input type="text" id="email" name="email" value="${ client.email }" />
				<br/>
				
				<label for="phone"> Telephone </label> 
				 <input type="text" id="phone" name="phone" value="${ client.phone }" />
				<br/>
				
				<label for="address"> Adresse </label> 
				 <input type="text" id="address" name="address" value="${ client.address}" />
				<br/>
				
				<label for="zipCode"> Code Postal</label> 
				 <input type="text" id="zipCode" name="zipCode" value="${ client.zipCode }" />
				<br/>
				
				
				<label for="city"> Ville  </label> 
				 <input type="text" id="city" name="city" value="${ client.city }" />
				<br/>
				
				<label for="country"> Pays </label> 
				 <input type="text" id="country" name="country"value="${ client.country }" />
				<br/>
				
				<label for="state"> Etat </label> 
				 <input type="text" id="state" name="state" value="${ client.state }" />
				<br/>
				
				
				
				
				
			</fieldset>

			<input type="submit" value="Valider" /> <input type="reset"
				value="Remettre à zero " />






		</form>


	</div>

</body>
</html>