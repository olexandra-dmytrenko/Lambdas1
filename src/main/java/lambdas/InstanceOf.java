package lambdas;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by olexandra on 1/17/16.
 */
public class InstanceOf {
    public static void main(String[] args) {
        instanceOf();
    }

    public static void instanceOf() {
        List<String> strings = Stream.of(1, 2.03, "Petit France", 3).filter(String.class::isInstance).map(String.class::cast).collect(Collectors.toList());
        System.out.println("This is list " + strings);
        String string = Stream.of(1, 2.03, "Petit France", 3).filter(String.class::isInstance).map(String.class::cast).collect(Collectors.joining(","));
        System.out.println("This is string " + string);
        Stream.of(1, 2.03, "Petit France", 3).filter(String.class::isInstance).map(String.class::cast).forEach(e -> System.out.println("This is string in lambdas for each " + e));
        Stream.of(1, 2.03, "Petit France", 3).filter(Integer.class::isInstance).map(Integer.class::cast).forEach(System.out::println);
        Stream.of(1, 2.03, "Petit France", 3).filter(e -> e instanceof Double).map(e -> (Double) e).forEach(System.out::println);
    }
}
