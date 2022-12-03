package project_3;

public class SimpleFile extends ParsingSource implements Visitable{

	SimpleFile(String source) {
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
