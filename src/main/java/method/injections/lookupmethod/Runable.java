package method.injections.lookupmethod;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class Runable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-method-injection.xml");
		ctx.refresh();

		DemoBean abstractBean = (DemoBean) ctx.getBean("abstractLookupBean");
		DemoBean standardBean = (DemoBean) ctx.getBean("standardLookupBean");
		displayInfo(standardBean);
		displayInfo(abstractBean);
	}

	public static void displayInfo(DemoBean bean) {
		MyHelper helper1 = bean.getMyHelper();
		MyHelper helper2 = bean.getMyHelper();
		System.out.println("Helper Instances the Same?: " + (helper1 == helper2));
		StopWatch stopWatch = new StopWatch();
		stopWatch.start("lookupDemo");
		for (int x = 0; x < 100000; x++) {
			MyHelper helper = bean.getMyHelper();
			helper.doSomethingHelpful();
		}
		stopWatch.stop();
		System.out.println("100000 gets took " + stopWatch.getTotalTimeMillis() + " ms");
	}

}
