package bean.inheritance;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-bean-inheritance.xml");
		ctx.refresh();

		SimpleBean parent = (SimpleBean) ctx.getBean("inheritParent");
		SimpleBean child = (SimpleBean) ctx.getBean("inheritChild");

		System.out.println("Parent:\n" + parent);
		System.out.println("Child:\n" + child);

	}

}
