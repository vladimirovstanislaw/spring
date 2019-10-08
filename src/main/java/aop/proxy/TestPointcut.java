package aop.proxy;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

public class TestPointcut extends StaticMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		// TODO Auto-generated method stub
		return ("advised".equals(method.getName()));
	}

}
