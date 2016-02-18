package lambdas;

import java.util.Arrays;
import java.util.function.Supplier;

/**
 * Created by olexandra on 1/25/16.
 */
public class Lazy {
    public <R> R use(final Supplier<R> mapper) {
        System.out.println("Use started");
        R result = mapper.get();
        System.out.println("Result = " + result);
        System.out.println("Use ended");
        return result;
    }

    public boolean isBoolean() {
        System.out.println("isBoolean start");
        use(() -> {
            System.out.println("isBoolean Middle");
            return true;
        });
        return false;
    }

    public void returnNothing() {
        System.out.println("returnNothing start");
        use(() -> {
            System.out.println("returnNothing Middle");
            return "I'm return Stub";
        });
    }

    public String getParameter(int one, String st) {
        System.out.println("getParameter start");
        use(() -> {
            System.out.println("getParameter Middle");
            System.out.println("I can use parameters: " + st + one);
            return Arrays.asList(one, st);
        });
        return st + " was used";
    }


    public static void main(String[] args) {
        Lazy l = new Lazy();
        System.out.println(l.isBoolean());
        System.out.println("---------------");
        l.returnNothing();
        System.out.println("---------------");
        System.out.println(l.getParameter(1, "Meaningless string"));
    }
}
