package lab_6a;

public class Driver {
	public static void main(String[] args) {
		InterestFactory interestFactory = new InterestFactory(); 
		
		calculateInterest car = interestFactory.getInterest("carInterest", 30000, 0.05, 10); 
		car.display();
		
		calculateInterest home = interestFactory.getInterest("homeInterest", 300000, 0.05, 10); 
		home.display();
	}
}
