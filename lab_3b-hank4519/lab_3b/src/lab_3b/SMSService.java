package lab_3b;

public class SMSService implements MessageService{

	@Override
	public void sendMessage(String message, String receiver) {
		// TODO Auto-generated method stub
		System.out.println("SMS sent to "+receiver+ " with Message: "+message);
	}

}
