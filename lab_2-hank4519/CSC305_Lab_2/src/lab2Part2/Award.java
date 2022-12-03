package lab2Part2;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class Award {
	private String name; 
	private int year; 
	
	@JsonCreator
    private Award(@JsonProperty("name") String name, 
			@JsonProperty("year") int year) { 
		this.name = name; 
		this.year = year; 
	}
	
	public String toString() {
		return "    " + name + " at year " + year + "\n"; 
	}
}