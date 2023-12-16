import java.util.Comparator;
import java.util.List;

public class FPEx2 {

    public static void main(String[] args) {
        List<Integer> nums = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        System.out.println(nums.stream().map(x -> x * x).reduce(0, Integer::sum));
        System.out.println(nums.stream().map(x -> x * x * x).reduce(0, Integer::sum));
        System.out.println(nums.stream().filter(x -> x % 2 != 0).reduce(0, Integer::sum));
        System.out.println(nums.stream().filter(x -> x % 2 == 0).reduce(0, Integer::sum));
        nums.stream().distinct().forEach(System.out::println);
        nums.stream().sorted().forEach(System.out::println);
        nums.stream().distinct().sorted().forEach(System.out::println);

        List<String> courses = List.of("Spring", "Spring Boot", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
        courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        courses.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);

        List<Integer> doubleList = nums.stream().map(x -> x * x).toList();

        List<Integer> lengthOfCourses = courses.stream().map(String::length).toList();
        doubleList.forEach(System.out::println);
        lengthOfCourses.forEach(System.out::println);
    }
}
