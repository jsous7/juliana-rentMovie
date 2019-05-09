package Enums;

public enum UserTypes {
	
	//setting the user type
	MusicLovers(1,"Can only rent Music CDs and Live Concert Videos","10"),
	VideoLovers(2,"Can only rent Movies", "5"),
	TVLovers(3,"Can only rent Box Sets","5"), //this is the Live Concert Videos
	Premium(4,"Can rent any title","18"),
	
	;

	//instantiation
	private final int idUserType;
	private final String description;
		private final String price;
	private UserTypes(int idUserType, String description, String price) {
		this.idUserType= idUserType;
		this.description = description;
	    this.price= price;
		
	}
	//return the text
       public String getDescription() {
    	   return this.description;
       }
       public int getidUserType() {
    	   return this.idUserType;
       }
	public String getPrice() {
		return price;
	}
}

