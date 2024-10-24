import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		List<Integer> num = Arrays.asList(1, 2, 3, 5, 6, 3, 3, 6, 64, 4, 3, 2);
		// Filter
		List<Integer> result = num.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		// TaekWhile - Predicate True
		List<Integer> resultTakeWhile = num.stream().takeWhile(n -> n % 2 == 0).collect(Collectors.toList());
		// DropWhile - Predicate False
		List<Integer> resultDropWhile = num.stream().dropWhile(n -> n % 2 == 0).collect(Collectors.toList());
		System.out.println("Even Numbers: " + result);
		System.out.println("Even Numbers Take While: " + resultTakeWhile);
		System.out.println("Even Numbers Drop While: " + resultDropWhile);

		// Stream
		// Infinite Loop
//		Stream.iterate(1, x -> x + 1).forEach(System.out::println);

		Stream.iterate(1, x -> x + 1).limit(5).forEach(System.out::println);
		Stream.iterate(1, x -> x <= 5, x -> x + 1).forEach(System.out::println);

		// Nullable (Won't Go Within For Each)
		Stream<String> stream = Stream.ofNullable(null);
		stream.forEach(str -> System.out.println(str));

		Stream<String> stream_1 = Stream.ofNullable("Mayur Pai");
		stream_1.forEach(str -> System.out.println(str));

	}
}
