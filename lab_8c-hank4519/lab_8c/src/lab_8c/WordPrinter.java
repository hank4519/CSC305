package lab_8c;

public class WordPrinter implements Runnable {

	private String print;
	private int count;

	public WordPrinter(String print, int count) {
		this.print = print; 
		this.count = count; 
	}

	@Override
	public void run() {
		for (int i = 0; i < count; i++)
			System.out.println(print + "(" + (i + 1) + ")");
	}

}
