import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FP04 {

    public static void main(String[] args) {
        List<Course> courses = List.of(new Course("Spring", "Framework", 98, 20000), new Course("Spring Boot", "Framework", 95, 18000), new Course("API", "Microservices", 87, 22000), new Course("MS", "Microservices", 90, 466), new Course("MS", "Microservices", 87, 78245), new Course("FullStack", "FullStack", 91, 14000), new Course("AWS", "Cloud", 90, 21000), new Course("Azure", "Cloud", 99, 21000), new Course("Docker", "Cloud", 92, 20000), new Course("Kubernetes", "Cloud", 91, 20000));

        // All match
        System.out.println(courses.stream().allMatch(course -> course.getReviewScore() > 90));

        // Any match
        System.out.println(courses.stream().anyMatch(course -> course.getReviewScore() > 90));

        // None match
        System.out.println(courses.stream().noneMatch(course -> course.getReviewScore() > 90));

        Comparator<Course> compareByNumberOfStudents = Comparator.comparing(Course::getNumOfStudents);
        Comparator<Course> compareByNumberOfStudentsReversed = compareByNumberOfStudents.reversed();
        Comparator<Course> compareByNumberOfStudentsAndReviews = compareByNumberOfStudents.thenComparing(Course::getReviewScore);

        List<Course> sortedCourses = courses.stream().sorted(compareByNumberOfStudents).toList();
        List<Course> sortedCoursesReversed = courses.stream().sorted(compareByNumberOfStudentsReversed).toList();
        courses.stream().takeWhile(course -> course.getReviewScore() >= 95).toList();

        courses.stream().max(compareByNumberOfStudentsAndReviews).ifPresent(System.out::println);

        int sumOfStudentsLessThan90 = courses.stream().filter(course -> course.getReviewScore() < 90).mapToInt(Course::getNumOfStudents).sum();

        int avgOfStudentsLessThan90 = (int) courses.stream().filter(course -> course.getReviewScore() < 90).mapToInt(Course::getNumOfStudents).average().orElse(0);

        courses.stream().collect(Collectors.groupingBy(Course::getCategory)).forEach((category, coursesInCategory) -> System.out.println(category + " : " + coursesInCategory));
        courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())).forEach((category, coursesInCategory) -> System.out.println(category + " : " + coursesInCategory));
        courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(compareByNumberOfStudents))).forEach((category, coursesInCategory) -> System.out.println(category + " : " + coursesInCategory));
        courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.mapping(Course::getName, Collectors.toList()))).forEach((category, coursesInCategory) -> System.out.println(category + " : " + coursesInCategory));

        IntStream.iterate(2, x -> x + 2).limit(10).peek(System.out::println).sum();
    }
}
