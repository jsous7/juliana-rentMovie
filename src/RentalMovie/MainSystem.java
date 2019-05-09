package RentalMovie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

import Enums.MediaType;
import Enums.OptionsOfLiveConcertVideos;
import Enums.OptionsOfMovies;
import Enums.OptionsOfMusic;
import Enums.OptionsOfTvBoxSet;
import Enums.UserTypes;

public class MainSystem {

	// global attributes
	private int userSubscription, userInput;
	boolean isValid;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// creating array of objects
	ArrayList<Music> arrayMusic;
	ArrayList<Movie> arrayMovie;
	ArrayList<LiveConcertVideos> arrayConcertVideos;
	ArrayList<BoxTvSet> arrayBoxTvSet;

	// act like my databases
	// ArrayList<String> arrayName = new ArrayList<String>();
	// creating array of objects
	ArrayList<CustomerDetails> arrayCustomer;
	
	//attribute that will be used to identify the logged user
	CustomerDetails logged;

	public MainSystem() {

		do {
			optionsAtTheStart();

		} while (isValid != true);
		// optionsAtTheStart();

	}

	private void optionsAtTheStart() {
		// calling the method that display the list of musics
		inputMusic();
		// calling the method that display the list of movies
		inputMovie();
		// calling the method that display the list of Live Concert Videos
		inputLiveConcertVideos();
		// calling the method that display the list of BoxSet
		inputTvBoxSet();
		// calling the method that display the list of Customers
		inputCustomer();

		int userChoice = 0;


		try {

			
				// show list of users registered

				for (int i = 0; i < arrayCustomer.size(); i++) {

					System.out.println("Code " + i + " Name " + this.arrayCustomer.get(i).getName()+ " Points "+ this.arrayCustomer.
							get(i).getCard().getPoints());
				}

				// choose the user id
				int typeCode = 0;
				int field = 0;
				System.out.println("Which customer would you like to login \n type code: ");
				
					typeCode = Integer.parseInt(br.readLine());
				
					if(typeCode < this.arrayCustomer.size()) {
						this.logged=this.arrayCustomer.get(typeCode);
						System.out.println("You are logged!");
					}
					do {
				System.out.println("1 - Search(title/custumer)");
				System.out.println("2 - Subscribe(title/custumer)");
				System.out.println("3 - Update(custumer)");
				System.out.println("4 - Title Return ");
				System.out.println("0 - Exit! \n");

				userChoice = Integer.parseInt(br.readLine());
				userSubscription();

				int userChoice2 = 0;

				if (userChoice == 1) {
					System.out.println("search");
					search();
				} else if (userChoice == 2) {
					System.out.println("Choose 1-Title or 2-Customer:  ");
					userChoice2 = Integer.parseInt(br.readLine());

					if (userChoice2 == 1) {
						System.out.println("Title");
						addTitle();
					} else if (userChoice2 == 2) {
						System.out.println("Customer");
						subscribe();
					}

				} else if (userChoice == 3) {

					System.out.println("CUSTOMER");
					update();

				} else if (userChoice == 4) {

					System.out.println("TITLE RETURN");
					returnTitle();
				} else
					isValid = true;

			} while (userChoice != 0);
		} catch (Exception e) {
			System.out.println("Error " + e);
		}
	}

	private void inputMusic() {

		// instantiation of array of object
		this.arrayMusic = new ArrayList<Music>();
		Music music = new Music();
		music.setName("Wonderwall");
		music.setMusic(OptionsOfMusic.Rock);
		music.setPrice(1);

		// adding the values that has been created
		this.arrayMusic.add(music);
		// I am instatiating again to be able to clean up the date inserted before
		music = new Music();

		music.setName("Hello");
		music.setMusic(OptionsOfMusic.Romance);
		music.setPrice(1);

		this.arrayMusic.add(music);
		music = new Music();

		music.setName("Shallow");
		music.setMusic(OptionsOfMusic.Pop);
		music.setPrice(1);

		this.arrayMusic.add(music);
		music = new Music();

		music.setName("St. Matthew Passion");
		music.setMusic(OptionsOfMusic.Classic);
		music.setPrice(1);

		this.arrayMusic.add(music);

	}

