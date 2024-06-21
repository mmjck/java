import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Lambdas {
    public static void main(String[] args) {
        Map<String, Integer> numbers = new HashMap<>();
        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three", 3);
        numbers.put("four", 4);
        numbers.put("five", 5);
        numbers.put("six", 6);

        Supplier<String> nums = () -> Integer.toString(numbers.size());
        System.out.format("Number of hashmap: %s\n\n", nums.get());

        numbers.keySet().forEach((p) -> System.out.format("%s\n", p));
        System.out.println();
        numbers.keySet().forEach(p -> System.out.format("%s\n", p));

        for (String num : numbers.keySet()) {
            System.out.format("%s\n", num);
        }
        String orbits = "Key %s | Value %s \n";

        numbers.forEach((K, V) -> System.out.format(orbits, K, V));

        for (String planet : numbers.keySet()) {
            System.out.format(orbits, planet, numbers.get(planet));
        }

        for (Map.Entry<String, Integer> num : numbers.entrySet()) {
            System.out.format(orbits, num.getKey(), num.getValue());
        }

    }
}
