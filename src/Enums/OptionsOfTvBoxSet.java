package Enums;

public enum OptionsOfTvBoxSet {

	Culinary(1),
	Talkshow(2),
	VoiceShow(3),
	SoupOpera(4),
	Series(5);
	
	//instantiation 
	private final int idOptions;
	
	//constructor
	private OptionsOfTvBoxSet(int idOptions) {
		this.idOptions=idOptions;
		
	}
	
	//getting information from Options of Titles
	public int getIdOptions() {
		return idOptions;
	}
	
}
