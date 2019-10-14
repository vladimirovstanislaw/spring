package aop.refex.pointcut;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;

import aop.pointcut.SimpleAdvice;

public class RegexpPointcutExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegexpBean target = new RegexpBean();

		JdkRegexpMethodPointcut pc = new JdkRegexpMethodPointcut();
		pc.setPattern(".*foo.*");
		Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());

		ProxyFactory pf = new ProxyFactory();

		pf.addAdvisor(advisor);
		pf.setTarget(target);
		RegexpBean proxy = (RegexpBean) pf.getProxy();
		proxy.foo1();
		proxy.foo2();
		proxy.bar();

	}

}
