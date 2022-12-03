package lab_3b;

public class SMSServiceInjector implements MessageServiceInjector{

	public Consumer getConsumer() { 
		return new MessagingApp(new SMSService()); 
	}
}
 