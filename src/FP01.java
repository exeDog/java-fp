import java.util.List;

public class FP01 {
    public static void main(String[] args) {
        List<Integer> listOfInt = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        printNumbers(listOfInt);
        printEvenNumbers(listOfInt);
        printNumbersFunctional(listOfInt);
        printEvenNumbersFunctional(listOfInt);
        printSquares(listOfInt);
    }

    private static void printNumbers(List<Integer> nums) {
        for (int num : nums) {
            System.out.println(num);
        }
    }

    private static void printEvenNumbers(List<Integer> nums) {
        for (int num : nums) {
            if (num % 2 == 0) {
                System.out.println(num);
            }
        }
    }

    private static void printNumbersFunctional(List<Integer> nums) {
        nums.stream()
                .forEach(System.out::println);
    }

    private static void printEvenNumbersFunctional(List<Integer> nums) {
        nums.stream()
                .filter(num -> num % 2 == 0)
                .forEach(System.out::println);
    }

    private static void printSquares(List<Integer> nums) {
        nums.stream()
                .map(num -> num * num)
                .forEach(System.out::println);
    }
}
