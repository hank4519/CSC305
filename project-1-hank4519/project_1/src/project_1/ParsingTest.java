package project_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class ParsingTest {
	
	private static final int example_size = 20; 
	private static final int bad_size = 20;
	
	@Test
	void processExample() throws IOException {
		News news = Parsing.processFile("inputs/example.json");
		assertEquals(example_size, news.getArticles().size()); 
	}
	
	@Test 
	void processBad () throws IOException { 
		News news = Parsing.processFile("inputs/bad.json"); 
		assertEquals(bad_size, news.getArticles().size()); 
	}
	
	@Test 
	void checkNonNullArticles() throws IOException { 
		News news = Parsing.processFile("inputs/input1.json"); 
		News checkedNews = Parsing.checkErrors(news, ParsingTest.class.getName()); 
		assertTrue(news.getArticles().size() == checkedNews.getArticles().size()
				&& news.equals(checkedNews)); 
	}
	
	@Test 
	void checkNullTitle() throws IOException { 
		News news = Parsing.processFile("inputs/input2.json"); 
		News checkedNews = Parsing.checkErrors(news, ParsingTest.class.getName()); 
		assertTrue(!news.equals(checkedNews)
				&& news.getArticles().size() - 1 == checkedNews.getArticles().size());
	}
	
	@Test
	void checkNullDescription() throws IOException { 
		News news = Parsing.processFile("inputs/input3.json"); 
		News checkedNews = Parsing.checkErrors(news, ParsingTest.class.getName()); 
		assertTrue(!news.equals(checkedNews)
				&& news.getArticles().size() - 1 == checkedNews.getArticles().size());
	}
	
	@Test 
	void checkNullTime() throws IOException { 
		News news = Parsing.processFile("inputs/input4.json"); 
		News checkedNews = Parsing.checkErrors(news, ParsingTest.class.getName()); 
		assertTrue(!news.equals(checkedNews)
				&& news.getArticles().size() - 1 == checkedNews.getArticles().size());
	}
	
	@Test 
	void checkNullUrl() throws IOException { 
		News news = Parsing.processFile("inputs/input5.json"); 
		News checkedNews = Parsing.checkErrors(news, ParsingTest.class.getName()); 
		assertTrue(!news.equals(checkedNews)
				&& news.getArticles().size() - 1 == checkedNews.getArticles().size());
	}
	
	
}
