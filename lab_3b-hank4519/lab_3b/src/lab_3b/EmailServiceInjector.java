package lab_3b;

public class EmailServiceInjector implements MessageServiceInjector{

	public Consumer getConsumer() {
		return new MessagingApp(new EmailService()); 
	}
}
