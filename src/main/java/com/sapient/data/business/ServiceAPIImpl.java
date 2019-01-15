package com.sapient.data.business;

import java.util.List;
import java.util.stream.Collectors;

import com.sapient.data.api.ServiceAPI;

public class ServiceAPIImpl {
	
	private ServiceAPI serviceAPI;

	public ServiceAPIImpl(ServiceAPI serviceAPI) {
		this.serviceAPI = serviceAPI;
	}

	public List<String> retrieveTodosRelatedToSpring(String user) {
		return serviceAPI.retrieveTodos(user).stream().map(String::toString).collect(Collectors.toList());
	}

	public void deleteTodosNotRelatedToSpring(String user) {
		List<String> allTodos = serviceAPI.retrieveTodos(user);
		for (String todo : allTodos) {
			if (!todo.contains("Spring")) {
				serviceAPI.deleteTodo(todo);
			}
		}
	}
}
