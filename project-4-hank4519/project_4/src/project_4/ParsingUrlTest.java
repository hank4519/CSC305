package project_4;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

 /* 
  * This testing class tests parsingUrl parser 
  */
class ParsingUrlTest { 
	private static final int expectedSize = 20;
	private static final int totalResult = 29; 
	private static final String status = "ok"; 
	private static final String validUrl = "https://newsapi.org/v2/top-headlines?country=us&apiKey=15a282145dca4e0c933ce03f16e6997c";
	private static final String invalidUrl = "Malformed Url"; 
	private static ParsingUrl parser; 
	
	@BeforeEach
	void setUp() { 
		parser = new ParsingUrl(); 
	}
	
	/* 
	 * This tests a valid URL where it contains proper formatted JSON
	 */
	@Test 
	void testValidUrl() throws Exception { 
		News news = parser.process(validUrl);
		assertTrue(expectedSize == news.getArticles().size());
		//assertTrue(totalResult == news.getTotalResults()); 	
		assertTrue(status.equals(news.getStatus())); 
	}
	
	/* 
	 * This tests an invalid URL where it throws an exception
	 */
	@Test
	void testInValidUrl() {
		assertThrows(Exception.class, () -> parser.process(invalidUrl));
	}
	
	/*
	 * Tests the size of the filtered article list. Checking filtering feature
	 * @param 
	 * @return 
	 */
	@Test 
	void testValidUrlWithFilter() throws IOException {
		ChooseInput formats = new ChooseInput(ChooseSource.URL, ChooseFormat.NEWSAPI, ChooseChannel.CNN); 
		Parser parser = formats.accept(validUrl);
		System.out.println(parser.toString());
		assertEquals(parser.getArticles().size(), 2); 
	}
	
}
