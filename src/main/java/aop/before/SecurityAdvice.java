package aop.before;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class SecurityAdvice implements MethodBeforeAdvice {
	private SecurityManager securityManager;

	public SecurityAdvice() {
		// TODO Auto-generated constructor stub
		this.securityManager = new SecurityManager();
	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		UserInfo user = securityManager.getLoggedOnUser();
		if (user == null) {
			System.out.println("No user authenticated");
			throw new SecurityException("You must login before attempting to invoke the method: " + method.getName());
		} else if ("Kolyan".equals(user.getUserName())) {
			System.out.println("Logged in user is Kolyan - NE YBAZHENIE!");
		} else {
			System.out.println("Logged in user is " + user.getUserName() + " NOT GOOD :(");
			throw new SecurityException("User "+user.getUserName() + " is not allowed access to method "+ method.getName());
		}

	}

}
