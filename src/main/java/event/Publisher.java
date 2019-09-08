package event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Publisher implements ApplicationContextAware {
	private ApplicationContext ctx;

	public void publish(String message) {
		ctx.publishEvent(new MessageEvent(this, message));
	}

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring/event-app-context.xml");
		Publisher pub = (Publisher) ctx.getBean("publisher");
		pub.publish("Hello World!");
		pub.publish("The quick brown fox jumped over the lazy dog");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.ctx = applicationContext;
	}

}
