package spring.me.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({ "classpath*:app-context.xml" })
public class XmlConfiguration {
}