package lab_7;

import java.util.ArrayList;
import java.util.List;

public class Control {
	
	private List<Command> processList = new ArrayList<Command>(); 
	
	public void addCommand(Command command) { 
		processList.add(command); 
	}
	
	public void executeCommands() { 	
		for (Command command: processList) { 
			command.execute(); 
		}
		processList.clear(); 
	}
	
	public void printHistory() { 
		for (Command command: processList) { 
			System.out.println(command.getClass());
		}
	}
	
	public void reverseExecute() { 
		for (int i = processList.size() - 1; i>= 0; i--) { 
			processList.get(i).execute(); 
		}
	}
}
