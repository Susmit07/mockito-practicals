package com.sapient.data.api;

import java.util.List;

public interface ServiceAPI {
	
	List<String> retrieveTodos(String user);

	void deleteTodo(String todo);

}
