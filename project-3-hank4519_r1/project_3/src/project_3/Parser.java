package project_3;


public interface Parser {
	
	News process(String source) throws Exception; 
	void printArticles(News news); 
}
