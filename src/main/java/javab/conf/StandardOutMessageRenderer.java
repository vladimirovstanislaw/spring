package javab.conf;

import interfaces.MessageProvider;
import interfaces.MessageRenderer;

public class StandardOutMessageRenderer implements MessageRenderer {
	private MessageProvider messageProvider;

	@Override
	public void render() {
		if (messageProvider == null) {
			throw new RuntimeException(
					"You must set the property messageProvider of class:" + StandardOutMessageRenderer.class.getName());
		}
		System.out.println(messageProvider.getMessage());
	}

	@Override
	public void setMessageProvider(MessageProvider provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public MessageProvider getMessageProvider() {
		// TODO Auto-generated method stub
		return null;
	}
}
