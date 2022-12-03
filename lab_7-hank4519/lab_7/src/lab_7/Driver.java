package lab_7;

public class Driver {
	public static void main(String[] args) {
		Document document = new Document(); 
		
		ReadCommand readCommand = new ReadCommand(document); 
		WriteCommand writeCommand = new WriteCommand(document); 
		
		Control control = new Control(); 
	
		document.clearFile();
		control.addCommand(readCommand);
		control.addCommand(writeCommand);
		System.out.println("History 1: ");
		control.printHistory(); 
		control.executeCommands();
		
		System.out.println("\n");
		
		document.clearFile();
		control.addCommand(writeCommand);
		control.addCommand(readCommand);
		System.out.println("History 2: ");
		control.printHistory();
		control.executeCommands(); 
	}
}
