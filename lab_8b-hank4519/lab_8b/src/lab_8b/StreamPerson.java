package lab_8b;

import java.util.stream.Stream;
import lab_8b.Person.GENDER;
import java.util.stream.Collectors;
import java.util.*;

public class StreamPerson {

	/**
	 * Prints details of all members
	 * @param streamofPerson a stream of all members
	 */
	static void printAllMembers(Stream<Person> streamOfPerson) {
		streamOfPerson.forEach(person -> person.printPerson());
	}
	
	/**
	 * Stores age of all members
	 * @param streamofPerson a stream of all members
	 * @return List of ages of all members
	 */
	static List<Integer> ageAllMembers(Stream<Person> streamOfPerson) {
		return streamOfPerson.map(person -> person.getAge())
				.collect(Collectors.toList());
	}	
	
	/** 
	 * Stores the name of all members
	 * @param streamofPerson a stream of all members
	 * @return List of names of all members
	 */
	static List<String> nameAllMembers(Stream<Person> streamOfPerson) {
		return streamOfPerson.map(person -> person.getName())
				.collect(Collectors.toList());
	}
	
	/**
	 * Prints name of all members above age 35
	 * @param streamofPerson a stream of all members
	 */
	static void nameAgeAbove35(Stream<Person> streamofPerson) {
		streamofPerson.filter(person -> person.getAge() > 35)
		 .forEach(person -> System.out.println(person.getName()));
	}
	
	/**
	 * Calculates average age of all members
	 * @param streamofPerson a stream of all members
	 * @param count the total number of members
	 * @return the average age of all members 
	 */
	static double avgAgeAllMembers (Stream<Person> streamofPerson, long count) {	
		return (double) streamofPerson.map(person -> person.getAge())
				.reduce(0, (a,b) -> a + b) / count;
	}
	
	/**
	 * Prints email ID of members between age of 18 and 35 
	 * @param streamofPerson a stream of all members
	 */
	static void emailSelectmembers (Stream<Person> streamofPerson) {
		streamofPerson.filter(person -> (person.getAge() >= 18 && person.getAge() <= 35))
		 .forEach(person -> System.out.println(person.getEmailAddress()));
	}
	
	
	public static void main(String[] args) {
		Person[] arrayOfMembers = {
				new Person("Michael", 45, GENDER.MALE, "michael@dundermifflin.com"),
				new Person("Dwight", 37, GENDER.MALE, "dwight@dundermifflin.com"),
				new Person("Pam", 28, GENDER.FEMALE, "pam@dundermifflin.com"),
				new Person("Jim", 32, GENDER.MALE, "jim@dundermifflin.com"),
				new Person("Angela", 35, GENDER.FEMALE, "angela@dundermifflin.com"),
				new Person("Creed", 65, GENDER.MALE, "creed@dundermifflin.com"),
				new Person("Erin", 22, GENDER.FEMALE, "erin@dundermifflin.com")
		};
		
		/*
		 * Use the 6 methods defined above in main() to process arrayOfMembers
		 * Note that you can use streams only once
		 */
		
		printAllMembers(Stream.of(arrayOfMembers));
		
		System.out.println("\nAll Ages:" + ageAllMembers(Stream.of(arrayOfMembers)).toString());
		
		System.out.println("\nAll Names:" + nameAllMembers(Stream.of(arrayOfMembers)).toString());
		
		System.out.println("\nAverage Age: " + avgAgeAllMembers(Stream.of(arrayOfMembers), arrayOfMembers.length));
		
		System.out.println("\nAbove 35: ");
		nameAgeAbove35(Stream.of(arrayOfMembers));
		
		System.out.println("\nEmail between 18 and 35: ");
		emailSelectmembers(Stream.of(arrayOfMembers));
	}
		
}
