package lab_5b;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DriverTest {

	@Test
	void testCar() {
		Visitor v = new Visitor(); 
		carInterest car = new carInterest(30000, 0.05, 10); 
		double expected =  30000 * (1+ 0.05 * 10); 
		double actual = car.accept(v); 
		assertEquals(expected, actual); 
	}

	@Test 
	void testHome() { 
		Visitor v = new Visitor(); 
		homeInterest home = new homeInterest(300000, 0.05, 10); 
		double expected =  300000* Math.pow((1 + 0.05 / 12), 12 * 10);
		double actual = home.accept(v); 
		assertEquals(expected, actual); 
	}
}
