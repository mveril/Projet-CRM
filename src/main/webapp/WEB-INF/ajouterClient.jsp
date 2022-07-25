<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajout d'un client</title>
</head>
<body>
<c:import url="/WEB-INF/menu.jsp" />
	<div class="form">
		<form method="post" action="<c:url value="/ajouterClient"/>">

			<fieldset>
				<legend> Creer un client </legend>
				
				<c:import url="/WEB-INF/ClientFields.jsp" />
					
			</fieldset>

			<input type="submit" value="Valider" /> <input type="reset"
				value="Remettre a zero " />
		</form>
	</div>

</body>
</html>