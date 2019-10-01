package ch4.conf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import interfaces.MessageRenderer;

public class Runable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		MessageRenderer renderer = ctx.getBean("messageRenderer", MessageRenderer.class);
		renderer.render();

	}

}
