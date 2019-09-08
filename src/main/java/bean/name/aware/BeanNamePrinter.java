package bean.name.aware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanNamePrinter implements BeanNameAware {
	private String beanName;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/bean-name-aware-app-context.xml");
		ctx.refresh();

		BeanNamePrinter bean = (BeanNamePrinter) ctx.getBean("beanNamePrinter");
		bean.someOperation();
	}

	public void someOperation() {
		System.out.println("Bean [" + beanName + "] - someOperation()");
	}

	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		this.beanName = name;
	}

}
