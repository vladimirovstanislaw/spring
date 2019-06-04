package injecting.same;

import org.springframework.beans.factory.annotation.Value;

public class Oracle {
	
	private String value="jsjsj";

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