	private void inputMovie() {

		// instantiation of one array of an object
		this.arrayMovie = new ArrayList<Movie>();
		Movie movie = new Movie();
		movie.setName("A star is Born");
		movie.setMovie(OptionsOfMovies.Drama);
		movie.setPrice(1);

		
		// adding the values that has been created
		this.arrayMovie.add(movie);
		// I am instatiating again to be able to clean up the date inserted before
		movie = new Movie();

		movie.setName("Shazam");
		movie.setMovie(OptionsOfMovies.Commedy);
		movie.setPrice(1);

		this.arrayMovie.add(movie);
		movie = new Movie();

		movie.setName("Fast and Furious");
		movie.setMovie(OptionsOfMovies.Action);
		movie.setPrice(1);

		this.arrayMovie.add(movie);
		movie = new Movie();

		movie.setName("Artificial intelligence");
		movie.setMovie(OptionsOfMovies.Fiction);
		movie.setPrice(1);

		this.arrayMovie.add(movie);
		movie = new Movie();

		movie.setName("Us");
		movie.setMovie(OptionsOfMovies.Horror);
		movie.setPrice(1);

		this.arrayMovie.add(movie);

	}


	private void inputLiveConcertVideos() {
		// instantiation of one array of an object
		// creating object to insert values inside my array of objects
		this.arrayConcertVideos = new ArrayList<LiveConcertVideos>();
		LiveConcertVideos videos = new LiveConcertVideos();
		videos.setName("On the moon");
		videos.setLive(OptionsOfLiveConcertVideos.ClassicConcert);
		videos.setPrice(1);

		// adding the values that has been created
		this.arrayConcertVideos.add(videos);

		// I am instatiating again to be able to clean up the date inserted before
		videos = new LiveConcertVideos();

		videos.setName("Irish Got A Talent");
		videos.setLive(OptionsOfLiveConcertVideos.LiveShow);
		videos.setPrice(1);

		this.arrayConcertVideos.add(videos);
		videos = new LiveConcertVideos();

		videos.setName("Veritasium");
		videos.setLive(OptionsOfLiveConcertVideos.LiveShow);
		videos.setPrice(1);

		this.arrayConcertVideos.add(videos);

	}


	// the method does not return any value
	private void inputTvBoxSet() {

		// instantiation of my global array

		this.arrayBoxTvSet = new ArrayList<BoxTvSet>();
		// creating object to insert values inside my array of objects
		BoxTvSet box = new BoxTvSet();
		box.setName("Master Chef");
		box.setBox(OptionsOfTvBoxSet.Culinary);
		box.setPrice(1);

		// adding the values that has been created
		this.arrayBoxTvSet.add(box);

		// I am instatiating again to be able to clean up the date inserted before
		box = new BoxTvSet();

		box.setName("The Oprah Winfrey");
		box.setBox(OptionsOfTvBoxSet.Talkshow);
		box.setPrice(1);

		this.arrayBoxTvSet.add(box);

		box = new BoxTvSet();

		box.setName("The Voice");
		box.setBox(OptionsOfTvBoxSet.VoiceShow);
		box.setPrice(1);

		this.arrayBoxTvSet.add(box);

		box = new BoxTvSet();

		box.setName("Days of Our Lives (1965)");
		box.setBox(OptionsOfTvBoxSet.SoupOpera);
		box.setPrice(1);

		this.arrayBoxTvSet.add(box);

		box = new BoxTvSet();

		box.setName("Game of Thrones");
		box.setBox(OptionsOfTvBoxSet.Series);
		box.setPrice(1);

		this.arrayBoxTvSet.add(box);
	}

