package lab_5b;


public interface InterestVisitor {

	public double visit(carInterest car);
	public double visit(homeInterest home);
}
