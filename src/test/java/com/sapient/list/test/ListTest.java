package com.sapient.list.test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;


public class ListTest {

	@SuppressWarnings("unchecked")
	@Test
	public void testList() {
		
		List<String> listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);
		assertEquals(2, listMock.size());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void letsMockListSizeWithMultipleReturnValues() {
		List<Integer> list = mock(List.class);
		when(list.size()).thenReturn(10).thenReturn(20);
		assertEquals(10, list.size()); // First Call
		assertEquals(20, list.size()); // Second Call
	}

	@SuppressWarnings("unchecked")
	@Test
	public void letsMockListGet() {
		List<String> list = mock(List.class);
		when(list.get(0)).thenReturn("SUSMIT");
		assertEquals("SUSMIT", list.get(0));
		assertNull(list.get(1));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void letsMockListGetWithAny() {
		List<String> list = mock(List.class);
		when(list.get(Mockito.anyInt())).thenReturn("SUSMIT");
		// If you are using argument matchers, all arguments
		// have to be provided by matchers.
		assertEquals("SUSMIT", list.get(0));
		assertEquals("SUSMIT", list.get(1));
	}
}
