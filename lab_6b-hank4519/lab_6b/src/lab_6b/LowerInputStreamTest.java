package lab_6b;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class LowerInputStreamTest {

//	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new
			ByteArrayOutputStream();

	@org.junit.Test
	public void myTest() {
		System.setOut(new PrintStream(outputStreamCaptor));

		try {
			int c;
			InputStream input = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("info.txt")));

			while((c = input.read()) != -1) {
				System.out.print((char) c);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals("course name: csc 305", outputStreamCaptor.toString().trim());
	}

}
