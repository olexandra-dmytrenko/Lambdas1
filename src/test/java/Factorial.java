import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.testng.Assert.assertEquals;

/**
 * Created by olexandra on 3/21/16.
 */
public class Factorial {

    Logger log = LoggerFactory.getLogger("FactorialTest");

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void NegativeNumber() {
        int number = -1;
        log.info("Test Name is '{}' and it counts factorial for {}",
                Stream.of(Thread.currentThread().getStackTrace())
                        .filter(m -> m.getClassName().equals(this.getClass().getName()))
                        .map(StackTraceElement::getMethodName).findAny().orElse("Method name is hidden"),
                number);
        factorialOf(number);
    }

    @Test
    public void Factorial0() {
        int number = 0;
        log.info("Test Name is '{}' and it counts factorial for {}", new Object() {
        }.getClass().getEnclosingMethod().getName(), number);
        int actual = factorialOf(number);
        assertEquals(actual, 1);
    }

    @Test
    public void Factorial1() {
        int number = 1;
        log.info("Test Name is '{}' and it counts factorial for {}",
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                number);
        int actual = factorialOf(number);
        assertEquals(actual, 1);
    }

    @Test
    public void Factorial2() {
        int number = 2;
        log.info("Test Name is '{}' and it counts factorial for {}",
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                number);
        int actual = factorialOf(number);
        assertEquals(actual, 2);
    }

    @Test
    public void Factorial3() {
        int number = 3;
        log.info("Test Name is '{}' and it counts factorial for {}",
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                number);
        int actual = factorialOf(number);
        assertEquals(actual, 6);
    }

    @Test
    public void Factorial4() {
        int number = 4;
        log.info("Test Name is '{}' and it counts factorial for {}",
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                number);
        int actual = factorialOf(number);
        assertEquals(actual, 24);

    }

    private int factorialOf(int number) {
        if (number >= 0)
            return IntStream.rangeClosed(1, number).peek(currentN -> log.info("Current processed number is {}", currentN))
                    .reduce(1, (accumulatedResult, currentNumber) -> accumulatedResult * currentNumber);
        else throw new IllegalArgumentException("Factorial can be counted only of not negative numbers.");
    }
}
