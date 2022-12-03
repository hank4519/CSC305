package lab_8c;

public class SimpleThreadExample {
	  private static final int MAX_TIMES = 100;

	  /**
	   * Demonstration of the use of Threads.
	   *
	   * @param args command-line arguments, not used
	   */
	  public static void main(String[] args) {
	    new Thread(new WordPrinter("Hank", MAX_TIMES)).start();
	    new Thread(new WordPrinter("Tsai", MAX_TIMES)).start(); 
	  }
	}