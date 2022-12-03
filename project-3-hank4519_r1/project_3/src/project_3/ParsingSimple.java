package project_3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ParsingSimple implements Parser{

	/*
	 *  This method processes the simple formatted JSON that 
	 *  contains only title, description, publishedAt, and URL 
	 *  
	 *  @param source: name of the input file
	 *  @return a News object 
	 */
	@Override
	public News process(String source) throws Exception {
		ObjectMapper mapper = new ObjectMapper(); 
		Article simple = mapper.readValue(new File(source), Article.class); 
		List <Article> list = new ArrayList<>(); 
		list.add(simple); 
		return new Simple(list); 
	}

	/*
	 * Implementation of printArticles in Parser interface that is specific to 
	 * simple formatted file JSON
	 * 
	 * @param news: a News Object 
	 */
	@Override
	public void printArticles(News news) { 
		System.out.println("======================================");
		System.out.println("Parsing Simple Article");
		System.out.println("======================================");
		for (Article a: news.getArticles()) { 
			System.out.println(a.toString()); 
		}
		System.out.println("\n\n");
	}

}
