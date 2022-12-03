package lab_8d;

import java.util.concurrent.Semaphore;

public class AlternatingThreadExample {

	  private static final int MAX_TIMES = 100;

	  /**
	   * Demonstration of the use of a Semaphore.
	   *
	   * @param args command-line arguments, not used
	   */
	  public static void main(String[] args) {
		  
	    Semaphore availableSemaphore = new Semaphore(1, false);
	    Semaphore unavailableSemaphore = new Semaphore(0, false);
	    

//	    new Thread(new WordPrinter("hello", MAX_TIMES,
//	      availableSemaphore, unavailableSemaphore)).start();
//	    new Thread(new WordPrinter("hi", MAX_TIMES,
//	       unavailableSemaphore, availableSemaphore)).start();
	    
	    WordPrinter wordPrinter1 = new WordPrinter("hello", MAX_TIMES, availableSemaphore, unavailableSemaphore);
		WordPrinter wordPrinter2 = new WordPrinter("hi", MAX_TIMES, availableSemaphore, unavailableSemaphore);

		new Thread(wordPrinter1).start();
		new Thread(wordPrinter2).start() ;
	  }
}
