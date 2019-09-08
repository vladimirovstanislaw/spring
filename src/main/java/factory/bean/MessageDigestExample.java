package factory.bean;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/message-digest-app-context.xml");
		ctx.refresh();
		MessageDigester digester = (MessageDigester) ctx.getBean("digester");
		digester.digest("Hi Kathrine!");
	}

}
