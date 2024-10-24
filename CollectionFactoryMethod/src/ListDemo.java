import java.util.List;

public class ListDemo {
	public static void main(String[] args) {
		List<String> list = List.of("React", "Springboot", "Java", "Python");
//		list.add("Docker");
		list.forEach(System.out::println);

	}
}
