package aop.namespace;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AopNamespaceExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/aop-namespace-app-context.xml");
		ctx.refresh();
		MyBean myBean = (MyBean) ctx.getBean("myBean");
		myBean.execute();

	}
}
