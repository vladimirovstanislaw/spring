package aop.pointcut;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class Runable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeanOne one = new BeanOne();
		BeanTwo two = new BeanTwo();
		BeanOne proxyOne;
		BeanTwo proxyTwo;

		Pointcut pc = new SimpleStaticPointcut();
		Advice advice = new SimpleAdvice();
		Advisor advisor = new DefaultPointcutAdvisor(pc, advice);

		ProxyFactory pf = new ProxyFactory();
		pf.addAdvisor(advisor);
		pf.setTarget(one);
		proxyOne = (BeanOne) pf.getProxy();

		pf = new ProxyFactory();
		pf.addAdvisor(advisor);
		pf.setTarget(two);
		proxyTwo = (BeanTwo) pf.getProxy();

		proxyOne.foo();
		proxyTwo.foo();
		proxyOne.bar();
		proxyTwo.bar();
	}

}
