package aop.pointcut;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SimpleAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println(">>Invoking " + invocation.getMethod().getName());
		Object retVal = invocation.proceed();
		System.out.println(">>Done");
		return null;
	}

}
