package injecting.nethodreplacement;

public class ReplacementTarget {
	public String formatMessage(String msg) {
		return "<h1>" + msg + "</h1";
	}

	public String formatMessage(Object msg) {
		return "<h1>" + msg + "</h1";
	}
}
