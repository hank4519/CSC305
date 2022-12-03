package project_3;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Source {
	private String id; 
	private String name;
	
	@JsonCreator
	private Source(@JsonProperty("id") String id, 
			@JsonProperty("name") String name) { 
		this.id = id; 
		this.name = name;  
	}
	public String toString(){ 
		StringBuilder sb = new StringBuilder(); 
		sb.append("id = " + id + "\n"); 
		sb.append("name = " + name + "\n"); 
		return sb.toString(); 
	}
}
