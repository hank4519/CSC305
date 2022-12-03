package lab_5b;

public class Visitor implements InterestVisitor{

	@Override
	public double visit(carInterest car) {
		double interest = car.principal * (1 + car.annual_rate * car.time); 
		System.out.println("Car Interest: " + interest);
		return interest;
	}

	@Override
	public double visit(homeInterest home) {
		double interest = home.principal * Math.pow((1 + home.annual_rate / home.N), home.N * home.time); 
		System.out.println("Home Interest: " + interest);
		return interest; 
	}
	
}
