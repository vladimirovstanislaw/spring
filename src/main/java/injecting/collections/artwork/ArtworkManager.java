package injecting.collections.artwork;

import java.util.List;

public class ArtworkManager {
	private List<ArtworkSender> list;
	
	public void setList(List<ArtworkSender> list) {
		this.list=list;
	}
	public void listOfSenders() {
		for(ArtworkSender sen:list) {
			System.out.println(sen.getFriendlyName());
		}
	}

}
