package lab_5a;

public class homeInterest extends calculateInterest {

	public homeInterest(double principal, double annual_rate, int time, InterestBehabior behavior ) {
		super(principal, annual_rate, time, behavior);	
	}

	@Override
	double displayInterest() {
		double interest = principal* Math.pow((1 + annual_rate / N), N * time); 
		System.out.println("Home Interest: " + interest);
		return interest; 
	}

}
