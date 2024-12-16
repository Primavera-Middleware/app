package br.ufrn.imd.primavera.app.interceptors;

import br.ufrn.imd.primavera.app.exceptions.UnauthorizedException;
import br.ufrn.imd.primavera.app.security.Token;
import br.ufrn.imd.primavera.extension.invocationInterceptor.InvocationInterceptor;
import br.ufrn.imd.primavera.extension.invocationInterceptor.annotations.Interceptor;
import br.ufrn.imd.primavera.extension.invocationInterceptor.entities.AbstractInterceptedData;
import br.ufrn.imd.primavera.extension.invocationInterceptor.enums.InvocationType;
import br.ufrn.imd.primavera.remoting.entities.ApiErrorResponseRecord;
import br.ufrn.imd.primavera.remoting.entities.ResponseWrapper;
import br.ufrn.imd.primavera.remoting.enums.HTTPStatus;

@Interceptor(InvocationType.BEFORE_INVOCATION)
public class SecurityInterceptor implements InvocationInterceptor {

	public Token generatedToken = Token.getInstance();

	public final String[] PUBLIC_PATHS = { "uuser/**", "/signup" };

	@Override
	public void intercept(AbstractInterceptedData request) throws UnauthorizedException {
		Boolean isPublic = verifyPath(request.getPath());

		if (isPublic) {
			return;
		}

		Object authObj = request.getHeaders().get("Authorization");

		if (authObj != null && ((String) authObj).equals(generatedToken.getValue())) {
			return;
		}

		ResponseWrapper<ApiErrorResponseRecord> responseError = ResponseWrapper.status(HTTPStatus.UNAUTHORIZED,
				new ApiErrorResponseRecord(HTTPStatus.UNAUTHORIZED.value(), request.getPath(), "Access denied"));

		throw new UnauthorizedException(String.format("The path %s is not public.", request.getPath()), responseError);
	}

	private Boolean verifyPath(String accessPath) {
		String normalizedPath = accessPath != null ? accessPath.trim() : "";

		for (String publicPath : PUBLIC_PATHS) {
			String regex = publicPath.replace("**", ".*").replace("{id}", "\\d+");
			if (normalizedPath.matches(regex)) {
				return true;
			}
		}
		return false;
	}

}
