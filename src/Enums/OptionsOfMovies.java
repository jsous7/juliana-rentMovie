package Enums;

public enum OptionsOfMovies {

	Drama(1),
	Commedy(2),
	Action(3),
	Fiction(4),
	Horror(5);
	
	//instantiation 
	private final int idOptions;
	
	//constructor
	private OptionsOfMovies(int idOptions) {
		this.idOptions=idOptions;
		
	}
	
	//getting information from Options of Titles
	public int getIdOptions() {
		return idOptions;
	}
	
}
