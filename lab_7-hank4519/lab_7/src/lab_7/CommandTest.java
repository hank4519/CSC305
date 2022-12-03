package lab_7;

import static org.junit.Assert.assertEquals;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommandTest {

	private final ByteArrayOutputStream outputStreamCaptor = new
			ByteArrayOutputStream();
	private Document document; 
	private Control control; 
	private ReadCommand readCommand; 
	private WriteCommand writeCommand; 

	@BeforeEach 
	void setUp() { 
		document = new Document(); 
		control = new Control(); 
		readCommand = new ReadCommand(document); 
		writeCommand = new WriteCommand(document); 
		document.clearFile();
	}
	
	@Test
	void testReadWrite() {
		System.setOut(new PrintStream(outputStreamCaptor));
		control.addCommand(readCommand);
		control.addCommand(writeCommand);
		control.executeCommands();
		assertEquals("", outputStreamCaptor.toString().trim());
	}

	@Test 
	void testWriteRead() { 
		System.setOut(new PrintStream(outputStreamCaptor));
		control.addCommand(writeCommand);
		control.addCommand(readCommand);
		control.executeCommands();
		assertEquals("CSE305, Cal Poly", outputStreamCaptor.toString().trim());
	}
	
	@Test 
	void testReadWriteRead() { 
		System.setOut(new PrintStream(outputStreamCaptor));
		control.addCommand(readCommand);
		control.addCommand(writeCommand);
		control.addCommand(readCommand);
		control.executeCommands();
		assertEquals("CSE305, Cal Poly", outputStreamCaptor.toString().trim());
	}
	
	@Test 
	void testReverse() { 
		System.setOut(new PrintStream(outputStreamCaptor));
		control.addCommand(readCommand);
		control.addCommand(writeCommand);
		control.reverseExecute();
		assertEquals("CSE305, Cal Poly", outputStreamCaptor.toString().trim());
	}
}
