package factory.bean.and.method;

import org.springframework.context.support.GenericXmlApplicationContext;

import factory.bean.MessageDigester;

public class MessageDigestFactoryExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/factory-bean-and-method-app-context.xml");
		ctx.refresh();
		MessageDigester digester = (MessageDigester) ctx.getBean("digester");
		digester.digest("Hello World!");
	}

}
