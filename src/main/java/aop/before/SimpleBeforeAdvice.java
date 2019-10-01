package aop.before;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import aop.hello.MessageWriter;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {
	public static void main(String[] args) {
		MessageWriter target = new MessageWriter();

		ProxyFactory pf = new ProxyFactory();

		pf.addAdvice(new SimpleBeforeAdvice());
		pf.setTarget(target);

		MessageWriter proxy = (MessageWriter) pf.getProxy();
		proxy.writeMessage();
		proxy.writeMessage2();
	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("Before method: " + method.getName());

	}
}
