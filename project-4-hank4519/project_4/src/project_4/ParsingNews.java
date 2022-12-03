package project_4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.fasterxml.jackson.databind.ObjectMapper;

class ParsingNews implements Parser{
	
	News news = null; 
	/*
	 * This method checks if either of the four attributes is null 
	 * and takes out bad articles that contains null filed from the original list
	 * 
	 * @param News object, loggerName: name of the logger 
	 * @return News if no exception is caught. Null if exception is caught 
	 */
	News checkErrors(News news, String loggerName) { 	
		Logger logger;
		try {
			logger = getLogger(loggerName);
			List <Article> goodArticles = new ArrayList<>(); 
			for(Article article: news.getArticles()) {
				if(article.getTitle() == null || article.getDescription() == null 
						|| article.getPublishedAt() == null || article.getUrl() == null) { 
					logger.warning("\n" + article.toString()); 
				} else {
					goodArticles.add(article); 
				}
			}
			News checkedNews = new News(news.getStatus(), news.getTotalResults(), goodArticles); 
			return checkedNews;
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
		return null; 
	}
	
	/* 
	 * This method returns News without checking potential bad articles. 
	 * Used primarily for testing.
	 * 
	 * @param filename: the input file name 
	 * @return the News object
	 */
	public News processRaw(String filename) throws Exception { 
		ObjectMapper mapper = new ObjectMapper(); 
		return mapper.readValue(new File(filename), News.class); 
	}
	
	/*
	 * Implementation of toString in Parser interface that is specific to File Json
	 * 
	 * @param news: a News Object 
	 */
	public String toString() {
		StringBuilder str = new StringBuilder(); 
		str.append("======================================\n"); 
		str.append("Parsing NewsApi File Articles\n"); 
		str.append("======================================\n"); 
		for (Article article: this.news.getArticles()) { 
			str.append(article.toString() + "\n"); 
		}
		str.append("\n\n");
		return str.toString(); 
	}
	
	/* 
	 * Use Jackson to process JSON file input 
	 * 
	 * @param source String filename 
	 * @return return processed news that contains only good articles
	 */
	public News process(String source) throws IOException {
		ObjectMapper mapper = new ObjectMapper(); 
		News news = mapper.readValue(new File(source), News.class); 
		News checkedNews = checkErrors(news, ParsingNews.class.getName());
		return checkedNews; 
	}
	
	private Logger getLogger(String loggerName) throws SecurityException, IOException { 
		FileHandler fh = new FileHandler("null_article.txt");
		Logger logger = Logger.getLogger(loggerName); 
		SimpleFormatter formatter = new SimpleFormatter(); 
		fh.setFormatter(formatter);
		logger.setLevel(Level.WARNING);
		logger.setUseParentHandlers(false); 
		logger.addHandler(fh);
		return logger; 
	}

	/*
	 * Provide implementation for Parser interface visit method 
	 * It calls process method and sets the News object with the processed News 
	 * 
	 * @param	input	String input that is used for parsing: File name, URL 
	 * @return 
	 */
	@Override
	public void visit(String input) throws IOException {
		News processed = process(input); 
		this.news = processed; 
		//this.articles.addAll(processed.getArticles()); 
		
	}

	/*
	 * Returns the article list from the processed News 
	 * 
	 * @param 
	 * @return	a list of articles	if the News was parsed 
	 * 			null 				if no News was parsed
	 */
	@Override
	public List<Article> getArticles() {
		if (this.news != null) { 
			return this.news.getArticles(); 
		} else {
			return null;
		}
	}
}
