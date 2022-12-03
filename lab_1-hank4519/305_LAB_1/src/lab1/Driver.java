package lab1;

public class Driver {
	
	  public static void main(String [] args )
	  {
	    Example ex = new Example("Hank", new int [] {1,2,3,4,5,6});
	    int total = 0;

	    for (int num: ex.getNums()) {
	    	total += num; 
	    }

	    System.out.println("The total sum is " + total);
	    System.out.println("Same name? " + ex.sameName("Eric"));
	  }
}
