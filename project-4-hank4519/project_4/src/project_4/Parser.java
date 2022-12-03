package project_4;

import java.io.IOException;
import java.util.List;

public interface Parser {
	
	void visit(String input) throws IOException; 
	List <Article> getArticles(); 
	
//	News process(String source) throws Exception; 
//	void printArticles(News news); 
}
