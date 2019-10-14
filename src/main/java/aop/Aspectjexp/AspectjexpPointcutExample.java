package aop.Aspectjexp;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import aop.pointcut.SimpleAdvice;

public class AspectjexpPointcutExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AspectjexpBean target = new AspectjexpBean();
		AspectJExpressionPointcut pc = new AspectJExpressionPointcut();

		pc.setExpression("execution(* foo*(..))");
		Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());

		ProxyFactory pf = new ProxyFactory();

		pf.setTarget(target);
		pf.addAdvisor(advisor);

		AspectjexpBean proxy = (AspectjexpBean) pf.getProxy();
		proxy.foo1();
		proxy.foo2();
		proxy.bar();
	}

}
