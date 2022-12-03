package project_3;

public class NewsFile extends ParsingSource implements Visitable{

	NewsFile(String source) {
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
