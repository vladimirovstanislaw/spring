package aop.after.returning;

import org.springframework.aop.framework.ProxyFactory;

public class AfterAdviceExample {
	private static KeyGenerator getKeyGenerator() {
		KeyGenerator target = new KeyGenerator();
		ProxyFactory pf = new ProxyFactory();

		pf.setTarget(target);
		pf.addAdvice(new WeakKeyCheckAdvice());

		return (KeyGenerator) pf.getProxy();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeyGenerator keyGen = getKeyGenerator();

		for (int x = 0; x < 10; x++) {
			try {
				long key = keyGen.getKey();
				System.out.println("Key: " + key);
			} catch (SecurityException ex) {
				System.out.println("Weak Key Generated!");
			}
		}
	}

}
