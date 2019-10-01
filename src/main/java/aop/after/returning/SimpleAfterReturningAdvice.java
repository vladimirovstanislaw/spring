package aop.after.returning;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

import aop.hello.MessageWriter;

public class SimpleAfterReturningAdvice implements AfterReturningAdvice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MessageWriter target = new MessageWriter();

		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new SimpleAfterReturningAdvice());
		pf.setTarget(target);

		MessageWriter proxy = (MessageWriter) pf.getProxy();
		proxy.writeMessage();
		proxy.writeMessage2();
	}

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("After method: " + method.getName());

	}

}
