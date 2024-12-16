package br.ufrn.imd.primavera.app.exceptions;

import br.ufrn.imd.primavera.exceptions.InterceptionException;
import br.ufrn.imd.primavera.remoting.entities.ApiErrorResponseRecord;
import br.ufrn.imd.primavera.remoting.entities.ResponseWrapper;

public class UnauthorizedException extends InterceptionException {
	private static final long serialVersionUID = -495149082648365290L;

	public UnauthorizedException(String message, ResponseWrapper<ApiErrorResponseRecord> response) {
		super(message, response);
	}
}
