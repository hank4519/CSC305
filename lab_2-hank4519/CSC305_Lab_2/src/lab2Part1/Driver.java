package lab2Part1;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList; 
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONArray;


public class Driver {
	
	private static List<Person> processFiles (String[] fileNames) throws FileNotFoundException { 
		List <Person> people = new ArrayList<>(); 
		for (String file: fileNames) { 
			InputStream i1 = new FileInputStream(file); 
			try {
				JSONTokener jt1 = new JSONTokener(i1);
				JSONObject o1 = new JSONObject(jt1); 
				JSONArray jr1Award = o1.getJSONArray("awards"); 
				JSONArray jr1KnownFor = o1.getJSONArray("knownFor");
				List<Award> awards = new ArrayList<>(); 
				for (int i = 0; i < jr1Award.length(); i++ ) { 
					JSONObject tmp = jr1Award.getJSONObject(i); 
					String name = tmp.getString("name"); 
					int year = tmp.getInt("year"); 
					Award award = new Award(name, year); 
					awards.add(award); 
				}
				List <String> knownFor = new ArrayList<>(); 
				for (int i = 0; i < jr1KnownFor.length(); i++ ) { 
					String tmp = jr1KnownFor.getString(i); 
					knownFor.add(tmp); 
				}
				people.add(new Person(o1.getString("name"), knownFor, awards)); 
				
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return people; 
	}
	
	private static void printPeople(List <Person> people) { 
		for (Person p: people) { 
			System.out.println(p.toString());
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		String [] fileNames = new String[] {"input1.json", "input2.json", "input3.json"}; 
		List<Person> people = processFiles(fileNames); 
		printPeople(people); 
		
	}
}
