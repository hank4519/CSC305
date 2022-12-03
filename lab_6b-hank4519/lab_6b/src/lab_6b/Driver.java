package lab_6b;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;

public class Driver {
	public static void main(String[] args) {
		
		try (FilterInputStream stream = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("info.txt")))) { 
			int c; 
			while ((c = stream.read()) != -1) { 
				System.out.print((char)c);
			}
		} catch(Exception e) { 
			e.printStackTrace();
		}
	}
}
