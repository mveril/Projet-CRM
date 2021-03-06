package validation;

import java.util.HashMap;
import java.util.Map;

import modele.Client;

public class ClientValidator {
	static String validateCompanyName(String companyName) {
		if(companyName == null) {
			return "Vous devez rentrer le nom de la compagnie";
		} else {
			var max = 100;
			if(companyName.length() > max) {
				return String.format("Le nom de la companie doit avoir une taille inférieur à %d !",max); 
			}
			else {
				return null;
			}
		}
	}
	static String validateFirstName(String firstName) {
		if(firstName == null) {
			return "Vous devez rentrer un prénom";
		} else {
			var max = 100;
			if(firstName.length() > max) {
				return String.format("Le prénom doit être de %d !",max); 
			}
			else {
				return null;
			}
		}
	}
	
	static String validateLastName(String lastName) {
		if(lastName == null) {
			return "Vous devez rentrer un nom de famille";
		} else {
			var max = 100;
			if(lastName.length() > max) {
				return String.format("Le nom de famille doit être de %d !",max); 
			}
			else {
				return null;
			}
		}
	}
	
	static String validateEmail(String email) {
		if(email == null) {
			return "Vous devez rentrer un email";
		} else {
			var max = 100;
			if(email.length() > max) {
				return String.format("La taille maximale de l'email doit être de %d",max); 
			}
			else {
				if(email.matches("([^.@]+)(\\\\.[^.@]+)*@([^.@]+\\\\.)+([^.@]+)")) {
					return null;
				} else {
					return "L'email n'est pas valide";
				}
			}
		}
	}
	
	static String validateZipCode(String zipCode) {
		if(zipCode.matches("\\d{5}")){
			return null;
		} else {
			return "Le code postale est non valide";
		}
	}
	
	static String validatePhone(String phone) {
		if(phone != null) {
			if(phone.matches("\\d{,15}")){
				return null;
			} else {
				return "Le numéro de téléphone doit être une série de maximum 15 chiffres";
			}
		} else {
			return "Vous devez rentrer un numéro de téléphone";
		}
	}
	
	static String validateAdress(String address) {
		if(address != null) {
			return null;
		} else {
			return "Vous devez rentrer une adresse";
		}
	}
	static String validateCity(String city) {
		if(city == null) {
			return "Vous devez rentrer une ville";
		} else {
			var max = 15;
			if(city.length() > max) {
				return String.format("Le nom de la ville doit avoir une taille inférieur à %d !",max); 
			}
			else {
				return null;
			}
		}
	}
	
	static String validateCountry(String city) {
		if(city == null) {
			return "Vous devez rentrer un pays";
		} else {
			var max = 15;
			if(city.length() > max) {
				return String.format("Le nom du pays doit avoir une taille inférieur à %d !",max); 
			}
			else {
				return null;
			}
		}
	}
	
	static String validateState(long state) {
		var min = 0;
		var max = 3;
		if(min > state || max < state) {
			return String.format("L'état du client doit être entre %d est %d", min, max);
		}
		else {
			return null;
		}
	}
	
	static String validateState(String state) {
		var min = 0;
		var max = 3;
		if(state != null) {
			if(state.matches(String.format("[%d-%d]",min,max))) {
				return String.format("L'état du client doit être entre %d est %d", min, max);
			}
			else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	static Map<String,String> validateClient(Client client) {
		var map = new HashMap<String,String>();
		var error= ClientValidator.validateCompanyName(client.getCompanyName());
		if(error != null) {
			map.put("companyName", error);			
		}
		error= ClientValidator.validateFirstName(client.getFirstName());
		if(error != null) {
			map.put("firstName", error);			
		}
		error= ClientValidator.validateLastName(client.getLastName());
		if(error != null) {
			map.put("lastName", error);			
		}	
		error= ClientValidator.validateEmail(client.getEmail());
		if(error != null) {
			map.put("email", error);			
		}
		error= ClientValidator.validatePhone(client.getPhone());
		if(error != null) {
			map.put("phone", error);			
		}
		error= ClientValidator.validateAdress(client.getAddress());
		if(error != null) {
			map.put("adress", error);			
		}
		error= ClientValidator.validateZipCode(client.getZipCode());
		if(error != null) {
			map.put("zipCode", error);			
		}
		error= ClientValidator.validateCity(client.getCity());
		if(error != null) {
			map.put("city", error);			
		}
		error= ClientValidator.validateCountry(client.getCountry());
		if(error != null) {
			map.put("country", error);			
		}
		error= ClientValidator.validateState(client.getState());
		if(error != null) {
			map.put("state", error);			
		}
		return map;
	}
}
