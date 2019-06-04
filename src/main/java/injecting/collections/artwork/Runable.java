package injecting.collections.artwork;

import org.springframework.context.support.GenericXmlApplicationContext;

import injecting.collections.artwork.CollectionInjection;

public class Runable {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//		ctx.load("classpath:META-INF/spring/artwork.xml");
//		ctx.refresh();
//		ArtworkManager manager = (ArtworkManager) ctx.getBean("manager");
//		manager.listOfSenders();
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/artwork.xml");
		ctx.refresh();
		CollectionInjection instance = (CollectionInjection) ctx.getBean("injectCollection");
		instance.displayInfo();
	}

}
