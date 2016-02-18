package lambdas;

import java.util.stream.Stream;

/**
 * Created by olexandra on 1/17/16.
 */
public class Interfaces {
//    static OneMethodInterface cond1 = e -> e > 2;
    static OneMethodInterface cond2 = e -> e % 2;
    public static void main(String[] args) {
       call(cond2);
    }

    private static void call(OneMethodInterface interf) {
  //      Stream.of(1, 3,2, 6,3,8).filter(i -> interf.condition(i)).forEach(i -> System.out.println(i));
       // Stream.of(1, 3,2, 6,3,8).filter(interf::condition).forEach(i -> System.out.println(i));
        Stream.of(1, 3,2, 6,3,8).map(interf::condition1).forEach(System.out::println);

    }
    public interface OneMethodInterface {
  //      public boolean condition (int element);§
        public int condition1 (int element);
    }
}
