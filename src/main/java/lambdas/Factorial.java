package lambdas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.IntStream;

/**
 * Created by olexandra on 3/23/16.
 */
public class Factorial {
public static Logger log = LoggerFactory.getLogger(Factorial.class);

    public static int factorialOf(int number) {
        if (number >= 0)
            return IntStream.rangeClosed(1, number)
                 //   .peek(currentN -> log.info("Current processed number is {}", currentN))
                    .reduce(1, (accumulatedResult, currentNumber) -> accumulatedResult * currentNumber);
        else throw new IllegalArgumentException("Factorial can be counted only of not negative numbers.");
    }

}
