package br.ufrn.imd.primavera.app.interceptors;

import br.ufrn.imd.primavera.extension.invocationInterceptor.InvocationInterceptor;
import br.ufrn.imd.primavera.extension.invocationInterceptor.annotations.Interceptor;
import br.ufrn.imd.primavera.extension.invocationInterceptor.entities.AbstractInterceptedData;
import br.ufrn.imd.primavera.extension.invocationInterceptor.enums.InvocationType;

@Interceptor(value = InvocationType.AFTER_INVOCATION, priority = 2)
public class TimeAfterInterceptor implements InvocationInterceptor {

	@Override
	public void intercept(AbstractInterceptedData aid) {
		Object startObj = aid.getContext().getData().get("start");
		if (startObj != null) {
			Long start = (Long) startObj;
			Long current = System.currentTimeMillis();
			System.out.printf("Tempo decorrido: %.5f segundos\n", (current - start) / 1000.0);
		}
	}
}
