package project_3;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/* 
 * This testing class tests ParsingSimple parser 
 */
class ParsingSimpleTest {
	
	private static ParsingSimple parser;
	private static final String description = "Extend Assignment #1 to support multiple sources and to introduce source processor."; 
	private static final String publishedAt = "2021-04-16 09:53:23.709229";
	private static final String title = "Assignment #2"; 
	private static final String url = "https://canvas.calpoly.edu/courses/55411/assignments/274503"; 
	
	@BeforeEach 
	void setUp() { 
		parser = new ParsingSimple(); 
	}
	
	/*
	 * Test simple parser by checking parsed description, time, title and url 
	 */
	@Test
	void testGoodSimple() throws Exception {
		News news = parser.process("inputs/simple.txt"); 
		Article article = news.getArticles().get(0); 
		assertTrue(article.getDescription().equals(description)); 
		assertTrue(article.getPublishedAt().equals(publishedAt)); 
		assertTrue(article.getTitle().equals(title)); 
		assertTrue(article.getUrl().equals(url)); 
		}	
}
