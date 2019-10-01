package ch4.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import interfaces.MessageProvider;
import interfaces.MessageRenderer;

@Configuration
public class AppConfig {
	@Bean
	public MessageProvider messageProvider() {
		return new ConfigurableMessageProvider();
	}

	@Bean
	public MessageRenderer messageRenderer() {
		MessageRenderer renderer = new StandardOutMessageRenderer();
		renderer.setMessageProvider(messageProvider());
		return renderer;
	}
}
