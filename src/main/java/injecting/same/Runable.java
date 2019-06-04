package injecting.same;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Runable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx=new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-injecting-same.xml");
		ctx.refresh();
		InjectRef ref=(InjectRef) ctx.getBean("injectRef");
		System.out.println(ref.toString());
		ctx.close();
	}

}
