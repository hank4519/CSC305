package lab_3b;

public class MessagingApp implements Consumer{

	/**
	 * The MessagingApp class can currently only send email messages using
	 * an EmailService object that can send email to a receiver email ID
	 */
	private MessageService service; 
	
	public MessagingApp(MessageService svc) { 
		this.service = svc; 
	}
		
	/**
     * Send email with message to receiver.
	 *
     * @param message message contained in the email (non-null)
     * @param receiver email address (non-null)
	 */	
	public void processMessages(String msg, String rec) {
		this.service.sendMessage(msg, rec); 
	}
}


