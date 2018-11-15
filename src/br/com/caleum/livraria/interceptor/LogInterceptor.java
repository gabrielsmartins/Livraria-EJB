package br.com.caleum.livraria.interceptor;

import javax.interceptor.*;

public class LogInterceptor {

	@AroundInvoke
	public Object intercepta(InvocationContext context) throws Exception {
		long timeMillis = System.currentTimeMillis();
		
		Object o = context.proceed();
		String metodo = context.getMethod().getName();
		String classe = context.getTarget().getClass().getSimpleName();
		System.out.println(classe + " - " + metodo);
		System.out.println("[INFO] Tempo de execucao: " + (System.currentTimeMillis() - timeMillis));
		return o;
	}
}
