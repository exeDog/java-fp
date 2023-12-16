import java.util.List;

public class FP02 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        System.out.println(addList(nums));
        System.out.println(addListFunctional(nums));

        System.out.println(nums.stream().reduce(0, Integer::max));
    }

    private static int addList(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

    private static int addListFunctional(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }
}
