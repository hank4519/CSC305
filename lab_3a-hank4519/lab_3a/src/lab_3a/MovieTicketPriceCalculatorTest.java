package lab_3a;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertEquals; 
import java.time.LocalTime; 

import org.junit.jupiter.api.Test;

class MovieTicketPriceCalculatorTest {
	private static final int STANDARD_PRICE_CENTS = 2700;
	private static final int MATINEE_PRICE_CENTS = 2400;
	private static final int SENIOR_DISCOUNT_CENTS = 400;
    private static final int CHILD_DISCOUNT_CENTS = 300;

	@Test
	void testNullStartTime() {
		LocalTime startTime = null; 
		LocalTime endTime =  LocalTime.of(10, 10, 10);  
		int maxChildAge = 18; 
		int minSeniorAge = 50;
		assertThrows(NullPointerException.class, ()-> new MovieTicketPriceCalculator(startTime, endTime, maxChildAge, minSeniorAge));
	}
	
	@Test
	void testNullEndTime() {
		LocalTime startTime = LocalTime.of(10, 10, 10); 
		LocalTime endTime = null; 
		int maxChildAge = 18; 
		int minSeniorAge = 50; 
		assertThrows(NullPointerException.class, ()-> new MovieTicketPriceCalculator(startTime, endTime, maxChildAge, minSeniorAge));
	}
	
	@Test 
	void testMaxChildAge() { 
		LocalTime startTime = LocalTime.of(8, 10, 23); 
		LocalTime endTime = LocalTime.of(10, 8, 20); 
		int maxChildAge = 18; 
		int minSeniorAge = 50; 
		MovieTicketPriceCalculator ticket =  new MovieTicketPriceCalculator(startTime, endTime, maxChildAge, minSeniorAge);
		assertEquals(ticket.getClass(), MovieTicketPriceCalculator.class); 
	}
	
	@Test 
	void testTimeConflict() { 
		LocalTime startTime = LocalTime.of(11, 10, 23); 
		LocalTime endTime = LocalTime.of(10, 8, 20); 
		int maxChildAge = 18; 
		int minSeniorAge = 50; 
		assertThrows(IllegalArgumentException.class, ()-> new MovieTicketPriceCalculator(startTime, endTime, maxChildAge, minSeniorAge));
	}
	
	@Test 
	void testSeniorDiscount() { 
		LocalTime startTime = LocalTime.of(8, 10, 23); 
		LocalTime endTime = LocalTime.of(10, 8, 20); int maxChildAge = 18; 
		int minSeniorAge = 50; 
		MovieTicketPriceCalculator ticket =  new MovieTicketPriceCalculator(startTime, endTime, maxChildAge, minSeniorAge);
		assertEquals(SENIOR_DISCOUNT_CENTS, ticket.computeDiscount(51)); 
	}
	
	@Test
	void testChildDiscount() { 
		LocalTime startTime = LocalTime.of(8, 10, 23); 
		LocalTime endTime = LocalTime.of(10, 8, 20); 
		int maxChildAge = 18; 
		int minSeniorAge = 50; 
		MovieTicketPriceCalculator ticket =  new MovieTicketPriceCalculator(startTime, endTime, maxChildAge, minSeniorAge);
		assertEquals(CHILD_DISCOUNT_CENTS, ticket.computeDiscount(17)); 
	}
	
	@Test 
	void testNoDiscount() { 
		LocalTime startTime = LocalTime.of(8, 10, 23); 
		LocalTime endTime = LocalTime.of(10, 8, 20); 
		int maxChildAge = 18; 
		int minSeniorAge = 50; 
		MovieTicketPriceCalculator ticket =  new MovieTicketPriceCalculator(startTime, endTime, maxChildAge, minSeniorAge);
		assertEquals(0, ticket.computeDiscount(25)); 
	} 
	
	@Test 
	void testComputePriceMatineeEqaulStartTime() { 
		LocalTime startTime = LocalTime.of(8, 10, 23); 
		LocalTime endTime = LocalTime.of(10, 8, 20); 
		int maxChildAge = 18; 
		int minSeniorAge = 50; 
		MovieTicketPriceCalculator ticket =  new MovieTicketPriceCalculator(startTime, endTime, maxChildAge, minSeniorAge);
		LocalTime scheduleTime = LocalTime.of(8, 10, 23); 
		int expectedPrice = MATINEE_PRICE_CENTS; 
		assertEquals(expectedPrice, ticket.computePrice(scheduleTime, 25)); 
	} 
	
	@Test 
	void testComputePriceMatineeAfterStartTime() { 
		LocalTime startTime = LocalTime.of(8, 10, 23); 
		LocalTime endTime = LocalTime.of(10, 8, 20); 
		int maxChildAge = 18; 
		int minSeniorAge = 50; 
		MovieTicketPriceCalculator ticket =  new MovieTicketPriceCalculator(startTime, endTime, maxChildAge, minSeniorAge);
		LocalTime scheduleTime = LocalTime.of(9, 10, 23); 
		int expectedPrice = MATINEE_PRICE_CENTS; 
		assertEquals(expectedPrice, ticket.computePrice(scheduleTime, 25)); 
	} 
	
	@Test 
	void testComputePriceMatineeBeforeStartTime() { 
		LocalTime startTime = LocalTime.of(8, 10, 23); 
		LocalTime endTime = LocalTime.of(10, 8, 20); 
		int maxChildAge = 18; 
		int minSeniorAge = 50; 
		MovieTicketPriceCalculator ticket =  new MovieTicketPriceCalculator(startTime, endTime, maxChildAge, minSeniorAge);
		LocalTime scheduleTime = LocalTime.of(7, 10, 23); 
		assertEquals(STANDARD_PRICE_CENTS, ticket.computePrice(scheduleTime, 25)); 
	} 
	
	@Test 
	void testComputePriceAfterEndTime () { 
		LocalTime startTime = LocalTime.of(8, 10, 23); 
		LocalTime endTime = LocalTime.of(10, 8, 20); 
		int maxChildAge = 18; 
		int minSeniorAge = 50; 
		MovieTicketPriceCalculator ticket =  new MovieTicketPriceCalculator(startTime, endTime, maxChildAge, minSeniorAge);
		LocalTime scheduleTime = LocalTime.of(11, 10, 23); 
		assertEquals(STANDARD_PRICE_CENTS, ticket.computePrice(scheduleTime, 25)); 
	}
	
}
	
