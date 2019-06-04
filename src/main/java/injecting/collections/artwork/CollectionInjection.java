package injecting.collections.artwork;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("injectCollection")
public class CollectionInjection {
	@Resource(name = "map")
	private Map<String, Object> map;
	@Resource(name = "props")
	private Properties props;
	@Resource(name = "set")
	private Set set;

	@Resource(name = "list")
	private List list;

	public void displayInfo() {
		System.out.println("Map contents:\n");
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			System.out.println("Key: " + entry.getKey() + " - Value: " + entry.getValue());
		}
		System.out.println("\nProperties contents:\n");
		for (Map.Entry<Object, Object> entry : props.entrySet()) {
			System.out.println("Key: " + entry.getKey() + " - Value: " + entry.getValue());
		}
		System.out.println("\nSet contents:\n");
		for (Object obj : set) {
			System.out.println("Value: " + obj);
		}
		System.out.println("\nList contents:\n");
		for (Object obj : list) {
			System.out.println("Value: " + obj);
		}
	}

}
