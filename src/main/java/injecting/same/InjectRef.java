package injecting.same;

public class InjectRef {
	private Oracle oracle;

	public void setOracle(Oracle oracle) {
		this.oracle = oracle;
	}
	public String toString() {
		return oracle.getValue();
	}
}
