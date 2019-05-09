package RentalMovie;

public class CustomerDetails {
	//building customer attributes
  private int id;
  private String name;
  private String address;
  private MemberShipCard card;//creating object type MemberShipcard
  private String phone;
  private String cardNumber;
  
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getCardNumber() {
	return cardNumber;
}
public void setCardNumber(String cardNumber) {
	this.cardNumber = cardNumber;
}
public MemberShipCard getCard() {
	return card;
}
public void setCard(MemberShipCard card) {
	this.card = card;
}
	 
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
	
	
}
