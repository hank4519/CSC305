package lab_3c;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


class ServiceTest {


	@Test
	void isAvailable() {
		Database database = Mockito.mock(Database.class); 
		when(database.isAvailable()).thenReturn(true); 
		Service service = new Service(database); 
		assertEquals(true, service.query("Hank")); 

	}
	
	@Test 
	void isNotAvailable() { 
		Database database = Mockito.mock(Database.class); 
		when(database.isAvailable()).thenReturn(false); 
		Service service = new Service(database); 
		assertEquals(false, service.query("Hank")); 
	}
	
	@Test 
	void mockUniqueId() { 
		Database database = Mockito.mock(Database.class); 
		when(database.getUniqueId()).thenReturn(13); 
		Service service = new Service(database); 
		assertEquals("Using database with id: 13", service.getDatabaseID()); 
	}

}

