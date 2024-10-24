import static java.util.Map.entry;

import java.util.Map;

public class MapDemo {
	public static void main(String[] args) {
		Map<Integer, String> map = Map.of(1, "React", 2, "Springboot", 3, "Python");
		map.forEach((key, value) -> System.out.println(key + ": " + value));
		Map<Integer, String> map2 = Map.ofEntries(entry(1, "React"), entry(2, "Springboot"), entry(3, "Python"));
		map2.forEach((key, value) -> System.out.println(key + ": " + value));
	}
}
