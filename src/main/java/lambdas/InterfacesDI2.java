package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by olexandra on 1/17/16.
 *  * Strategy Pattern
 */
public class InterfacesDI2 {

    public static void main(String[] args) {
        System.out.println(totalValues(Arrays.asList(1, 5, 3, 2, 8), e -> true));
        System.out.println(totalValues(Arrays.asList(1, 5, 3, 2, 8), e -> e % 2 == 0));

    }

    public static int totalValues(List<Integer> values, Predicate<Integer> selector) {
        return values.stream().filter(selector).skip(1).reduce(0, Math::addExact);
    }
}

