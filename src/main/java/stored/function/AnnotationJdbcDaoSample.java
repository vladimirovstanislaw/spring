package stored.function;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.jdbc.ContactDao;

public class AnnotationJdbcDaoSample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/stored-function-app-context.xml");
		ctx.refresh();

		ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
		System.out.println(contactDao.findFirstNameById(1l));

	}
}
