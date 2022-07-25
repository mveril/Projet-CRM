<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
				
			<div>
			    <label for="companyName"> Nom de la compagnie </label> 
				<input type="text" id="companyName" name="companyName" value="${ client.companyName}" />
				<span class="erreur">${ erreurs['companyName'] }</span>
            </div>
            <div>
				<label for="firstName"> Prénom </label> 
				<input type="text" id="firstName" name="firstName" value="${ client.firstName }" />
				<span class="erreur">${ erreurs['firstName'] }</span> 
			</div>
			<div>			 
				 <label for="lastName">Nom </label> 
				 <input type="text" id="lastName" name="lastName" value="${ client.lastName }" />
				 <span class="erreur">${ erreurs['lastName'] }</span>
            </div>
			<div>	
				 <label for="email"> Email </label> 
				 <input type="text" id="email" name="email" value="${ client.email }" />
				 <span class="erreur">${ erreurs['email'] }</span>
             </div>
			<div>
				<label for="phone"> Telephone </label> 
				 <input type="text" id="phone" name="phone" value="${ client.phone }" />
				 <span class="erreur">${ erreurs['phone'] }</span>
			</div>
			<div>
				<label for="address"> Adresse </label> 
				 <input type="text" id="address" name="address" value="${ client.address}" />
				 <span class="erreur">${ erreurs['address'] }</span>
            </div>
			<div>
				<label for="zipCode"> Code postal</label> 
				 <input type="text" id="zipCode" name="zipCode" value="${ client.zipCode }" />
				 <span class="erreur">${ erreurs['zipCode'] }</span>
			</div>
			<div>
				<label for="city"> Ville </label> 
				 <input type="text" id="city" name="city" value="${ client.city }" />
				 <span class="erreur">${ erreurs['city'] }</span>
			</div>
			<div>
				<label for="country"> Pays </label> 
				 <input type="text" id="country" name="country" value="${ client.country }" />
				 <span class="erreur">${ erreurs['country'] }</span>
            </div>
			<div>	
				<label for="state"> Etat </label> 
				 <input type="text" id="state" name="state" value="${ client.state }" />
				 <span class="erreur">${ erreurs['state'] }</span>
            </div>
				<p class="erreur">${ resultat }</p>