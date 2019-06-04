package method.injections.lookupmethod;

public class StandardLookupDemoBean implements DemoBean {
	private MyHelper myHelper;

	public void setMyHelper(MyHelper myHelper) {
		this.myHelper = myHelper;
	}

	public MyHelper getMyHelper() {
		// TODO Auto-generated method stub
		return this.myHelper;
	}

	public void someOperation() {
		// TODO Auto-generated method stub
		myHelper.doSomethingHelpful();
	}

}
