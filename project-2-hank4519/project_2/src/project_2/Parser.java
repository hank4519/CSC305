package project_2;


public interface Parser {
	
	News process(String source) throws Exception; 
	void printArticles(News news); 
}
