package validation;


public class ClientValidator extends ValidatorBase {
	public void validateCompanyName(String companyName) {
		if(companyName.isEmpty()) {
			errors.put("companyName", "Vous devez rentrer le nom de la compagnie");
		} else {
			var max = 100;
			if(companyName.length() > max) {
				errors.put("companyName", String.format("Le nom de la compagnie ne doit pas dépasser %d caractères!",max)); 
			}
		}
	}
	public void validateFirstName(String firstName) {
		if(firstName.isEmpty()) {
		   errors.put("firstName","Vous devez rentrer un prénom");
		} else {
			var max = 100;
			if(firstName.length() > max) {
				errors.put("firstName", String.format("Le prénom ne doit pas dépasser %d caractères!",max)); 
			}
		}
	}
	
	public void validateLastName(String lastName) {
		if(lastName.isEmpty()) {
			errors.put("lastName", "Vous devez entrer un nom de famille");
		} else {
			var max = 100;
			if(lastName.length() > max) {
				errors.put("lastName", String.format("Le nom de famille ne doit pas dépasser %d caractères!",max)); 
			}
		}
	}
	
	public void validateEmail(String email) {
		if(email.isEmpty()) {
			errors.put("email", "Vous devez rentrer un email");
		} else {
			var max = 100;
			if(email.length() > max) {
				errors.put("email", String.format("L'email ne doit pas dépasser %d caractères!",max)); 
			}
			else if(!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
				errors.put("email", "L'email n'est pas valide");
			}
		}
	}
	
	public void validateZipCode(String zipCode) {
		if(!zipCode.matches("^\\d{5}$")){
			errors.put("zipCode","Le code postal doit contenir 5 chiffres.");
		}
	}
	
	public void validatePhone(String phone) {
		if(phone.isEmpty()) {
			errors.put("phone", "Vous devez rentrer un numéro de téléphone");
		}
		else if(!phone.matches("^\\d{1,15}$")){
		    errors.put("phone", "Le numéro de téléphone ne doit pas dépasser 15 chiffres!");
		}
	}
	
	public void validateAddress(String address) {
		if(address.isEmpty()) {
			errors.put("address","Vous devez rentrer une adresse");
		} else {
			var max = 150;
			if(address.length() > max) {
				errors.put("address", String.format("L'adresse ne doit pas dépasser %d caractères!",max));
			}
		}
	}
	public void validateCity(String city) {
		if(city.isEmpty()) {
		   errors.put("city", "Vous devez rentrer une ville");
		} else {
			var max = 15;
			if(city.length() > max) {
				errors.put("city", String.format("Le nom de la ville ne doit pas dépasser %d caractères!",max)); 
			}
		}
	}
	
	public void validateCountry(String country) {
		if(country.isEmpty()) {
			errors.put("country","Vous devez rentrer un pays");
		} else {
			var max = 15;
			if(country.length() > max) {
				errors.put("country", String.format("Le nom du pays doit pas dépasser %d caractères !",max)); 
			}
		}
	}
	
	public void validateState(String state) {
		var min = 0;
		var max = 1;
		if(!state.matches(String.format("^[%d-%d]$",min,max))) {
			errors.put("state", String.format("L'état du client doit être de %d ou %d", min, max));
		}
	}
}
