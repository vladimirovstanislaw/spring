package environment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import com.sun.xml.internal.ws.api.ha.HaInfo;

public class EnvironmentSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.refresh();
		ConfigurableEnvironment env = ctx.getEnvironment();
		MutablePropertySources propertySources = env.getPropertySources();
		@SuppressWarnings("rawtypes")
		Map appMap = new HashMap();

		appMap.put("application.home", "application_home");
		propertySources.addLast(new MapPropertySource("PROSPRING4_MAP", appMap));

		System.out.println("user.home: " + System.getProperty("user.home"));
		System.out.println("JAVA_HOME: " + System.getenv("JAVA_HOME"));
		System.out.println("user.home: " + env.getProperty("user.home"));
		System.out.println("JAVA_HOME: " + env.getProperty("JAVA_HOME"));
		System.out.println("application.home: " + env.getProperty("application.home"));

	}

}
