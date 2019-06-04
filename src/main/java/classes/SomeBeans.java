package classes;

import org.springframework.context.annotation.Bean;

public class SomeBeans {
	@Bean
	String message() {
		return "We run our megaApp";
	}
}
