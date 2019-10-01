package environment;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Runable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/enviroment-app-context.xml");
		ctx.refresh();

		AppProperty appProperty = ctx.getBean("appProperty", AppProperty.class);

		System.out.println("application.home: " + appProperty.getApplicationHome());
		System.out.println("user.home: " + appProperty.getUserHome());
	}

}
