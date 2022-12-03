package lab_5b;


public class carInterest extends calculateInterest{

	public carInterest(double principal, double annual_rate, int time) {
		super(principal, annual_rate, time);
	}

	@Override
	public double accept(InterestVisitor obj) {
		return obj.visit(this);
	}

}
