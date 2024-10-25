package com.features;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) throws IOException {
//		localVaraibleTypeInference();
//		stringUtilityMethods();
//		streamingHTTPServer();
		collectionToAnArray();
	}

	// Local Variable Type Inference
	public static void localVaraibleTypeInference() {
		/*
		 * Error Scenarios It cannot be used for member variables, methods and return
		 * types.
		 * 
		 */
		var emptyList = null;
		System.out.println("Empty List: " + emptyList);

		var p = (String s) -> s.length > 10;
		System.out.println("p: " + p);

		var arr = { 1, 2, 3 };
		System.out.println("arr: " + arr);

	}

	public static void stringUtilityMethods() {
		boolean flag_1 = " ".isBlank();
		boolean flag_2 = " ".isEmpty(); // This Checks The Length
		System.out.println(flag_1);
		System.out.println(flag_2);

		String name = "Mayur /n Pai";
		Stream<String> stream = name.lines();
		stream.forEach(System.out::println);
		System.out.println(name.split("\n"));

		String sentence = "I Am The Best                     ";
		System.out.println(sentence.strip());
		System.out.println(sentence.stripTrailing());

		String repeat = "=".repeat(2);
		System.out.println(repeat);
	}

	public static void streamingHTTPServer() throws IOException {
		String file = Files
				.readString(Paths.get("C:\\Users\\mbantwal\\Java Training\\StreamAPIEnhancements\\src\\Main.java"));
		System.out.println(file);
		Path filePath_1 = Paths.get("C:\\Users\\mbantwal\\Java Training\\StreamAPIEnhancements\\src\\Main.java");
		Path filePath_2 = Paths.get(
				"C:\\Users\\mbantwal\\Java Training\\Memory Management\\src\\com\\memory_management\\Student.java");
		Path filePath_3 = Paths.get(
				"C:\\Users\\mbantwal\\Java Training\\Memory Management\\src\\com\\memory_management\\Student2.java");

		// Checked Only Path And Not Content
		System.out.println(Files.isSameFile(filePath_1, filePath_2));
		// Checks The Content
		System.out.println(Files.mismatch(filePath_2, filePath_3));
	}

	public static void collectionToAnArray() {
		List<String> sampleList = Arrays.asList("React", "Java");
		Object[] stringList = sampleList.toArray();

		for (Object item : stringList) {
			System.out.println(item);
		}
	}

}
