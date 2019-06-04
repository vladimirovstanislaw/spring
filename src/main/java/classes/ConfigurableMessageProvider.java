package classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import interfaces.MessageProvider;

@Service("configurableMssageProvider")
public class ConfigurableMessageProvider implements MessageProvider {
	private String message;

	@Autowired
	public ConfigurableMessageProvider(String message) {
		this.message = message;
	}

	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

}

/*
	
cd C:/Projects/spring.me
git init
git add .
git commit -m "first commit"
git remote add origin git@github.com:vladimirovstanislaw/spring.git
git push -u origin master

*/