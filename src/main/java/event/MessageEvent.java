package event;

import org.springframework.context.ApplicationEvent;

public class MessageEvent extends ApplicationEvent {

	private String msg;

	public MessageEvent(Object source, String msg) {
		super(source);
		if (source instanceof Publisher) {
			System.out.println("In message: source is instanceof Publisher");
		}
		this.msg = msg;
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return msg;
	}

}