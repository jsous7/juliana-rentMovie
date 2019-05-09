package RentalMovie;

public class MemberShipCard {

	   private int points;
	   private boolean freeRentAllowed;
	   
	  
	   //This method receive an Integer as a parameter and sums the current value of the variable 
	   //"points" with the entered value received by parameter, also call the method “setRentAllowed”.

	   
	   public void addPoints(int points){
			this.points += points;
			setRentAllowed();
	   }
	   
	 //The method call the other method “isFreeRentAllowed”, 
	   //if the return was true:  the variable “points” receive a decrease of 100,
	   //call the method “setRentAllowed” and return true.
	   //Otherwise, return false;

	   
	   public boolean availFreeRent(){
			if(this.isfreeRentAllowed()){
				this.points -= 100;
				setRentAllowed();
				return true;
			} else {
				return false;
			}
	   }
	   
	 //The method check if the variable “points” is bigger or equal to 100. 
	   //If the return was true, the variable “freeRentAllowed” receives true.
			  // Otherwise, the variable “freeRentAllowed” receive false.

	   
	   
	   private void setRentAllowed(){
			if (this.points >= 100){
				this.freeRentAllowed = true;
			} else {
				this.freeRentAllowed = false;
			}
	   }
	   
	   //The method return an Integer number, containing the value of the variable “points”.

	   public int getPoints() {
			return  points;
       }
	   
	   //The method return the actual value of the Boolean variable “freeRetAllowed”
	   public boolean isfreeRentAllowed(){
			return freeRentAllowed;
	   
	   }
	   
}