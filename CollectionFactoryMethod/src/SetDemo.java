import java.util.Set;

public class SetDemo {
	public static void main(String[] args) {
		Set<String> set = Set.of("React", "Springboot", "Java", "Python");
		set.forEach(System.out::println);

	}
}
