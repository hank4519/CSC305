package lab_7;

public class ReadCommand implements Command{
	
	private Document document; 
	
	public ReadCommand(Document document) { 
		this.document = document; 
	}
	
	public void execute() { 
		document.readFile();
	}
}
