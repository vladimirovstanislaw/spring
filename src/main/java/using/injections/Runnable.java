package using.injections;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import using.injections.SpEL.InjectSimpleConfig;

public class Runnable {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//		ctx.load("classpath:META-INF/spring/app-context-xml.xml");
//		ctx.refresh();
//		InjectSimpleConfig simple = (InjectSimpleConfig) ctx.getBean("injectSimpleSpel");
//		System.out.println(simple);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("using.injections");

		context.refresh();
		InjectSimple simple = (InjectSimple) context.getBean("injectSimple");
		System.out.println(simple);
		context.close();
	}

}
