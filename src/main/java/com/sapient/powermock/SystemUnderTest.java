package com.sapient.powermock;

import java.util.ArrayList;
import java.util.List;

	public class SystemUnderTest {

		private Dependency dependency;
		
		public SystemUnderTest(Dependency dependency) {
			this.dependency = dependency;
		}

		@SuppressWarnings("rawtypes")
		public int methodUsingAnArrayListConstructor() {
			ArrayList list = new ArrayList();
			return list.size();
		}

		public int methodCallingAStaticMethod() {
			//privateMethodUnderTest calls static method SomeClass.staticMethod
			List<Integer> stats = dependency.retrieveAllStats();
			long sum = 0;
			for (int stat : stats)
				sum += stat;
			return UtilityClass.staticMethod(sum);
		}
		
		@SuppressWarnings("unused")
		private long privateMethodUnderTest() {
			return dependency.retrieveAllStats().stream().mapToLong(Long::valueOf).reduce(0, Long::sum);
		}
	}

