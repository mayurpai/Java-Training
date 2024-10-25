package com.memory_management;

public class Example {
	public void startAnalysis() {
		System.out.println("Hello!");
		long heapSize = Runtime.getRuntime().totalMemory();
		long maxHeapSize = Runtime.getRuntime().maxMemory();
		long freeHeapSize = Runtime.getRuntime().freeMemory();

		System.out.println("Inital Heap Size (Total): " + heapSize);
		System.out.println("Maximum Heap Size: " + maxHeapSize);
		System.out.println("Free Heap Size: " + freeHeapSize);

		int[] largeArray = new int[1000000];
		int count = 100;
		recursiveMethod(count);
		System.out.println("After Allocation - Free Heap Size: " + Runtime.getRuntime().freeMemory());
	}

	public static void recursiveMethod(int count) {
		Integer id = 1;
		String name = "Mayur";
		Student student = new Student(id, name);
		try {
			if (count != 0) {
				System.out.println("Recursion Depth: " + count);
				recursiveMethod(count - 1);
			}
		} catch (StackOverflowError e) {
			throw e;
		}
	}
}
