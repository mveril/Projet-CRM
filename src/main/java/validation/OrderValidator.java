package validation;


public class OrderValidator extends ValidatorBase {
	
	

	public void validateStateOrder(String state) {
		var min = 0;
		var max = 2;
		if(!state.matches("^0*[0-2]$"))
			errors.put("state", String.format("L'état de la commande doit être un nombre compris entre %d et %d", min,max)); 
	}

	
	public void validateUnitPrice(String unitPrice) {
		if(unitPrice.isEmpty())
		{
			errors.put("unitPrice", "Veuillez entrer un prix");
		}
		else if(!unitPrice.matches("^\\d+[,\\.]?\\d*$")) {
			 errors.put("unitPrice", "Le prix unitaire doit être positif");
		}
		
	}

	
	public void validateNbDays(String nbDays) {
		if(nbDays.isEmpty()) {
	  		errors.put("nbDays", "Veuillez entrer un nombre de jours");  
		} else if (!nbDays.matches("^0*[1-9]\\d*$")) {
			errors.put("nbDays", "Le nombre de jours doit être positif");
		}
		
	}

	public void validateDesignation(String designation) {
		if(designation.isEmpty()) {
			errors.put("designation","Veuillez entrer une désignation");
		} else {
			var max = 100;
			if(designation.length() > max) {
				errors.put("designation", String.format("La désignation ne doit pas dépasser %d caractères", max));
			}
		}
		
	}

	public void validateTypePresta(String typePresta) {
		if(typePresta.isEmpty()) {
			errors.put("typePresta","Veuillez entrer un type de prestation");
		} else {
			var max = 100;
			if(typePresta.length() > max) {
				errors.put("typePresta", String.format("Le type de prestation ne doit pas dépasser %d caractères", max));
			}
		}
	}
}
