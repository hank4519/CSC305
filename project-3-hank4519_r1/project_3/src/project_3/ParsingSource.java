package project_3;

public class ParsingSource {
	private String source; 
	
	ParsingSource(String source){ 
		this.source = source; 
	}
	
	public String getSource() { 
		return source; 
	}
	
	public void accept (Visitor v) { 
		
	}
}
