package lab2Part1;

class Award {
	private String name; 
	private int year; 
	Award(String name, int year) { 
		this.name = name; 
		this.year = year; 
	}
	public String toString() { 
		return "    " + name + " at year " + year + "\n"; 
	}
}
