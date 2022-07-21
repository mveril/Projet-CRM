<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <div>
    	<label for="idClient"> Choississez un client : </label>	

   		<select id="clientId" name="clientId">
			<c:forEach items="${ clients }" var="client">
						<option value="<c:out value="${ client.id }"/>"${ client.id == order.client.id ? "selected" : "" }>
						<c:out value="${ client.firstName }" /> <c:out value="${ client.lastName }" />
						</option>
			</c:forEach>
		</select>
		<span class="erreur">${ erreurs['clientId'] }</span> 
	</div> 
				<div>
					<label for="typePresta"> typePresta </label> 
					<input type="text" id="typePresta" name="typePresta" value="${order.typePresta }" />
					<span class="erreur">${ erreurs['typePresta'] }</span>
					 
				</div>
				<div>
					<label for="designation"> designation </label> 
					<input type="text" id="designation" name="designation" value="${ order.designation }" />
					<span class="erreur">${ erreurs['designation'] }</span>
				</div>
				<div>
					<label for="nbDays">nbDays </label> 
					<input type="text" id="nbDays" name="nbDays" value="${ order.nbDays }" />
					<span class="erreur">${ erreurs['nbDays'] }</span>
				</div>
				<div>
					<label for="unitPrice">unitPrice </label>
					<input type="text" id="unitPrice" name="unitPrice" value="${ order.unitPrice }" />
					<span class="erreur">${ erreurs['unitPrice'] }</span>
				</div>
				<div>
					<label for="state">state </label>
					<input type="text" id="state" name="state" value="${ order.state }" />
					<span class="erreur">${ erreurs['state'] }</span>
				</div> 
				
				<p class="erreur">${ resultat }</p>
	
	   