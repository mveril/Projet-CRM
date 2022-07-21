package validation;

import java.util.HashMap;

public abstract class ValidatorBase {
    protected HashMap<String,String> errors = new HashMap<>();

	public HashMap<String, String> getErrors() {
		return errors;
	}
}
