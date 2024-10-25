import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
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

		// Immutable - Hence Will Throw An Error
		List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
//		list.add(7);
		System.out.println(list);

		Set<Integer> set = Set.of(1, 2, 34, 56);
//		set.add(23);
		System.out.println(set);

		Map<Integer, String> map = Map.of(1, "Mayur", 2, "Pai");
//		map.put(3, "B H");
		System.out.println(map);

		List<Integer> arrayList = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			arrayList.add(i);
		}
		System.out.println(arrayList.stream().filter(x -> x <= 2).collect(Collectors.toUnmodifiableList()));

		Optional<Integer> op_1 = Optional.of(1234);
		Optional<Integer> op_2 = Optional.empty();
		Optional<Integer> op_3 = Optional.ofNullable(null);

		System.out.println("Optional: " + op_1.orElseThrow(ArithmeticException::new));
//		System.out.println("Optional: " + op_2.orElseThrow(ArithmeticException::new));
//		System.out.println("Optional: " + op_3.orElseThrow(NullPointerException::new));

	}
}
