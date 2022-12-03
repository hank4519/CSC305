package project_4;

import java.io.IOException;
import java.util.List; 

class NewsApiDecorator extends ParserDecorator{
	ChooseChannel channel; 
	
	public NewsApiDecorator(Parser parser, ChooseChannel channel) { 
		super.parser = parser; 
		this.channel = channel; 
	}
	
	/*
	 * NewsApiDecorator decorates the Parser
	 * This visit method calls visit using the super object and retrived parsed articles 
	 * 
	 * @param 	input 	String that is used to parse JSON. Usually File or URL
	 * @return 
	 */
	public void visit(String input) throws IOException { 
		super.parser.visit(input);
		List<Article> articles = super.parser.getArticles(); 
		filterArticle(articles); 
		
	}
	
	/*
	 * filterArticle filters articles that is not speficied by the channel 
	 * For example, if user specifies CNN, it filters out all the sources that are not CNN 
	 * 
	 *  @param	articles	a List of articles to be filtered 
	 *  @return 
	 */
	public void filterArticle(List <Article> articles) { 
		for (int i = articles.size() - 1; i >= 0; i--) { 
			String sourceName = articles.get(i).getSource().getName(); 
			if (!(sourceName.equals(this.channel.toString()))) {
				articles.remove(i); 
			}
		}
	}
}
