package injecting.collections;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Runable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-collections.xml");
		ctx.refresh();
		CollectionInjection col = (CollectionInjection) ctx.getBean("injectCollection");
		col.displayInfo();
	}

}
