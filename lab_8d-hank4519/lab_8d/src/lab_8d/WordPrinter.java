package lab_8d;

import java.util.concurrent.Semaphore;

class WordPrinter implements Runnable {

	int count;
	String print;
	Semaphore first;
	Semaphore second;

	public WordPrinter(String print, int count, Semaphore first, Semaphore second) {	
		this.print = print; 
		this.count = count;
		this.first = first;
		this.second = second;
	}

	@Override
	public void run() {

		if (this.print.equals("hello")) {
			try {
				for (int i = 0; i < count; i++) {
					first.acquire();
					System.out.println(print);
					second.release();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} 

		if (this.print.equals("hi")) {
			try {
				for (int i = 0; i < count; i++) {
					second.acquire();
					System.out.println(print);
					first.release();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}