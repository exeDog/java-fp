import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class FP03CustomInterface {

    public static void main(String[] args) {
        List<Integer> nums = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;
        Function<Integer, String> toStringFunction = x -> x + " Number";
        filterAndPrint(nums, isEvenPredicate);
        List<String> stringList = mapAndCollect(nums, toStringFunction);
        System.out.println(supplyRandomNumber().get());
        UnaryOperator<Integer> threeMultiplyOperator = x -> x * 3;
        Stream.iterate(3, threeMultiplyOperator).limit(10).forEach(System.out::println);
    }

    private static <T> void filterAndPrint(List<T> nums, Predicate<T> predicate) {
        nums.stream().filter(predicate).forEach(System.out::println);
    }

    private static <T, R> List<R> mapAndCollect(List<T> nums, Function<T, R> function) {
        return nums.stream().map(function).toList();
    }

    private static Supplier<Integer> supplyRandomNumber() {
        return new Supplier<Integer>() {
            @Override
            public Integer get() {
                Random random = new Random();
                return random.nextInt(1000);
            }
        };
    }
}
