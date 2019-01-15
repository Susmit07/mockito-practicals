package com.sapient.powermock;

public class UtilityClass {

	 public static int staticMethod(long value) {
		// Some complex logic is done here...
		throw new RuntimeException(
				"Static Method Mocked!!");
	}
}
