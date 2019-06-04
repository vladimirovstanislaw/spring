package classes;

import org.springframework.stereotype.Service;

import interfaces.MessageProvider;

@Service("messageProvider")
public class HelloWorldMessageProvider implements MessageProvider {
	
	public String getMessage() {
		return "пішов нахуй!";
	}
}