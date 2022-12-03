package lab_4a;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MultisetTest {
	private Multiset<String> testList; 
	
	@BeforeEach 
	void setUp() { 
		testList = new MyList<>();  
	}
	@Test
	void testAdd() { 
		int prevSize = testList.size(); 
		testList.add("Hank"); 
		assertEquals(prevSize + 1, testList.size()); 
	}
	
	@Test 
	void testRemove() { 
		testList.add("Hank"); 
		assertTrue(testList.remove("Hank")); 
	}
	
	@Test 
	void testRemoveFail() { 
		testList.add("Hank");
		assertFalse(testList.remove("Non-existing"));
	}
	
	@Test 
	void testSize() { 
		testList.add("Hank"); 
		assertEquals(1, testList.size()); 
	}

	@Test 
	void testCount() { 
		for (int i = 0; i < 3; i++ ) { 
			testList.add("Hank");
		}
		assertEquals(3, testList.count("Hank")); 
	}
	
	@Test 
	void testGrabEmpty() { 
		assertEquals(Optional.empty(), testList.grab()); 
	}
	@Test 
	void testGrab() { 
		testList.add("Hank"); 
		assertEquals(Optional.of("Hank"), testList.grab()); 
	}
}
