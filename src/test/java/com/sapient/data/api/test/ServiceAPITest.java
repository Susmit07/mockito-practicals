package com.sapient.data.api.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.sapient.data.api.ServiceAPI;
import com.sapient.data.business.ServiceAPIImpl;

public class ServiceAPITest {
	
	@Test
	public void usingMockito() {
		ServiceAPI serviceAPI = mock(ServiceAPI.class);
		List<String> allServiceAPI = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");
		when(serviceAPI.retrieveTodos("Susmit")).thenReturn(allServiceAPI);
		ServiceAPIImpl serviceAPIImpl = new ServiceAPIImpl(serviceAPI);
		List<String> todos = serviceAPIImpl
				.retrieveTodosRelatedToSpring("Susmit");
		assertEquals(3, todos.size());
	}

}
