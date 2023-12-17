import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP05 {

    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Spring Boot", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        List<String> courses2 = List.of("Spring", "Spring Boot", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        String course = courses.stream().collect(Collectors.joining(","));

//        System.out.println(course);
        courses.stream().map(c -> c.split("")).flatMap(Arrays::stream).forEach(System.out::println);

        List<List<String>> tuplesWithSameName = courses.stream().flatMap(c -> courses2.stream().filter(c1 -> c1.length() == c.length()).map(c2 -> List.of(c, c2))).filter(Predicate.not(l -> l.get(0).equals(l.get(1)))).toList();
        System.out.println(tuplesWithSameName);
    }
}
