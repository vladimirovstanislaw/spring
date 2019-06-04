package method.injections.lookupmethod;

public abstract class AbstractLookupDemoBean implements DemoBean {
	public abstract MyHelper getMyHelper();

	public void someOperation() { //<= that is method lookup injection
		getMyHelper().doSomethingHelpful();
	}

}
