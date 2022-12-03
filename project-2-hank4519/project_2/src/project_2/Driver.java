package project_2;

public class Driver { 
	
	public static void main(String[] args) throws Exception {
		
		// News input file 
		ParsingNews pn = new ParsingNews(); 
		News news1 = pn.process("inputs/newsapi.txt"); 
		pn.printArticles(news1); 
		
		// Simple input file
		ParsingSimple ps = new ParsingSimple(); 
		News news2 = ps.process("inputs/simple.txt"); 
		ps.printArticles(news2); 
		
		// News API URL
		ParsingUrl pr = new ParsingUrl(); 
		News news3 = pr.process("https://newsapi.org/v2/top-headlines?country=us&apiKey=15a282145dca4e0c933ce03f16e6997c"); 
		pr.printArticles(news3); 
		
	}
	
}
