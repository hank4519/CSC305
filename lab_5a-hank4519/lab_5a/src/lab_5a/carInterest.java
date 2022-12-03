package lab_5a;

public class carInterest extends calculateInterest {

	public carInterest(double principal, double annual_rate, int time, InterestBehabior behavior) {
		super(principal, annual_rate, time, behavior );
		
	}

	@Override
	double displayInterest() {
		double interest = principal* (1+annual_rate*time); 
		System.out.println("Car Interest: " + interest);
		return interest; 
	}

}
