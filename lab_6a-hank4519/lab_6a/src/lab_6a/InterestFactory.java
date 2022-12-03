package lab_6a;

public class InterestFactory {
	public calculateInterest getInterest(String interestType, double principal, double annual_rate, int time) { 
		if( interestType.equalsIgnoreCase("carInterest")) { 
			return new carInterest(principal, annual_rate, time); 
		} else if ( interestType.equalsIgnoreCase("homeInterest")) { 
			return new homeInterest(principal, annual_rate, time); 
		} else { 
			System.out.println("No matching Interest Type"); 
			return null; 
		}
	}
}
