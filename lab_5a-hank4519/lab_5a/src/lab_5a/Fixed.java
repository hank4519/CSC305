package lab_5a;

public class Fixed implements InterestBehabior{

	@Override
	public double calculateInterest(calculateInterest obj) {
		double interest = obj.principal * (1 + obj.annual_rate * obj.time); 
		System.out.println("Car Interest: " + interest);
		return interest; 
	} 

}
