package Enums;

//setting media type
public enum MediaType {

	CD(1), DVD(2), BluRay(3);

	// instantiation
	private final int idMedia;

	// contructor must to be private, because we could not change the values
	private MediaType(int idMedia) {
		this.idMedia = idMedia;

	}

	//return the media type id
	public int getIdMedia() {
		return this.idMedia;
	}
}
