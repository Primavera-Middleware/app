package br.ufrn.imd.primavera.app.interceptors;

import br.ufrn.imd.primavera.extension.invocationInterceptor.InvocationInterceptor;
import br.ufrn.imd.primavera.extension.invocationInterceptor.annotations.Interceptor;
import br.ufrn.imd.primavera.extension.invocationInterceptor.entities.AbstractInterceptedData;
import br.ufrn.imd.primavera.extension.invocationInterceptor.enums.InvocationType;

@Interceptor(value = InvocationType.BEFORE_INVOCATION, priority = 1)
public class TimeBeforeInterceptor implements InvocationInterceptor {

	@Override
	public void intercept(AbstractInterceptedData aid) {
		aid.getContext().getData().put("start", (Long) System.currentTimeMillis());
	}
}
