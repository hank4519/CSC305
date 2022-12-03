package lab_8a;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


class TestFunction{
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Test
	void testSquare() {
		System.setOut(new PrintStream(outContent));

		Consumer<Integer> displaySquare = (number) -> System.out.println(number * number);
		displaySquare.accept(2);

		assertEquals("4", outContent.toString().trim());
	}
	
	@Test
	void testNegative() {
		Predicate<Integer> isNegative = (number) -> number < 0;

		assertTrue(isNegative.test(-2));
	}
	
	@Test
	void testNegative2() {
		Predicate<Integer> isNegative = (number) -> number < 0;

		assertFalse(isNegative.test(2));
	}

	@Test
	void testSquareRoot() {
		System.setOut(new PrintStream(outContent));
		Consumer<Integer> displaySquareRoot = (number) -> System.out.println(Math.sqrt(number));
		displaySquareRoot.accept(4);
		assertEquals("2.0", outContent.toString().trim());
	}


}
