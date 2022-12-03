package project_3;

public interface Visitor {
	public void visit(SimpleFile simpleFile); 
	public void visit(NewsFile newsFile); 
	public void visit(NewsUrl newsUrl); 
}
