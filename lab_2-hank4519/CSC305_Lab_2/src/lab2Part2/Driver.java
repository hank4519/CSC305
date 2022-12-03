package lab2Part2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {
	
	private static void printPeople(List <Person> people) { 
		for (Person p: people) { 
			System.out.println(p.toString());
		}
	}
	
	private static List<Person> processFiles(String [] fileNames) throws IOException { 
		List <Person> people = new ArrayList<>(); 
		for (String file: fileNames) { 
			String json = new String(Files.readAllBytes(Paths.get(file)));
			ObjectMapper mapper = new ObjectMapper(); 
			Person person = mapper.readValue(json, Person.class); 
			people.add(person); 
		}
		return people; 
	}
	
	public static void main(String[] args) throws IOException {	
		String [] fileNames = new String[] {"input1.json", "input2.json", "input3.json"}; 
		List<Person> people = processFiles(fileNames); 
		printPeople(people);
		
	}
}
