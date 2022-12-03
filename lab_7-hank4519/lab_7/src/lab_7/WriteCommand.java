package lab_7;

public class WriteCommand implements Command{

	private Document document; 
	
	public WriteCommand(Document document) { 
		this.document = document; 
	}
	
	public void execute() { 
		document.writeFile();
	}
}
