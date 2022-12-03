package lab_3b;

import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach; 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test; 
import java.io.ByteArrayOutputStream; 

import static org.junit.Assert.assertEquals;

class TestMessagingAppTest {
	private final PrintStream standardOut = System.out; 
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream(); 
	
	@BeforeEach
	public void setUp() { 
		System.setOut(new PrintStream(outputStreamCaptor));
	}
	@AfterEach 
	public void tearDown() { 
		System.setOut(standardOut);
	}
	
	@Test
	void testMessageEmail() {
		MessageServiceInjector injector = null;
		Consumer app = null;
		
		injector = new EmailServiceInjector(); 
		app = injector.getConsumer(); 
		app.processMessages("Hi John", "john@abc.com"); 
		
		assertEquals("Email sent to john@abc.com with Message: Hi John", outputStreamCaptor.toString().trim()); 
	}
	
	@Test 
	void testMessageSMS() { 
		MessageServiceInjector injector = null; 
		injector = new SMSServiceInjector(); 
		injector.getConsumer().processMessages("Hi John", "12345678"); 
		
		assertEquals("SMS sent to 12345678 with Message: Hi John", outputStreamCaptor.toString().trim()); 
	}

}