	public void inputCustomer() {

		// instantiation of array of object
		this.arrayCustomer = new ArrayList<CustomerDetails>();
		CustomerDetails customer = new CustomerDetails();
		customer.setName("Juliana Sousa");
		customer.setAddress("25 Wolfe Tone Street");
		// instatiation of the class membershipcard
		customer.setCard(new MemberShipCard());
		customer.setCardNumber("1234567890123456");
		customer.setPhone("0838598395");
		customer.getCard().addPoints(150);
		
		// adding the values that has been created
		this.arrayCustomer.add(customer);
		// I am instatiating again to be able to clean up the date inserted before
		customer = new CustomerDetails();

		customer.setName("Anderson Soares");
		customer.setAddress("18 Ratra Road");
		// instatiation of the class membershipcard
		customer.setCard(new MemberShipCard());

		customer.setCardNumber("1234567890123456");
		customer.setPhone("0838598399");
		customer.getCard().addPoints(50);
		
		// adding the values that has been created
		this.arrayCustomer.add(customer);
		// I am instatiating again to be able to clean up the date inserted before
		customer = new CustomerDetails();

		customer.setName("Bibiana B.");
		customer.setAddress("25 Wolfe Tone Street");
		// instatiation of the class membershipcard
		customer.setCard(new MemberShipCard());

		customer.setCardNumber("1234567890123457");
		customer.setPhone("0838598396");
		customer.getCard().addPoints(80);
		
		// adding the values that has been created
		this.arrayCustomer.add(customer);
		// I am instatiating again to be able to clean up the date inserted before
		customer = new CustomerDetails();

		customer.setName("Barbara House");
		customer.setAddress("25 Wolfe Tone Street");
		// instatiation of the class membershipcard
		customer.setCard(new MemberShipCard());

		customer.setCardNumber("1234567890123458");
		customer.setPhone("0838598390");
		
		customer.getCard().addPoints(10);
		// adding the values that has been created
		this.arrayCustomer.add(customer);
	}

