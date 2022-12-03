package lab_3b;

public class TestMessagingApp {
	
	public static void main(String[] args) {
		MessageServiceInjector injector = null;
		Consumer app = null; 
		
		injector = new EmailServiceInjector(); 
		app = injector.getConsumer(); 
		app.processMessages("Hi John", "john@abc.com"); 
		
		injector = new SMSServiceInjector(); 
		app = injector.getConsumer(); 
		app.processMessages("Hi John", "9168177134");
	}

}