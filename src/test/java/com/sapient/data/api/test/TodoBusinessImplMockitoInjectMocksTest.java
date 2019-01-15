package com.sapient.data.api.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import static org.mockito.BDDMockito.given;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import static org.hamcrest.CoreMatchers.is;

import com.sapient.data.api.ServiceAPI;
import com.sapient.data.business.ServiceAPIImpl;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoInjectMocksTest {
	
	// Automatically creates a mock of this type and make it available. It works with MockitoJUnitRunner ONLY
	@Mock
	ServiceAPI serviceAPI;

	// Mockito will look on all the things present in the class ServiceAPIImpl. If it finds any match it will inject the mock.
	// ServiceAPIImpl will be created and serviceAPI will be injected
	@InjectMocks
	ServiceAPIImpl serviceAPIImpl;

	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;

	@Test
	public void usingMockito() {
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");

		when(serviceAPI.retrieveTodos("Susmit")).thenReturn(allTodos);

		List<String> todos = serviceAPIImpl
				.retrieveTodosRelatedToSpring("Susmit");
		assertEquals(3, todos.size());
	}

	@Test
	public void usingMockito_UsingBDD() {
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");

		//given
		given(serviceAPI.retrieveTodos("Susmit")).willReturn(allTodos);

		//when
		List<String> todos = serviceAPIImpl
				.retrieveTodosRelatedToSpring("Susmit");

		//then
		assertThat(todos.size(),is(3));
	}

	@Test
	public void letsTestDeleteNow() {

		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");

		when(serviceAPI.retrieveTodos("Susmit")).thenReturn(allTodos);

		serviceAPIImpl.deleteTodosNotRelatedToSpring("Susmit");

		verify(serviceAPI).deleteTodo("Learn to Dance");

		verify(serviceAPI, Mockito.never()).deleteTodo("Learn Spring MVC");

		verify(serviceAPI, Mockito.never()).deleteTodo("Learn Spring");

		verify(serviceAPI, Mockito.times(1)).deleteTodo("Learn to Dance");
		// atLeastOnce, atLeast

	}

	@Test
	public void captureArgument() {
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");
		Mockito.when(serviceAPI.retrieveTodos("Susmit")).thenReturn(allTodos);

		serviceAPIImpl.deleteTodosNotRelatedToSpring("Susmit");
		Mockito.verify(serviceAPI).deleteTodo(stringArgumentCaptor.capture());

		assertEquals("Learn to Dance", stringArgumentCaptor.getValue());
	}

}
