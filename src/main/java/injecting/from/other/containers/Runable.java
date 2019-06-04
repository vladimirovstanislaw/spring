package injecting.from.other.containers;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Runable {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctxChild = new GenericXmlApplicationContext();

		GenericXmlApplicationContext ctxParent = new GenericXmlApplicationContext();

		ctxParent.load("classpath:META-INF/spring/app-context-injecting-same.xml");
		ctxParent.refresh();
		ctxChild.load("classpath:META-INF/spring/app-context-xml.xml");

		ctxChild.setParent(ctxParent);
		ctxChild.refresh();
		SimpleTarger target1 = (SimpleTarger) ctxChild.getBean("target1");
		SimpleTarger target2 = (SimpleTarger) ctxChild.getBean("target2");
		SimpleTarger target3 = (SimpleTarger) ctxChild.getBean("target3");
		System.out.println(target1.getVal());
		System.out.println(target2.getVal());
		System.out.println(target3.getVal());
	}
}
