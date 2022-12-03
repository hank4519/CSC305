package project_3;

public class NewsUrl extends ParsingSource implements Visitable{

	NewsUrl(String source) {
		super(source);
	}
	
	/* 
	 * Implements Visitable interface 
	 * @param A Visitor
	 */
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
