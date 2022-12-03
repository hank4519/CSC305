package project_1;

import java.io.IOException;

public class Driver { 
	
	public static void main(String[] args) throws IOException {
		News news = Parsing.processFile("inputs/bad.json"); 
		News checkedNews = Parsing.checkErrors(news, Driver.class.getName()); 
		Parsing.printGoodArticles(checkedNews); 
	}
	
}
