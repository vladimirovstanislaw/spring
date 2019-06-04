package injecting.collections.artwork;

import org.springframework.stereotype.Service;

@Service("oracle")
public class Oracle {
	public String defineMeaningOfLife() {
		return "Encyclopedias are a waste of money - use the Internet";
	}
}
