package aop.jest.ya.krut;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AspectJAnnotationExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/jest-ya-krut-app-config-annotation.xml");
		ctx.refresh();
		MyBean myBean = (MyBean) ctx.getBean("myBean");
		myBean.execute();
	}
}
