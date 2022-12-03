package project_4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ParsingSimple implements Parser{
	Simple simple = null; 
	/*
	 *  This method processes the simple formatted JSON that 
	 *  contains only title, description, publishedAt, and URL 
	 *  
	 *  @param source: name of the input file
	 *  @return a News object 
	 */
	public News process(String source) throws IOException {
		ObjectMapper mapper = new ObjectMapper(); 
		Article simpleAr = mapper.readValue(new File(source), Article.class); 
		List <Article> list = new ArrayList<>(); 
		list.add(simpleAr); 
		return new Simple(list); 
	}

	/*
	 * Implementation of toString in Parser interface that is specific to 
	 * simple formatted file JSON
	 * 
	 * @param news: a News Object 
	 */
	public String toString() { 
		StringBuilder str = new StringBuilder(); 
		str.append("======================================\n"); 
		str.append("Parsing Simple Article\n"); 
		str.append("======================================\n");
		for (Article a: simple.getArticles()) {
			str.append(a.toString()); 
		}
		str.append("\n\n"); 
		return str.toString(); 
	}

	/*
	 * Implements the Parser interface visit method to parse Simple File 
	 * and updates the local variable of Simple
	 * 
	 * @param	input	String input of the simple file name 
	 * @return 	
	 */
	@Override
	public void visit(String input) throws IOException {
		News processed = process(input); 
		this.simple = new Simple(processed.getArticles()); 
		
	}

	/*
	 * Returns a list of parsed articles 
	 * 
	 * @param 
	 * @return 	a list of articles		if it was parsed 
	 * 			null					if it was not parsed 
	 */
	@Override
	public List<Article> getArticles() {
		if (this.simple != null) { 
			return simple.getArticles(); 
		} else {
			return null; 
		}
	}

}
