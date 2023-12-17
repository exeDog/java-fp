import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.LongStream;

public class FP05Parallel {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        long l = LongStream.rangeClosed(1, 1000000000).parallel().sum();
        System.out.println(l);
        System.out.println(System.currentTimeMillis() - start);

        Files.lines(Path.of("txt.txt")).parallel().filter(str -> str.length() > 3).map(String::toLowerCase).forEach(System.out::println);
        Files.lines(Path.of("txt.txt")).parallel().map(x -> x.split("")).flatMap(Arrays::stream).distinct().sorted().forEachOrdered(System.out::println);

        Files.lines(Paths.get(".")).forEach(System.out::println);
    }
}
