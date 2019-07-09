package bean.naming;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanNameAliasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/bean-naming.xml");
		ctx.refresh();
		String s1 = (String) ctx.getBean("name1");
		String s2 = (String) ctx.getBean("name2");
		String s3 = (String) ctx.getBean("name3");
		String s4 = (String) ctx.getBean("name4");
		String s5 = (String) ctx.getBean("name5");
		String s6 = (String) ctx.getBean("name6");
		System.out.println((s1 == s2));
		System.out.println((s2 == s3));
		System.out.println((s3 == s4));
		System.out.println((s4 == s5));
		System.out.println((s5 == s6));

	}

}
