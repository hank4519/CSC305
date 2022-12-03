package lab_8a;

import java.util.function.Consumer; 
import java.util.function.Predicate;

public class BasicIntegerOperations{
	
	public static void main(String[] args) {
		Integer num = 10;
        /*
         * 
		displaySquare(num, <Lambda Expression>));
		
	    if(! (isNegative(num, <Lambda Expression>)) {
			System.out.println("Square root of "+num+": "+squareRoot(num, <Lambda Expression>));	
		}
		*/			
		
		Consumer<Integer> displaySquare = (number) -> System.out.println(number * number);
		displaySquare.accept(num);
		
		Predicate<Integer> isNegative = (number) -> number < 0;
		System.out.println(isNegative.test(num));
		
		Consumer<Integer> squareRoot = (number) -> System.out.println(Math.sqrt(number));
		squareRoot.accept(num);
	}
}
