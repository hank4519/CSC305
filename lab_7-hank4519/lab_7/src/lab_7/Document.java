package lab_7; 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class Document {

	/**
	 * document filename from which to read from and write into
	 */
	public static final String filename="text.txt";
	
	/**
	 * reads content from the file and displays to the terminal
	 */
	void readFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String st; 
			while((st = br.readLine()) != null) { 
				System.out.println(st);
			} 
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
    }
	
	/**
	 * writes the String "CSE 305, Cal Poly" into the file
	 */
	void writeFile() {
		final String toWrite = "CSE305, Cal Poly"; 
		try {
			FileWriter fWriter = new FileWriter(filename);
			fWriter.write(toWrite); 
			fWriter.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	void clearFile() { 
		try {
			FileWriter fWriter = new FileWriter(filename);
			fWriter.write(""); 
			fWriter.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
}
