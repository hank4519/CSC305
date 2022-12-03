package lab2Part2;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class Person {
	private String name; 
	private List <String> knownFor; 
	private List <Award> awards; 
	
	@JsonCreator
	private Person(@JsonProperty("name") String name, 
			@JsonProperty("knownFor") List <String> knownFor, 
			@JsonProperty("awards") List <Award> awards) { 
		this.name = name; 
		this.knownFor = knownFor; 
		this.awards = awards; 
	}
	
	public String toString() { 
		StringBuilder str = new StringBuilder(); 
		str.append("Name: " + name + "\n"); 
		str.append("Awards: \n"); 
		for(Award a: awards) { 
			str.append(a.toString()); 
		}
		str.append("KnowFor: \n"); 
		for (String k: knownFor) { 
			str.append("    " + k + "\n");
		}
		str.append("\n\n"); 
		return str.toString();
	}
}