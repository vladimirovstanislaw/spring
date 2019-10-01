package aop.after.returning;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class WeakKeyCheckAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		if ((target instanceof KeyGenerator) && ("getKey".equals(method.getName()))) {
			long key = ((Long) returnValue).longValue();
			if (key == KeyGenerator.WEAK_KEY) {
				throw new SecurityException("Key Generator generated a weak key. Try again");
			}
		}
	}

}
