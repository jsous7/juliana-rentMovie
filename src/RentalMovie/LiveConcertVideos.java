package RentalMovie;

import Enums.OptionsOfLiveConcertVideos;
import Enums.OptionsOfMovies;
import Enums.OptionsOfMusic;

public class LiveConcertVideos extends TitleDetails {

	private String name;
	private  double price;
	private OptionsOfLiveConcertVideos live;
	
 // Default constructor
  public LiveConcertVideos() {
	 setName(name);
	 setPrice(price);
	 
	}
  
  public static void cd()
  {
	  for(int i=0;i<count;i++)
	  {
		  System.out.println(dynamicStringArray[i]);
	  }
  }	  
  
  static int size=1;
static int count=0;

  static String dynamicStringArray[] = new String[size];
  	
	  public void addItem(String newItem) {
		  
		  if (count == size) {
	            doubleAndCopyArray();
	        }

	        dynamicStringArray[count] = newItem;

	        count++;
	    }
	  
	    private boolean isValidIndex(int i) {
	        if (i < 0 || i > count) {
	            return false;
	        }

	        return true;
	    }


	    public void addItem(int index, String item) {
	        if (!isValidIndex(index)) {
	            return;
	        }

	        if (count == size) {
	            doubleAndCopyArray();
	        }

	        String newArray[] = new String[dynamicStringArray.length];

	        for (int i=0; i <= count; i++) {
	            if (i < index) {
	                newArray[i] = dynamicStringArray[i];
	            } else if (i == index) {
	                newArray[i] = item;
	            } else {
	                newArray[i] = dynamicStringArray[i-1];
	            }
	        }

	        dynamicStringArray = newArray;
	        count++;
	    }
	    
	    private void doubleAndCopyArray() {
	        size = size * 2;
	        String newArray[] = new String[size];

	        for (int i = 0; i < dynamicStringArray.length; i++) {
	            newArray[i] = dynamicStringArray[i];
	        }

	        dynamicStringArray = newArray;
 }

  
  

public void setLive(OptionsOfLiveConcertVideos live) {
			this.live = live;
		}


		public void setPrice(double price) {
			this.price = price;
		}

public OptionsOfLiveConcertVideos getLive() {
	return live;
}

  
 
 }