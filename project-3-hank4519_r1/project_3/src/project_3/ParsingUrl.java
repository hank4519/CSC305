package project_3;

import java.net.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.net.MalformedURLException;

public class ParsingUrl implements Parser{
	
	/*
	 *  This method processes the an actual URL that retrieved 
	 * 	from the News API  
	 *  
	 *  @param source: the URL of the news API  
	 *  @return a News object 
	 */
	@Override
	public News process(String source) throws Exception { 
		String input = readFromUrl(source); 	
		ObjectMapper mapper = new ObjectMapper(); 
		News news = mapper.readValue(input, News.class); 
		return news;
	}

	/*
	 * Implementation of printArticles in Parser interface that is specific to 
	 * JSON in the News API URL
	 * 
	 * @param news: a News Object 
	 */	
	@Override
	public void printArticles(News news) {
		System.out.println("======================================");
		System.out.println("Parsing URL NewsApi Articles");
		System.out.println("======================================");
		for (Article a: news.getArticles()) { 
			System.out.println(a.toString()); 
		}
		System.out.println("\n\n");
	}
	
	
	private String readFromUrl(String source) throws Exception{ 
		StringBuilder content = new StringBuilder(); 
		try { 
			URL url = new URL(source); 
			URLConnection connection = url.openConnection(); 
		    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		    String line; 
		    while ( (line = bufferedReader.readLine()) != null) { 
		    	content.append(line + "\n"); 
		    }
		    bufferedReader.close(); 
		} catch (Exception e) { 
			throw new MalformedURLException(); 
		}
		return content.toString(); 
	}

}
