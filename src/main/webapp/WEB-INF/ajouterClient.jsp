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


<c:import url="/WEB-INF/menu.jsp" />



	<div class="form">
		<form method="post" action="<c:url value="/ajouterClient"/>">

			<fieldset>
				<legend> Creer un client </legend>
				
				<br/>
				
				
			    <label for="companyName"> companyName </label> 
				<input type="text" id="companyName" name="companyName" value="${ client.companyName}" />
				<span class="erreur">${ erreurs['companyName'] }</span>
				<br/> 
				

				<label for="firstName"> FirstName </label> 
				<input type="text" id="firstName" name="firstName" value="${ client.firstName }" />
				<span class="erreur">${ erreurs['firstName'] }</span>
				<br/> 
				
		
				 
				 <label for="lastName">LastName </label> 
				 <input type="text" id="lastName" name="lastName" value="${ client.lastName }" />
				 <span class="erreur">${ erreurs['lastName'] }</span>
				<br/>
				
				
				
				
				 <label for="email"> Email </label> 
				 <input type="text" id="email" name="email" value="${ client.email }" />
				 <span class="erreur">${ erreurs['email'] }</span>
				<br/>
				
				<label for="phone"> telephone </label> 
				 <input type="text" id="phone" name="phone" value="${ client.phone }" />
				 <span class="erreur">${ erreurs['telephone'] }</span>
				<br/>
				
				<label for="address"> Adresse </label> 
				 <input type="text" id="address" name="address" value="${ client.adress}" />
				 <span class="erreur">${ erreurs['address'] }</span>
				<br/>
				
				<label for="zipCode"> ZipCode</label> 
				 <input type="text" id="zipCode" name="zipCode" value="${ client.zipCode }" />
				 <span class="erreur">${ erreurs['"zipCode"'] }</span>
				<br/>
				
				
				<label for="city"> City  </label> 
				 <input type="text" id="city" name="city" value="${ client.city }" />
				 <span class="erreur">${ erreurs['"city"'] }</span>
				<br/>
				
				<label for="country"> Country </label> 
				 <input type="text" id="country" name="country"value="${ client.country }" />
				 <span class="erreur">${ erreurs['"country"'] }</span>
				<br/>
				
				<label for="state"> state </label> 
				 <input type="text" id="state" name="state" value="${ client.state }" />
				 <span class="erreur">${ erreurs['"state"'] }</span>
				<br/>
				<p class="erreur">${ resultat }</p>
				
				
				
				
			     
					
			</fieldset>

			<input type="submit" value="Valider" /> <input type="reset"
				value="Remettre � zero " />






		</form>


	</div>

</body>
</html>