	private void subscribe() {

		// object of my class Customer Details
		CustomerDetails obj = new CustomerDetails();

		// assigning values authomatically
		obj.setId(arrayCustomer.size() + 1);

		// adding values in my array

		System.out.println("Enter your full name: ");
		String name = null;
		try {
			name = br.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		obj.setName(name);

		System.out.println("Enter your full Address: ");
		String address = null;
		try {
			address = br.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		obj.setAddress(address);

		System.out.println("Enter your phone number: ");
		String phone = null;
		try {
			phone = br.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		obj.setPhone(phone);

		System.out.println("Enter your card number: ");
		String cardNumber = null;
		try {
			cardNumber = br.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		obj.setCardNumber(cardNumber);

		arrayCustomer.add(obj);
		System.out.println("Your subcription is made successfully!");
	}

	private void search() {

		CustomerDetails obj = new CustomerDetails();

		System.out.println("1 - Title");
		System.out.println("2 - Customer \n");

		int userChoice;
		String inputTitle;
		int menuChoice;
		
			try {
			userChoice = Integer.parseInt(br.readLine());
			if (userChoice == 1) {
				System.out.println("Choose the to rent: ");
				System.out.println("1 Music: ");
				System.out.println("2 Movie: ");
				System.out.println("3 Live Concert Video: ");
				System.out.println("4 BoxTvSet: ");
				menuChoice = Integer.parseInt(br.readLine());
				
				
				
				System.out.println("Enter the title name: ");
				
				
                //checking if the value of the user is equal to the value of the list
				inputTitle = br.readLine();
				if(menuChoice==1) {
					//this object was created to store the values created throgh "for" condition
					Music music = new Music();
					
					for(int i=0; i < arrayMusic.size();i++) {
						if(inputTitle.equals(this.arrayMusic.get(i).getName())) {
							music=this.arrayMusic.get(i);
						};
					}
					// shows up the data related to my object selected
					System.out.println(" Music Name " + music.getName() + " Music Type " + music.getMusic() + " Price €" + music.getPrice());

					System.out.println("Would you like to rent this title? ");
					int rentOption=0;
					System.out.println("1 Yes: ");
					System.out.println("2 No: ");
					
					rentOption = Integer.parseInt(br.readLine());
					
					if(rentOption==1) {
						
						if(this.logged.getCard().isfreeRentAllowed())
						{System.out.println("Congratulation you have a rent-free :) ");
						//the debt is made
						this.logged.getCard().availFreeRent();
						//accumulated points
						System.out.println("Now you have " + this.logged.getCard().getPoints() + " points");
						}
						
						// setting the date that is made the transaction
						music.setRentReturn(null);
						music.setRentStart(new Date());
						this.logged.getCard().addPoints(10);//adding points to the user
						
						System.out.println("Your rent is made! " + music.getRentStart());
					}
					
				}
				
				else if(menuChoice==2) {
					//this object was created to store the values created throgh "for" condition
					Movie movie = new Movie();
					
					for(int i=0; i < arrayMovie.size();i++) {
						if(inputTitle.equals(this.arrayMovie.get(i).getName())) {
							movie=this.arrayMovie.get(i);
						};
					}
					// shows up the data related to my object selected
					System.out.println(" Movie Name " + movie.getName() + " Movie Type " + movie.getMovie() + " Price €" + movie.getPrice());

					System.out.println("Would you like to rent this title? ");
					int rentOption=0;
					System.out.println("1 Yes: ");
					System.out.println("2 No: ");
					
					rentOption = Integer.parseInt(br.readLine());
					
					if(rentOption==1) {
						
						if(this.logged.getCard().isfreeRentAllowed())
						{System.out.println("Congratulation you have a rent-free :) ");
						//the debt is made
						this.logged.getCard().availFreeRent();
						//accumulated points
						System.out.println("Now you have " + this.logged.getCard().getPoints() + " points");
						}
						
						// setting the date that is made the transaction
						movie.setRentReturn(null);
						movie.setRentStart(new Date());
						this.logged.getCard().addPoints(10);//adding points to the user
						
						System.out.println("Your rent is made! " + movie.getRentStart());
					}
				}else if(menuChoice==3) {
					
					//this object was created to store the values created throgh "for" condition
					LiveConcertVideos concertVideos = new LiveConcertVideos();
					
					for(int i=0; i < arrayConcertVideos.size();i++) {
						if(inputTitle.equals(this.arrayConcertVideos.get(i).getName())) {
							concertVideos=this.arrayConcertVideos.get(i);
						};
					}
					// shows up the data related to my object selected
					System.out.println(" Concert Name " + concertVideos.getName() + " Concert Type " + concertVideos.getLive() + 
							" Price €" + concertVideos.getPrice());

					System.out.println("Would you like to rent this title? ");
					int rentOption=0;
					System.out.println("1 Yes: ");
					System.out.println("2 No: ");
					
					rentOption = Integer.parseInt(br.readLine());
					
					if(rentOption==1) {
						
						if(this.logged.getCard().isfreeRentAllowed())
						{System.out.println("Congratulation you have a rent-free :) ");
						//the debt is made
						this.logged.getCard().availFreeRent();
						//accumulated points
						System.out.println("Now you have " + this.logged.getCard().getPoints() + " points");
						}
						
						// setting the date that is made the transaction
						concertVideos.setRentReturn(null);
						concertVideos.setRentStart(new Date());
						this.logged.getCard().addPoints(10);//adding points to the user
						
						System.out.println("Your rent is made! " + concertVideos.getRentStart());
					}
					
				}else if(menuChoice==4) {
					//this object was created to store the values created throgh "for" condition
					BoxTvSet box = new BoxTvSet();
					
					for(int i=0; i < arrayBoxTvSet.size();i++) {
						if(inputTitle.equals(this.arrayBoxTvSet.get(i).getName())) {
							box=this.arrayBoxTvSet.get(i);
						};
					}
					// shows up the data related to my object selected
					System.out.println(" BoxSet Name " + box.getName() + " BoxSet Type " + box.getBox() + 
							" Price €" + box.getPrice());

					System.out.println("Would you like to rent this title? ");
					int rentOption=0;
					System.out.println("1 Yes: ");
					System.out.println("2 No: ");
					
					rentOption = Integer.parseInt(br.readLine());
					
					if(rentOption==1) {
						
						if(this.logged.getCard().isfreeRentAllowed())
						{System.out.println("Congratulation you have a rent-free :) ");
						//the debt is made
						this.logged.getCard().availFreeRent();
						//accumulated points
						System.out.println("Now you have " + this.logged.getCard().getPoints() + " points");
						}
						
						// setting the date that is made the transaction
						box.setRentReturn(null);
						box.setRentStart(new Date());
						this.logged.getCard().addPoints(10);//adding points to the user
						
						System.out.println("Your rent is made! " + box.getRentStart());
					}
					
				}
				

			} else if (userChoice == 2) {
				System.out.println("Enter name: ");
				inputTitle = br.readLine();

				// searching for the user input and checking the value with my arrayCustomer
				// List
				for (int i = 0; i < arrayCustomer.size(); i++) {

					// we used .equals() to get exactly the same value, but with
					// the function contains() is more open and check multiple values
					// the function toLowerCase() here transforme the value in lowercase before
					// search the value

					if (arrayCustomer.get(i).getName().toLowerCase().contains(inputTitle.toLowerCase())) {

						obj = arrayCustomer.get(i);

					}

				}
				System.out.println("Id " + obj.getId() + " Name " + obj.getName() + " Address " + obj.getAddress()
						+ " Phone " + obj.getPhone() + " Card Number " + obj.getCardNumber());

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//
//		// accessing enum to get price
//		System.out.println("1 for Music €" + UserTypes.MusicLovers.getPrice());
//		System.out.println("2 for Video €" + UserTypes.VideoLovers.getPrice());
//		System.out.println("3 for Live Concert Videos €" + UserTypes.TVLovers.getPrice());
//		System.out.println("4 for Box Tv Set €" + UserTypes.Premium.getPrice());
//
//		try {
//			userSubscription = Integer.parseInt(br.readLine());
//			userSubscription();
//		} catch (Exception e) {
//			System.out.println("Error " + e);
//		}
//		System.out.println("1 for Search titles");
//		System.out.println("2 for return title");
//		try {
//			userInput = Integer.parseInt(br.readLine());
//		} catch (Exception e) {
//			System.out.println("Error " + e);
//		}
//		if (userInput == 1) {
//			searchTitles();
//		} else if (userInput == 2) {
//			returnTitle();
//		}
//
//	}

	public void userSubscription() {
		// inputMusic();
		if (userSubscription == 1) {
			System.out.println("You are subscribed as Music Lover");
			for (int i = 0; i < this.arrayMusic.size(); i++) {
				System.out.println("Id" + this.arrayMusic.get(i).getId() + " Music Name "
						+ this.arrayMusic.get(i).getName() + " Music Type " + arrayMusic.get(i).getMusic());

			}
		} else if (userSubscription == 2) {
			System.out.println("You are subscribed as Video Lover");
			for (int i = 0; i < this.arrayMovie.size(); i++) {
				System.out.println("Id" + this.arrayMovie.get(i).getId() + " Movie Name "
						+ this.arrayMovie.get(i).getName() + " Movie Type " + arrayMovie.get(i).getMovie());
				// arrayConcertVideos
			}
		} else if (userSubscription == 3) {
			System.out.println("You are subscribed as TV Lover");
			for (int i = 0; i < this.arrayConcertVideos.size(); i++) {
				System.out.println("Id" + this.arrayConcertVideos.get(i).getId() + " Concert Name "
						+ this.arrayConcertVideos.get(i).getName() + " Concert Type "
						+ arrayConcertVideos.get(i).getLive());
			}
			// arrayBoxTvSet
		} else if (userSubscription == 4) {
			System.out.println("You are subscribed as Box Set Lover");
			for (int i = 0; i < this.arrayBoxTvSet.size(); i++) {
				System.out.println("Id" + this.arrayBoxTvSet.get(i).getId() + " Concert Name "
						+ this.arrayBoxTvSet.get(i).getName() + " Concert Type " + arrayBoxTvSet.get(i).getBox());
			}
		}
	}

	private void returnTitle() {

		System.out.println("Please select the type of the Title \n ");

		System.out.println(" 1 -(ML) Music");
		System.out.println(" 2 -(ML) Live Concert Videos");
		System.out.println(" 3 -(VL) Movie");
		System.out.println(" 4 -(TV) Box Set \n");

		int returnOption = 0;
		try {
			returnOption = Integer.parseInt(br.readLine());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (returnOption == 1) {

			// creating objt arrayMusic

			Music music = new Music();

			// Show all the titles on the array
			// i = represent the position of the itens

			for (int i = 0; i < this.arrayMusic.size(); i++) {
				System.out.println("Code" + i + " Music Name " + this.arrayMusic.get(i).getName() + " Music Type "
						+ arrayMusic.get(i).getMusic());

			}

			// the user will choose the option
			// then we set the date of return as now and the date of start as null

			System.out.println("Enter the code number: ");

			try {
				returnOption = Integer.parseInt(br.readLine());

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

			// returning title
			if (returnOption <= arrayMusic.size()) {
				music = arrayMusic.get(returnOption);
			}
			// shows up the data related to my object selected
			System.out.println(" Music Name " + music.getName() + " Music Type " + music.getMusic());

			// setting the date that is made the transaction
			music.setRentReturn(new Date());// here is set as new date because the return is made
			music.setRentStart(null);// here is null because the date is available for new rental

			System.out.println("Your rent is returned!" + music.getRentReturn());

			System.out.println(" Your Music title was successfully returned  \n");
		} else if (returnOption == 2) {

			// creating objt arrayMusic

			LiveConcertVideos concert = new LiveConcertVideos();

			// Show all the titles on the array
			// i = represent the position of the itens

			for (int i = 0; i < this.arrayConcertVideos.size(); i++) {
				System.out.println("Code" + i + " Live Concert Videos Name " + this.arrayConcertVideos.get(i).getName()
						+ " Live Concert Videos " + arrayConcertVideos.get(i).getLive());

			}

			// the user will choose the option
			// then we set the date of return as now and the date of start as null

			System.out.println("Enter the code number: ");

			try {
				returnOption = Integer.parseInt(br.readLine());

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

			// returning title
			if (returnOption <= arrayMovie.size()) {
				concert = arrayConcertVideos.get(returnOption);
			}
			// shows up the data related to my object selected
			System.out.println(
					" Live Concert Video Name " + concert.getName() + " Live Concert Video " + concert.getLive());

			// setting the date that is made the transaction
			concert.setRentReturn(new Date());// here is set as new date because the return is made
			concert.setRentStart(null);// here is null because the date is available for new rental

			System.out.println("Your rent is returned!" + concert.getRentReturn());

		} else if (returnOption == 3) {

			// creating objt arrayMusic

			Movie movie = new Movie();

			// Show all the titles on the array
			// i = represent the position of the itens

			for (int i = 0; i < this.arrayMovie.size(); i++) {
				System.out.println("Code" + i + " Movie Name " + this.arrayMovie.get(i).getName() + " Movie Type "
						+ arrayMovie.get(i).getMovie());

			}

			// the user will choose the option
			// then we set the date of return as now and the date of start as null

			System.out.println("Enter the code number: ");

			try {
				returnOption = Integer.parseInt(br.readLine());

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

			// returning title
			if (returnOption <= arrayMovie.size()) {
				movie = arrayMovie.get(returnOption);
			}
			// shows up the data related to my object selected
			System.out.println(" Music Name " + movie.getName() + " Music Type " + movie.getMovie());

			// setting the date that is made the transaction
			movie.setRentReturn(new Date());// here is set as new date because the return is made
			movie.setRentStart(null);// here is null because the date is available for new rental

			System.out.println("Your rent is returned!" + movie.getRentReturn());

			System.out.println(" Your Movie title was successfully returned  \n");
		} else if (returnOption == 4) {
			// Show all the Boxx set titles on the array

			BoxTvSet box = new BoxTvSet();

			// Show all the titles on the array
			// i = represent the position of the itens

			for (int i = 0; i < this.arrayBoxTvSet.size(); i++) {
				System.out.println("Code" + i + " BoxTvSet Name " + this.arrayBoxTvSet.get(i).getName()
						+ " BoxTvSet Type " + arrayMovie.get(i).getMovie());

			}

			// the user will choose the option
			// then we set the date of return as now and the date of start as null

			System.out.println("Enter the code number: ");

			try {
				returnOption = Integer.parseInt(br.readLine());

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

			// returning title
			if (returnOption <= arrayBoxTvSet.size()) {
				box = arrayBoxTvSet.get(returnOption);
			}
			// shows up the data related to my object selected
			System.out.println(" BoxTvSet Name " + box.getName() + " BoxTvSet Type " + box.getBox());

			// setting the date that is made the transaction
			box.setRentReturn(new Date());// here is set as new date because the return is made
			box.setRentStart(null);// here is null because the date is available for new rental

			System.out.println("Your rent is returned!" + box.getRentReturn());

			System.out.println(" Your Box Set title was successfully returned  \n");
		}

	}

//	private void searchTitles() {
//		int type = 0;
//		System.out.println("1 for CD\n 2 for DVD\n 3 for Blu-Ray");
//		try {
//			type = Integer.parseInt(br.readLine());
//		} catch (Exception e) {
//			System.out.println("error " + e);
//		}
//		// calling enum class to get id media
//		if (type == MediaType.CD.getIdMedia()) {
//			if (userSubscription == 1) {
//				Music music = new Music();//
//				music.cd();//
//			} else if (userSubscription == 2) {
//				// only videossss
//			}
//		}
//
//		else if (type == MediaType.DVD.getIdMedia()) {
//			if (userSubscription == 1) {
//
//			} else if (userSubscription == 2) {
//				// only videossss
//			}
//
//		} else if (type == MediaType.BluRay.getIdMedia()) {
//			if (userSubscription == 1) {
//
//			} else if (userSubscription == 2) {
//				// only videossss
//			}
//		}
//
//	}

	private void addTitle() {

		int item = 0;
		Music music = new Music();
		System.out.println("enter new item");
		try {
			System.out.println("1 for Music");
			System.out.println("2 for Video ");
			System.out.println("3 for Live Concert Videos ");
			System.out.println("4 for Box Tv Set ");

			item = Integer.valueOf(br.readLine());

			if (item == 1) {

				// creating obj of my arrayMusic
				Music obj = new Music();

				// assigning values authomatically
				obj.setId(arrayMusic.size() + 1);

				// adding values in my array

				// menu name and price
				System.out.println("Enter Name of the music: ");
				String name = null;
				try {
					name = br.readLine();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				obj.setName(name);

				System.out.println("Enter price: ");
				double price = 0;
				try {
					price = Double.parseDouble(br.readLine());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				obj.setPrice(price);

				System.out.println("Choose the type of music: 1 " + OptionsOfMusic.Rock + "2 " + OptionsOfMusic.Romance
						+ "3 " + OptionsOfMusic.Pop + "4 " + OptionsOfMusic.Classic);
				;
				int type = 0;
				try {
					type = Integer.parseInt(br.readLine());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (type == 1) {

					obj.setMusic(OptionsOfMusic.Rock);
				} else if (type == 2) {

					obj.setMusic(OptionsOfMusic.Romance);
				} else if (type == 3) {

					obj.setMusic(OptionsOfMusic.Pop);
				} else if (type == 4) {

					obj.setMusic(OptionsOfMusic.Classic);
				}

				arrayMusic.add(obj);
				System.out.println("Your data is saved successfully!");

			} else if (item == 2) {
				// only videossss

				// creating obj of my arrayMovie
				Movie obj = new Movie();

				// assigning values authomatically
				obj.setId(arrayMovie.size() + 1);

				// menu name and price
				System.out.println("Enter Name of the movie: ");
				String name = null;
				try {
					name = br.readLine();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				obj.setName(name);

				System.out.println("Enter price: ");
				double price = 0;
				try {
					price = Double.parseDouble(br.readLine());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				obj.setPrice(price);

//					Drama(1),
//					Commedy(2),
//					Action(3),
//					Fiction(4),
//					Horror(5);

				System.out.println("Choose the type of movie: 1 " + OptionsOfMovies.Drama + "2 "
						+ OptionsOfMovies.Commedy + "3 " + OptionsOfMovies.Action + "4 " + OptionsOfMovies.Fiction
						+ "5 " + OptionsOfMovies.Horror);
				;
				int type = 0;
				try {
					type = Integer.parseInt(br.readLine());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (type == 1) {

					obj.setMovie(OptionsOfMovies.Drama);
				} else if (type == 2) {

					obj.setMovie(OptionsOfMovies.Commedy);
				} else if (type == 3) {

					obj.setMovie(OptionsOfMovies.Action);
				} else if (type == 4) {

					obj.setMovie(OptionsOfMovies.Fiction);
				} else if (type == 5) {

					obj.setMovie(OptionsOfMovies.Horror);
				}

				arrayMovie.add(obj);
				System.out.println("Your data is saved successfully!");

//				ClassicConcert(1),
//				LiveShow(2),
//				Youtube(3);
			} else if (item == 3) {

				// creating obj of my arrayLiveConcertVideos
				LiveConcertVideos obj = new LiveConcertVideos();

				// assigning values authomatically
				obj.setId(arrayConcertVideos.size() + 1);

				// adding values in my array

				// menu name and price
				System.out.println("Enter Name of the concert ");
				String name = null;
				try {
					name = br.readLine();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				obj.setName(name);

				System.out.println("Enter price: ");
				double price = 0;
				try {
					price = Double.parseDouble(br.readLine());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				obj.setPrice(price);

				System.out.println("Choose the type of concert: 1 " + OptionsOfLiveConcertVideos.ClassicConcert + "2 "
						+ OptionsOfLiveConcertVideos.LiveShow + "3 " + OptionsOfLiveConcertVideos.Youtube);
				;
				int type = 0;
				try {
					type = Integer.parseInt(br.readLine());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (type == 1) {

					obj.setLive(OptionsOfLiveConcertVideos.ClassicConcert);
				} else if (type == 2) {

					obj.setLive(OptionsOfLiveConcertVideos.LiveShow);
				} else if (type == 3) {

					obj.setLive(OptionsOfLiveConcertVideos.Youtube);
				}
				arrayConcertVideos.add(obj);
				System.out.println("Your data is saved successfully!");

			} else if (item == 4) {

				// creating obj of my arrayBoxTvSet
				BoxTvSet obj = new BoxTvSet();

				// assigning values authomatically
				obj.setId(arrayConcertVideos.size() + 1);

				// adding values in my array

				// menu name and price
				System.out.println("Enter Name of the Box-Tv-Set: ");
				String name = null;
				try {
					name = br.readLine();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				obj.setName(name);

				System.out.println("Enter price: ");
				double price = 0;
				try {
					price = Double.parseDouble(br.readLine());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				obj.setPrice(price);

//					Culinary(1),
//					Talkshow(2),
//					VoiceShow(3),
//					SoupOpera(4),
//					Series(5);

				System.out.println("Choose the type of Box-Tv-Set: 1 " + OptionsOfTvBoxSet.Culinary + "2 "
						+ OptionsOfTvBoxSet.Talkshow + "3 " + OptionsOfTvBoxSet.VoiceShow + "4 "
						+ OptionsOfTvBoxSet.SoupOpera + "5" + OptionsOfTvBoxSet.Series);
				;
				int type = 0;
				try {
					type = Integer.parseInt(br.readLine());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if (type == 1) {

					obj.setBox(OptionsOfTvBoxSet.Culinary);
				} else if (type == 2) {

					obj.setBox(OptionsOfTvBoxSet.Talkshow);
				} else if (type == 3) {

					obj.setBox(OptionsOfTvBoxSet.VoiceShow);
				} else if (type == 4) {

					obj.setBox(OptionsOfTvBoxSet.SoupOpera);
				} else if (type == 5) {

					obj.setBox(OptionsOfTvBoxSet.Series);
				}
				arrayBoxTvSet.add(obj);
				System.out.println("Your data is saved successfully!");

			}

		} catch (Exception e) {
			System.out.println("Error " + e);
		}

	}

	private void update() {

		// show list of users registered

		for (int i = 0; i < arrayCustomer.size(); i++) {

			System.out.println("Code " + i + " Name " + this.arrayCustomer.get(i).getName() + "Address "
					+ this.arrayCustomer.get(i).getAddress() + "Phone " + this.arrayCustomer.get(i).getPhone() + "Card "
					+ this.arrayCustomer.get(i).getCardNumber());

		}

		// choose the user id
		int typeCode = 0;
		int field = 0;
		System.out.println("Which customer would you like to update? \n Type code: ");
		try {
			typeCode = Integer.parseInt(br.readLine());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		}
		// show field options

		System.out.println("Choose one field bellow: ");
		System.out.println("1 for Name");
		System.out.println("2 for Address");
		System.out.println("3 for Phone");
		System.out.println("4 for Card ");
		
		try {
			field = Integer.parseInt(br.readLine());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		}
		
		if(field == 1) {
			String name = null;
		
			System.out.println("Enter new Name: ");
			try {
				name = br.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}

			// input the value and replace the value
			this.arrayCustomer.get(typeCode).setName(name);
		
			
				
		}
		else if(field == 2) {
			String add = null;
		
			System.out.println("Enter new Address: ");
			try {
				add = br.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}

			// input the value and replace the value
			this.arrayCustomer.get(typeCode).setAddress(add);
		}
		else if(field == 3) {
			String add = null;
		
			System.out.println("Enter new Phone: ");
			try {
				add = br.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}

			// input the value and replace the value
			this.arrayCustomer.get(typeCode).setPhone(add);
		}
		else if(field == 4) {
			String add = null;
		
			System.out.println("Enter new Card: ");
			try {
				add = br.readLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}

			// input the value and replace the value
			this.arrayCustomer.get(typeCode).setCardNumber(add);
		}
		// shows up fresh data
				System.out.println("Code " + typeCode + " Name " + this.arrayCustomer.get(typeCode).getName() + " Address "
						+ this.arrayCustomer.get(typeCode).getAddress() + "Phone " + this.arrayCustomer.get(typeCode).getPhone() + "Card "
						+ this.arrayCustomer.get(typeCode).getCardNumber());
	}
}
