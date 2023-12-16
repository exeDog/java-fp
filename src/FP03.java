import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03 {

    public static void main(String[] args) {
        List<Integer> nums = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        Predicate<Integer> isEvenPredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        };

        Function<Integer, String> stringFunction = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return integer.toString();
            }
        };

        Consumer<Integer> sysoutConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };

        BinaryOperator<Integer> sumBinaryOperator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        };

        List<Integer> newNums = nums.stream().filter(isEvenPredicate).toList();
        List<String> stringNums = nums.stream().map(stringFunction).toList();
        newNums.stream().forEach(sysoutConsumer);
        stringNums.stream().forEach(System.out::println);
        int n = newNums.stream().reduce(0, sumBinaryOperator);
    }
}
