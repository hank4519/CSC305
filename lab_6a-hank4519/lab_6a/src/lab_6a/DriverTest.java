package lab_6a;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DriverTest {
	
	private InterestFactory interestFactory; 
	
	@BeforeEach 
	public void setUp() { 
		interestFactory = new InterestFactory(); 
	}
	
	@Test
	public void testCar() { 
		double expected =  30000 * (1+ 0.05 * 10); 
		calculateInterest car = interestFactory.getInterest("carInterest", 30000, 0.05, 10); 
		double actual = car.calculateInterest();
		assertTrue(expected == actual); 
	}
	
	@Test 
	public void testHome() { 
		double expected =  300000* Math.pow((1 + 0.05 / 12), 12 * 10);
		calculateInterest home = interestFactory.getInterest("homeInterest", 300000, 0.05, 10); 
		double actual = home.calculateInterest(); 
		assertTrue(expected == actual); 
	}
}
