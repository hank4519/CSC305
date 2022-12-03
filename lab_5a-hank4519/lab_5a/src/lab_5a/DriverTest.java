package lab_5a;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DriverTest {
	
	@Test
	void testCar() {
		calculateInterest car = new carInterest(30000, 0.05, 10, new Fixed()); 
		double expected =  30000 * (1+ 0.05 * 10); 
		double actual = car.calculateIt();  
		assertEquals(expected, actual); 
		
	}
	
	@Test 
	void testHome() { 
		calculateInterest home = new homeInterest(300000, 0.05, 10, new Compound()); 
		double expected = 300000* Math.pow((1 + 0.05 / 12), 12 * 10); 
		double actual = home.calculateIt();  
		assertEquals(expected, actual);
	}

}
