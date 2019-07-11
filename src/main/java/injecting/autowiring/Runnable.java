package injecting.autowiring;

import javax.sound.midi.Soundbank;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/app-context-injecting-autowiring.xml");
		ctx.refresh();
		Target t = null;
		System.out.println("Using by name:\n");
		t = (Target) ctx.getBean("targetByName");
		System.out.println("\nUsing byType:\n");
		t = (Target) ctx.getBean("targetByType");

		System.out.println("\nUsing constructor:\n");
		t = (Target) ctx.getBean("targetConstructor");
	}

}
