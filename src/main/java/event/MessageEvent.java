package event;

import org.springframework.context.ApplicationEvent;

public class MessageEvent extends ApplicationEvent {

	private String msg;

	public MessageEvent(Object source, String msg) {
		super(source);
		this.msg = msg;
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return msg;
	}

}