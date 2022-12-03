package project_1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.fasterxml.jackson.databind.ObjectMapper;

class Parsing {
	
	private static Logger getLogger(String loggerName) throws SecurityException, IOException { 
		FileHandler fh = new FileHandler("null_article.txt");
		Logger logger = Logger.getLogger(loggerName); 
		SimpleFormatter formatter = new SimpleFormatter(); 
		fh.setFormatter(formatter);
		logger.setLevel(Level.WARNING);
		logger.setUseParentHandlers(false); 
		logger.addHandler(fh);
		return logger; 
	}
	static void printGoodArticles(News news) { 
		for (Article article: news.getArticles()) { 
			System.out.println(article.toString() + "\n");
		}
	}
	static News checkErrors(News news, String loggerName) { 	
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
	
	static News processFile(String filename) throws IOException {
		ObjectMapper mapper = new ObjectMapper(); 
		return mapper.readValue(new File(filename), News.class); 
	}
}
