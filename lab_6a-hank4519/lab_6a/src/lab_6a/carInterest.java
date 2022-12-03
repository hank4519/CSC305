package lab_6a;


public class carInterest extends calculateInterest{

	public carInterest(double principal, double annual_rate, int time) {
		super(principal, annual_rate, time);
	}

	@Override
	double calculateInterest() {
		double interest = principal* (1+annual_rate*time); 	
		return interest; 
	}

	@Override
	void display() {
		double interest = principal* (1+annual_rate*time); 
		System.out.println("Car Interest: " + interest);
	}	
	
}
