import java.util.List;

public class FPEx1 {

    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        courses.stream().filter(course -> course.contains("Spring")).forEach(System.out::println);
        courses.stream().filter(course -> course.length() >= 4).forEach(System.out::println);

        List<Integer> nums = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        nums.stream().filter(n -> n % 2 != 0).forEach(System.out::println);
        System.out.println("--------------------");
        nums.stream().map(n -> n * n * n).forEach(System.out::println);
        courses.stream().map(course -> course + " " + course.length()).forEach(System.out::println);
    }
}
