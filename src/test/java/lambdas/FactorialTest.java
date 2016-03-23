package lambdas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.stream.Stream;

import static org.testng.Assert.assertEquals;

/**
 * Created by olexandra on 3/21/16.
 */
public class FactorialTest {

    Logger log = LoggerFactory.getLogger("FactorialTest");

    @DataProvider(parallel = true, name = "checkNumbers")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{0, 1}, {1, 1}, {2, 2}, {3, 6}, {4, 24}};
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void negativeNumber() {
        int number = -1;
        log.info("Test Name is '{}' and it counts factorial for {}",
                Stream.of(Thread.currentThread().getStackTrace())
                        .filter(m -> m.getClassName().equals(this.getClass().getName()))
                        .map(StackTraceElement::getMethodName).findAny().orElse("Method name is hidden"),
                number);
        Factorial.factorialOf(number);
    }

    @Test(dataProvider = "checkNumbers")
    public void factorial(int number, int expected) {
        log.info("Test Name is '{}' and it counts factorial for {}", new Object() {
        }.getClass().getEnclosingMethod().getName(), number);
        int actual = Factorial.factorialOf(number);
        assertEquals(actual, expected);
    }

    /**
     * another way to see the name of the method
     */
    @Test(enabled = false)
    public void Factorial1() {
        int number = 1;
        log.info("Test Name is '{}' and it counts factorial for {}",
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                number);
        int actual = Factorial.factorialOf(number);
        assertEquals(actual, 1);
    }
}
