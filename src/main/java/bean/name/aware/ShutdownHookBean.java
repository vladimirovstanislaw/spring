package bean.name.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericXmlApplicationContext;

import bean.destructions.DestructiveBeanWithInterface;

public class ShutdownHookBean implements ApplicationContextAware {

	private ApplicationContext ctx;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		if (ctx instanceof GenericXmlApplicationContext) {
			((GenericXmlApplicationContext) ctx).registerShutdownHook();
			
		}
	}

}
