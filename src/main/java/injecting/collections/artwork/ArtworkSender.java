package injecting.collections.artwork;

public interface ArtworkSender {
	void sendArtwork(String artworkPath, Recipient recipient);

	String getFriendlyName();

	String getShortName();
}
