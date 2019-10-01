package event;

import org.springframework.context.ApplicationListener;

public class MessageEventListener implements ApplicationListener<MessageEvent> {
	@Override
	public void onApplicationEvent(MessageEvent event) {
		// TODO Auto-generated method stub
		MessageEvent msgEvt = (MessageEvent) event;
		System.out.println("Received: " + msgEvt.getMessage());

	}
}
