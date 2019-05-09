package Enums;

public enum OptionsOfLiveConcertVideos {

	ClassicConcert(1),
	LiveShow(2),
	Youtube(3);
	
	//instantiation 
	private final int idOptions;
	
	//constructor
	private OptionsOfLiveConcertVideos(int idOptions) {
		this.idOptions=idOptions;
		
	}
	
	//getting information from Options of Titles
	public int getIdOptions() {
		return idOptions;
	}
	
}
