package aop.proxy;

public class DefaultSimpleBean implements SimpleBean {
	private long dummy = 0;

	@Override
	public void advised() {
		// TODO Auto-generated method stub
		dummy = System.currentTimeMillis();
	}

	@Override
	public void unadvised() {
		// TODO Auto-generated method stub
		dummy = System.currentTimeMillis();
	}

}
