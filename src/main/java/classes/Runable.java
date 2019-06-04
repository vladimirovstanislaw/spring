package classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import interfaces.MessageProvider;

public class Runable {
	@Autowired
    private static ApplicationContext ctxs;
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context-constructor.xml");
		ctx.refresh();
		MessageProvider messageProvider = ctx.getBean("messageProvider", MessageProvider.class);
		System.out.println(messageProvider.getMessage());
		
		
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		context.scan("classes");
//		
//		context.refresh();
//		
//		StandardOutMessageRenderer ss=(StandardOutMessageRenderer)context.getBean("configurableMssageProvider");
//		ss.render();

	}
}
