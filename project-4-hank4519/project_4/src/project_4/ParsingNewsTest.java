package project_4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/* 
 * This testing class tests ParsingNews parser 
 */
class ParsingNewsTest {
	
	private static final int example_size = 20; 
	private static final int bad_size = 20;
	private static ParsingNews parser;
	
	@BeforeEach
	void setup() { 
		parser = new ParsingNews(); 
	}
	
	/*
	 * Test for the size of parsed news 
	 */
	@Test
	void processExample() throws Exception {
		News news = parser.processRaw("inputs/example.json");
		assertEquals(example_size, news.getArticles().size()); 
	}
	
	/*
	 *  Test for the size of parsed news (bad) 
	 */
	@Test 
	void processBad () throws Exception { 
		News news = parser.processRaw("inputs/bad.json"); 
		assertEquals(bad_size, news.getArticles().size()); 
	}
	
	/* 
	 * Test for the bad article checking functionality 
	 */
	@Test 
	void checkNonNullArticles() throws Exception { 
		News news = parser.processRaw("inputs/input1.json"); 
		News checkedNews = parser.process("inputs/input1.json"); 
		assertTrue(news.getArticles().size() == checkedNews.getArticles().size()); 
	}
	
	/*
	 * Check bad article is taken out if title is null 
	 */
	@Test 
	void checkNullTitle() throws Exception { 
		News news = parser.processRaw("inputs/input2.json"); 
		News checkedNews = parser.process("inputs/input2.json");  
		assertTrue(!news.equals(checkedNews)); 
		assertTrue(news.getArticles().size() - 1 == checkedNews.getArticles().size());
	}
	
	/* 
	 * Check bad article is taken out if Description is null 
	 */
	@Test
	void checkNullDescription() throws Exception { 
		News news = parser.processRaw("inputs/input3.json"); 
		News checkedNews = parser.process("inputs/input3.json"); 
		assertTrue(!news.equals(checkedNews));
		assertTrue(news.getArticles().size() - 1 == checkedNews.getArticles().size());
	}
	
	/* 
	 *  Check bad article is taken out if time is null 
	 */
	@Test 
	void checkNullTime() throws Exception { 
		News news = parser.processRaw("inputs/input4.json"); 
		News checkedNews = parser.process("inputs/input4.json"); 
		assertTrue(!news.equals(checkedNews));
		assertTrue(news.getArticles().size() - 1 == checkedNews.getArticles().size());
	}
	
	/* 
	 * Check bad article is taken out if url is null 
	 */
	@Test 
	void checkNullUrl() throws Exception { 
		News news = parser.processRaw("inputs/input5.json"); 
		News checkedNews = parser.process("inputs/input5.json"); 
		assertTrue(!news.equals(checkedNews)); 
		assertTrue(news.getArticles().size() - 1 == checkedNews.getArticles().size());
	}
	
	/*
	 * Test the correctness of title when filter option is on 
	 * @param
	 * @return 
	 */
	@Test 
	void checkTitleWithFilter() throws Exception { 
		ChooseInput formats = new ChooseInput(ChooseSource.FILE, ChooseFormat.NEWSAPI, ChooseChannel.CNBC); 
		Parser parser = formats.accept("inputs/newsapi.txt");
		assertTrue("Ever Given, the massive cargo ship that ran aground in the Suez Canal, is still stuck - CNBC"
				.equals(parser.getArticles().get(0).getTitle())); 
	}
	

	/*
	 * Test the correctness of description when filter option is on 
	 * @param 
	 * @return 
	 */
	@Test 
	void checkDescriptionWithFilter() throws Exception { 
		ChooseInput formats = new ChooseInput(ChooseSource.FILE, ChooseFormat.NEWSAPI, ChooseChannel.CNBC); 
		Parser parser = formats.accept("inputs/newsapi.txt");
		assertTrue("The Ever Given, which become lodged in the Suez Canal, is still stuck, halting traffic in one of the world's busiest waterways."
					.equals(parser.getArticles().get(0).getDescription())); 
	}
	
	/*
	 * Test the correctness of the published date when the filter option is on 
	 * @param 
	 * @return 
	 */
	@Test 
	void checkPublishedAtWithFilter() throws Exception { 
		ChooseInput formats = new ChooseInput(ChooseSource.FILE, ChooseFormat.NEWSAPI, ChooseChannel.CNBC); 
		Parser parser = formats.accept("inputs/newsapi.txt");
		assertTrue("2021-03-24T21:39:00Z".equals(parser.getArticles().get(0).getPublishedAt())); 
	}
	
	/*
	 * Test the correctness of the URL filtering CNBC
	 * @param 
	 * @return 
	 */
	@Test 
	void checkUrlWithFilter() throws Exception { 
		ChooseInput formats = new ChooseInput(ChooseSource.FILE, ChooseFormat.NEWSAPI, ChooseChannel.CNBC); 
		Parser parser = formats.accept("inputs/newsapi.txt");
		assertTrue("https://www.cnbc.com/2021/03/24/ever-given-a-massive-cargo-ship-is-still-stuck-in-the-suez-canal.html"
					.equals(parser.getArticles().get(0).getUrl())); 
	}
	
	/* 
	 * Test the filtered list size, check if articles are properly filtered
	 * @param 
	 * @return 
	 */
	@Test 
	void checkExpectedSizeWithFilter() throws Exception { 
		ChooseInput formats = new ChooseInput(ChooseSource.FILE, ChooseFormat.NEWSAPI, ChooseChannel.CNBC); 
		Parser parser = formats.accept("inputs/newsapi.txt");
		assertEquals(parser.getArticles().size(), 2); 
	}
	
	
}
