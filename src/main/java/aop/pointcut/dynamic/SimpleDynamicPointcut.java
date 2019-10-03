package aop.pointcut.dynamic;

import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> sls) { //static matching being first
		System.out.println("Static check for " + method.getName());
		return ("foo".equals(method.getName()));
	}

	@Override
	public boolean matches(Method method, Class<?> sls, Object... args) {
		// TODO Auto-generated method stub
		System.out.println("Dynamic check for " + method.getName());
		int x = ((Integer) args[0]).intValue();
		return (x != 100);
	}

	@Override
	public ClassFilter getClassFilter() {
		return new ClassFilter() {

			@Override
			public boolean matches(Class<?> clazz) {
				// TODO Auto-generated method stub
				return (clazz == SampleBean.class);
			}

		};
	}

}
