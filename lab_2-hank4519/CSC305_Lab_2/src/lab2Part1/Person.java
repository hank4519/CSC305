package lab2Part1;

import java.util.List; 

class Person {
	private String name; 
	private List <String> knownFor; 
	private List <Award> award; 
	
	Person(String name, List <String> knownFor, List <Award> award) { 
		this.name = name; 
		this.knownFor = knownFor; 
		this.award = award; 
	}
	 
	public String toString() { 
		StringBuilder str = new StringBuilder(); 
		str.append("Name: " + name + "\n"); 
		str.append("Awards: \n");
		for (Award a: award) {
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
