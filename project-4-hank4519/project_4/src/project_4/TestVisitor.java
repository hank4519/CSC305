package project_4;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class TestVisitor {

	/* 
	 * Tests if ParsingNews parser is created by providing FILE and NEWSAPI as input
	 * @param 
	 * @return 
	 */
	@Test
	void testParsingNews() throws IOException {
		ChooseInput formats = new ChooseInput(ChooseSource.FILE, ChooseFormat.NEWSAPI); 
		Parser parser = formats.accept("inputs/newsapi.txt");
		assertTrue(parser instanceof ParsingNews); 
	}
	
	/* 
	 * Tests if ParsingSimple parser is created by providing FILE and SIMPLE as input
	 * @param 
	 * @return 
	 */
	@Test 
	void testParsingSimple() throws IOException { 
		ChooseInput formats = new ChooseInput(ChooseSource.FILE, ChooseFormat.SIMPLE); 
		Parser parser= formats.accept("inputs/simple.txt"); 
		assertTrue(parser instanceof ParsingSimple); 
	}
	
	/* 
	 * Tests if ParsingUrl parser is created by providing URL and NEWSAPI as input
	 * @param 
	 * @return 
	 */
	@Test 
	void testUrlNews() throws IOException { 
		ChooseInput formats = new ChooseInput(ChooseSource.URL, ChooseFormat.NEWSAPI); 
		Parser parser = formats.accept("https://newsapi.org/v2/top-headlines?country=us&apiKey=15a282145dca4e0c933ce03f16e6997c"); 
		assertTrue(parser instanceof ParsingUrl); 
	}

}
