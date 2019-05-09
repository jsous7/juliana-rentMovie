package Enums;

public enum OptionsOfMusic {

	Rock(1,"Rock"),
	Romance(2, "Romance"),
	Pop(3, "Pop"),
	Classic(4,"Classic");
	
	
	//instantiation 
	private final int idOptions;
	private final String description;
	
	//constructor
	private OptionsOfMusic(int idOptions, String description) {
		this.idOptions=idOptions;
		this.description=description;
		
		
	}
	
	//getting information from Options of Titles
	public int getIdOptions() {
		return idOptions;
		
	}
	public String getDescription() {
		return description;
}
}