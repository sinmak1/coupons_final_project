package Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotPresetException extends Exception {

	public EntityNotPresetException(String string) {
		super(string);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1225782870824509204L;

	
	
}
