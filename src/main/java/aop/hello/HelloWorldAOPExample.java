package aop.hello;

import org.springframework.aop.framework.ProxyFactory;

public class HelloWorldAOPExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MessageWriter target = new MessageWriter();
		ProxyFactory pf = new ProxyFactory();

		pf.addAdvice(new MessageDecorator());
		pf.setTarget(target);

		MessageWriter proxy = (MessageWriter) pf.getProxy();
		target.writeMessage();
		System.out.println();
		target.writeMessage2();
		System.out.println();
		proxy.writeMessage();
		System.out.println();
		proxy.writeMessage2();

	}

}
