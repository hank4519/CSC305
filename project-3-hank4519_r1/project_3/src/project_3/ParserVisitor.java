package project_3;

public class ParserVisitor implements Visitor{
	
	/* 
	 * This visit method parses a file with simple format 
	 * @param SimpleFile 
	 * @return 
	 */
	@Override
	public void visit(SimpleFile simpleFile) {
		ParsingSimple parser = new ParsingSimple();  
		try {
			News parsed = parser.process(simpleFile.getSource());
			parser.printArticles(parsed);
		} catch (Exception e) {	
			e.printStackTrace();
		} 
	}

	/* 
	 * This visit method parses a file with newsapi format 
	 * @param NewsFile 
	 * @return 
	 */
	@Override
	public void visit(NewsFile newsFile) {
		ParsingNews parser = new ParsingNews(); 
		try { 
			News parsed = parser.process(newsFile.getSource()); 
			parser.printArticles(parsed); 
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}

	/* 
	 * This visit method pares an URL with newsapi format 
	 * @param NewsUrl 
	 * @return 
	 */
	@Override
	public void visit(NewsUrl newsUrl) {
		ParsingUrl parser = new ParsingUrl(); 
		try { 
			News parsed = parser.process(newsUrl.getSource()); 
			parser.printArticles(parsed);
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}



}
