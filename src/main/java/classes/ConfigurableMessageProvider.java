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
	
cd /c/Users/svladimirov/eclipse-workspace/spring/spring

git add .
git commit -m "4th chapter started, yuhooo"

git push -u origin master

*/