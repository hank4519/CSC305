package lab_5b;

public class Driver {
	public static void main(String[] args) {
		Visitor v = new Visitor(); 
		carInterest car = new carInterest(30000, 0.05, 10); 
		car.accept(v); 
		
		homeInterest home = new homeInterest(300000, 0.05, 10); 
		home.accept(v);
	}
}
