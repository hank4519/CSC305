package lab_6b;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LowerCaseInputStream extends FilterInputStream{
	 
	public LowerCaseInputStream(InputStream in) {
		super(in);
	}
	
	/*
	 * We should override the read method from FilterInputStream t 
	 * o take a byte and convert each byte (that represents a character) 
	 * to lowercase if it is an uppercase character.
	 */
	public int read() throws IOException {
		int convert = in.read(); 
		if (convert == -1) { 
			return -1; 
		}
		return Character.toLowerCase((char)convert);
	}
	
}
