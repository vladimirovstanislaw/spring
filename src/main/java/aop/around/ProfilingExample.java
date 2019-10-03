package aop.around;

import org.springframework.aop.framework.ProxyFactory;

public class ProfilingExample {
	public static void main(String[] args) {
		WorkerBean bean = getWorkerBean();
		bean.doSomeWork(10000000);
	}

	private static WorkerBean getWorkerBean() {
		// TODO Auto-generated method stub
		WorkerBean target = new WorkerBean();
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvice(new ProfilingInterceptor());

		return (WorkerBean) pf.getProxy();
	}

}
