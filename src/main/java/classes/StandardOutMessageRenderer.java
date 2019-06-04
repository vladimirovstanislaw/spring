package classes;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import interfaces.MessageProvider;
import interfaces.MessageRenderer;

@Service("messageRenderer")
public class StandardOutMessageRenderer implements MessageRenderer {
	private MessageProvider messageProvider;

	public void render() {
		if (messageProvider == null) {
			throw new RuntimeException(
					"You must set the property messageProvider of class:" + StandardOutMessageRenderer.class.getName());
		}
		System.out.println(messageProvider.getMessage());
	}
	
	@Resource(name="messageProvider")
	public void setMessageProvider(MessageProvider provider) {
		this.messageProvider = provider;
	}

	public MessageProvider getMessageProvider() {
		return this.messageProvider;
	}
}
