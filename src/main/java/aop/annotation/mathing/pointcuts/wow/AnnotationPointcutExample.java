package aop.annotation.mathing.pointcuts.wow;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

import aop.pointcut.SimpleAdvice;

public class AnnotationPointcutExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SampleAnnotationBean target = new SampleAnnotationBean();
		AnnotationMatchingPointcut pc = AnnotationMatchingPointcut.forMethodAnnotation(AdviceRequired.class);
		Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());

		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisor(advisor);
		SampleAnnotationBean proxy = (SampleAnnotationBean) pf.getProxy();

		proxy.foo(100);
		proxy.bar();
	}

}
