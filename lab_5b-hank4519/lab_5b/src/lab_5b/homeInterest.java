package lab_5b;

public class homeInterest extends calculateInterest{

	public homeInterest(double principal, double annual_rate, int time) {
		super(principal, annual_rate, time);
	}

	@Override
	public double accept(InterestVisitor obj) {
		return obj.visit(this);
	}

}
