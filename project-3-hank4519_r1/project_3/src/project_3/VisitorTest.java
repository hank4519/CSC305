package project_3;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/*
 * This testing class is to validate that the set 
 * of parsers created is consistent with the input configuration
 */
class VisitorTest {

	/* 
	 * Test user input with simple format and File source 
	 * expect a SimpleFile object to be returned 
	 */
	@Test
	void testSimpleFile() {
		String format = "simple"; 
		String source = "file"; 
		String sourceInput = "inputs/simple.txt"; 
		ParsingSource parserSource = Question.askQuestion(format, source, sourceInput); 
		assertTrue(parserSource instanceof SimpleFile); 
	}

	/* 
	 * Test user input with newsapi format and File source 
	 * expect a NewsFile object to be returned 
	 */
	@Test
	void testNewsFile() {
		String format = "newsapi"; 
		String source = "file"; 
		String sourceInput = "inputs/newsapi.txt"; 
		ParsingSource parserSource = Question.askQuestion(format, source, sourceInput); 
		assertTrue(parserSource instanceof NewsFile); 
	}
	
	/* 
	 * Test user input with newsapi format and Url source 
	 * expect a NewsUrl object to be returned 
	 */
	@Test
	void testNewsUrl() {
		String format = "newsapi"; 
		String source = "url"; 
		String sourceInput = "https://newsapi.org/v2/top-headlines?country=us&apiKey=15a282145dca4e0c933ce03f16e6997c"; 
		ParsingSource parserSource = Question.askQuestion(format, source, sourceInput); 
		assertTrue(parserSource instanceof NewsUrl); 
	}
	
	/* 
	 * Test user input with Simple format and Url source 
	 * This combination is currently unsupported: expect a null return value 
	 */
	@Test
	void testUrlSimple() {
		String format = "simple"; 
		String source = "url"; 
		String sourceInput = "https://newsapi.org/v2/top-headlines?country=us&apiKey=15a282145dca4e0c933ce03f16e6197c"; 
		ParsingSource parserSource = Question.askQuestion(format, source, sourceInput); 
		assertTrue(parserSource == null); 
	}
	
	/* 
	 * Test user's invalid inputs on format and source 
	 * Expect a null value to be returned 
	 */
	@Test 
	void testInvalidFormatAndSource() { 
		String format = "invalid"; 
		String source = "random"; 
		String sourceInput = "whatever"; 
		ParsingSource parserSource = Question.askQuestion(format, source, sourceInput); 
		assertTrue(parserSource == null); 
	}
}
