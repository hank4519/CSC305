package lab_6a;

public class homeInterest extends calculateInterest{

	public homeInterest(double principal, double annual_rate, int time) {
		super(principal, annual_rate, time);
	}

	@Override
	double calculateInterest() {
		double interest = principal* Math.pow((1 + annual_rate / N), N * time); 
		return interest; 
	}

	@Override
	void display() {
		double interest = principal* Math.pow((1 + annual_rate / N), N * time); 
		System.out.println("Home Interest: " + interest);	
	}

	

}
