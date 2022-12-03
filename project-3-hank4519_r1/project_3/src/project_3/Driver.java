package project_3;

public class Driver { 
	
	public static void main(String[] args) throws Exception {	
		
		// Example of User-Interaction to specify format and source
		/*
		ParserVisitor visitor = new ParserVisitor(); 
		
		ParsingSource source = Question.askQuestion(); 
		
		if (source != null) { 
			source.accept(visitor);
		}
		*/
		
		
		//Demo 
		ParserVisitor visitor = new ParserVisitor(); 
		ParsingSource newsFile = new NewsFile("inputs/newsapi.txt"); 
		newsFile.accept(visitor); 
		
		ParsingSource simpleFile = new SimpleFile("inputs/simple.txt"); 
		simpleFile.accept(visitor);
		
		ParsingSource newsUrl = new NewsUrl("https://newsapi.org/v2/top-headlines?country=us&apiKey=15a282145dca4e0c933ce03f16e6997c");
		newsUrl.accept(visitor); 
		
	}
	
}


/*
ParsingNews pn = new ParsingNews(); 
News news1 = pn.process("inputs/newsapi.txt"); 
pn.printArticles(news1); 

ParsingSimple ps = new ParsingSimple(); 
News news2 = ps.process("inputs/simple.txt"); 
ps.printArticles(news2); 

ParsingUrl pr = new ParsingUrl(); 
News news3 = pr.process("https://newsapi.org/v2/top-headlines?country=us&apiKey=15a282145dca4e0c933ce03f16e6997c"); 
pr.printArticles(news3); 

*/ 