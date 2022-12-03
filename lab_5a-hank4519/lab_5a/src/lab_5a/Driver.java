package lab_5a;

public class Driver {
	public static void main(String[] args) {
			
		calculateInterest car = new carInterest(30000, 0.05, 10, new Fixed()); 
		calculateInterest home = new homeInterest(300000, 0.05, 10, new Compound()); 
		
		car.calculateIt(); 
		home.calculateIt();	
	}
}
