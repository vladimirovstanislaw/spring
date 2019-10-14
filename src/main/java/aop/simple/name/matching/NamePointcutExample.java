package aop.simple.name.matching;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.adapter.DefaultAdvisorAdapterRegistry;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

import aop.pointcut.SimpleAdvice;

public class NamePointcutExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NameBean target = new NameBean();

		NameMatchMethodPointcut pc = new NameMatchMethodPointcut();

		pc.addMethodName("foo");
		pc.addMethodName("bar");
		Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());

		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisor(advisor);
		NameBean proxy = (NameBean) pf.getProxy();
		proxy.foo();
		proxy.foo(99);
		proxy.bar();
		proxy.yup();

	}

}
