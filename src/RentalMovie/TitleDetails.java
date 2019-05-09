package RentalMovie;

import java.util.Date;

public abstract class TitleDetails {

	// Attributes that will be common
	// for sub classes will be declared here
	// The protected modifier will ensure
	// that subclasses will access them.

	// identify the objects listed on for loops
	protected int id;

	protected String title;
	protected double price;
	protected Date rentStart;
	protected Date rentReturn;

	public Date getRentStart() {
		return rentStart;
	}

	public void setRentStart(Date rentStart) {
		this.rentStart = rentStart;
	}

	public Date getRentReturn() {
		return rentReturn;
	}

	public void setRentReturn(Date rentReturn) {
		this.rentReturn = rentReturn;
	}

	// Generic method toString, to ensure
	// subclasses have it
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public String getName() {
		return title;
	}

	public void setName(String name) {
		this.title = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
