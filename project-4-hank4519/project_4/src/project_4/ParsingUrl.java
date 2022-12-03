package project_4;

import java.net.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.net.MalformedURLException;
import java.util.List;

public class ParsingUrl implements Parser{
	
	News news = null; 
	/*
	 *  This method processes the an actual URL that retrieved 
	 * 	from the News API  
	 *  
	 *  @param source: the URL of the news API  
	 *  @return a News object 
	 */
	public News process(String source) throws IOException { 
		String input = readFromUrl(source); 	
		ObjectMapper mapper = new ObjectMapper(); 
		News news = mapper.readValue(input, News.class); 
		return news;
	}

	/*
	 * Implementation of toString in Parser interface that is specific to 
	 * JSON in the News API URL
	 * 
	 * @param news: a News Object 
	 */	
	public String toString() {
		StringBuilder str = new StringBuilder(); 
		str.append("======================================\n"); 
		str.append("Parsing URL NewsApi Articles\n");
		str.append("======================================\n"); 
		for (Article article: this.news.getArticles()) { 
			str.append(article.toString() + "\n"); 
		}
		str.append("\n\n"); 
		return str.toString(); 
	}	

	/* Implements the visit Parser interface method
	 * calls the process method and update the news object accordingly 
	 * 
	 * @param 	input 	String input of pasring source: URL 
	 * @return 
	 */
	@Override
	public void visit(String input) throws IOException {
		News news = process(input); 
		this.news = news; 
	}

	/* 
	 * Returns the list of articles if were parsed 
	 * 
	 * @param	
	 * @return	List<article> 	if news was parsed 
	 * 			null			if news was not parsed 
	 */
	@Override
	public List<Article> getArticles() {
		if (news != null) { 
			return news.getArticles(); 
		} else {
			return null;
		}
	}
	
	
	private String readFromUrl(String source) throws IOException{ 
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
