package validation;

import java.util.HashMap;
import java.util.Map;

import modele.Client;
import modele.Order;

public class OrderValidator {
	
	
	static Map<String,String> validateOrder(Order order) {
		var map = new HashMap<String,String>();
		var error= OrderValidator.validateTypePresta(order.getTypePresta());
		if(error != null) {
			map.put("typePresta", error);			
		}
		error= OrderValidator.validateDesignation(order.getDesignation());
		if(error != null) {
			map.put("designation", error);			
		}
		error= OrderValidator.validateNbDays(order.getNbDays());
		if(error != null) {
			map.put("nbDays", error);			
		}	
		error= OrderValidator.validateUnitPrice(order.getUnitPrice());
		if(error != null) {
			map.put("unitPrice", error);			
		}
		error= OrderValidator.validateState(order.getState());
		if(error != null) {
			map.put("state", error);			
		}
		return map;
	}

	private static final String VALIDATE_STATE_STRING ="L'état du client doit être un nombre entre %d et %d";
	public static String validateState(long state) {
		var min = 0;
		var max = 2;
		if(state<0 || state > 2)
			return String.format(VALIDATE_STATE_STRING, min,max); 
		else {
			return null;
		}
	}

	public static String validateState(String state) {
		var min = 0;
		var max = 2;
		if(state.matches("0*[0-2]"))
			return String.format(VALIDATE_STATE_STRING, min,max); 
		else {
			return null;
		}
	}

	private static final String VALIDATE_UNIT_PRICE_STRING ="Le prix unitaire doit être un nombre positif";
	public static String validateUnitPrice(float unitPrice) {
		// TODO Auto-generated method stub
		if(unitPrice<0) {
			return VALIDATE_UNIT_PRICE_STRING;
		}
		return null;
	}
	
	public static String validateUnitPrice(String unitPrice) {
		// TODO Auto-generated method stub
		if(unitPrice.matches("\\d+[,\\.]?\\d*")) {
			return VALIDATE_UNIT_PRICE_STRING;
		}
		return null;
	}

	public static String validateNbDays(long nbDays) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static String validateNbDays(String nbDays) {
		// TODO Auto-generated method stub
		if(nbDays != null) {
			if(nbDays.matches("0*[1-9]\\d*")) {
				return "Le nombre de jours doit étre un entier positif";
			}
	  	} else {
	  		return "Veuillez entrer un nombre de jours";  
	  	}
		return null;
	}

	public static String validateDesignation(String designation) {
		// TODO Auto-generated method stub
		if(designation == null) {
			return  "Veuillez entrer une désignation";
		} else {
			var max = 100;
			if(designation.length() > max) {
				return String.format("La désignation doit avoir moins de %d caractères", max);
			}
		}
		return null;
	}

	public static String validateTypePresta(String typePresta) {
		// TODO Auto-generated method stub
		if(typePresta == null) {
			return  "Veuillez entrer un type de prestation";
		} else {
			var max = 100;
			if(typePresta.length() > max) {
				return String.format("Le type de prestation doit avoir moins de %d caractères", max);
			}
		}
		return null;
	}
}
