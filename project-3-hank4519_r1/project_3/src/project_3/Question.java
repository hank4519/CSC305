package project_3;

import java.util.Scanner; 

public class Question {
	
	/* 
	 * Purpose: Ask user's input on format and source
	 * @return A ParsingSource which could be either SimpleFile, NewsFile or NewsUrl
	 */
	public static ParsingSource askQuestion() { 
		Scanner scanner = new Scanner(System.in); 
		
		System.out.println("Enter Format: newsapi / simple");
		String format = scanner.nextLine(); 
		
		System.out.println("Enter Source: file / url "); 
		String source = scanner.nextLine(); 
		
		if (!format.equalsIgnoreCase("newsapi") && !format.equalsIgnoreCase("simple")) { 
			System.out.println("Format is invalid"); 
			scanner.close(); 
			return null;
		}
		
		if (!source.equalsIgnoreCase("file") && !source.equalsIgnoreCase("url")) { 
			System.out.println("Source is invalid");
			scanner.close(); 
			return null; 
		}
		
		String sourceInput = ""; 
		
		if(source.equalsIgnoreCase("file")) { 
			System.out.println("Enter the fileName");
			sourceInput = "inputs/" + scanner.nextLine(); 
		} else if (source.equalsIgnoreCase("url")) { 
			System.out.println("Enter the URL"); 
			sourceInput = scanner.nextLine(); 
		}
		
		if (format.equalsIgnoreCase("newsapi") && source.equalsIgnoreCase("file")) { 
			scanner.close(); 
			return new NewsFile(sourceInput); 
		} else if (format.equalsIgnoreCase("newsapi") && source.equalsIgnoreCase("url")) { 
			scanner.close(); 
			return new NewsUrl(sourceInput); 
		} else if (format.equalsIgnoreCase("simple") && source.equalsIgnoreCase("file")) { 
			scanner.close(); 
			return new SimpleFile(sourceInput); 
		} else if (format.equalsIgnoreCase("simple") && source.equalsIgnoreCase("url")) { 
			System.out.println("Simple Url is not supported");
			scanner.close(); 
			return null; 
		} else { 
			System.out.println("Encountered Invalid Input");
			scanner.close(); 
			return null; 
		}		
	}
	
	/*
	 * This is the partial code of the above function. And it is used to test the
	 * parsers created is consistent with the input configuration. 
	 * 
	 * @param format: String, source: String, sourceInput: String
	 * @return A ParsingSource that could be NewsFile, SimpleFile or NewsUrl
	 */
	public static ParsingSource askQuestion(String format, String source, String sourceInput) { 
		if (format.equalsIgnoreCase("newsapi") && source.equalsIgnoreCase("file")) { 	
			return new NewsFile(sourceInput); 
		} else if (format.equalsIgnoreCase("newsapi") && source.equalsIgnoreCase("url")) { 
			return new NewsUrl(sourceInput); 
		} else if (format.equalsIgnoreCase("simple") && source.equalsIgnoreCase("file")) { 
			return new SimpleFile(sourceInput); 
		} else if (format.equalsIgnoreCase("simple") && source.equalsIgnoreCase("url")) { 
//			System.out.println("Simple Url is not supported");
			return null; 
		} else { 
//			System.out.println("Encountered Invalid Input");
			return null; 
		}		
	}
	
}
