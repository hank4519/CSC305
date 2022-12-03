package lab_5a;

public class Compound implements InterestBehabior{

	@Override
	public double calculateInterest(calculateInterest obj) {
		double interest = obj.principal * Math.pow((1 + obj.annual_rate / calculateInterest.N), calculateInterest.N * obj.time); 
		System.out.println("Home Interest: " + interest);
		return interest; 
	}

}
