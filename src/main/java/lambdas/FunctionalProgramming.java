package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by olexandra on 1/17/16.
 */
public class FunctionalProgramming {
    public static void main(String[] args) {
        System.out.println(isPrimeDeclarative(5));
        System.out.println(isPrimeImperative(5));
        System.out.println(isPrimeDeclarative(6));
        System.out.println(isPrimeImperative(6));
        System.out.println(isPrimeDeclarative(8));
        System.out.println(isPrimeImperative(8));
        System.out.println(getEvenDoubledGreaterThan(4));
        List<Integer> values = Arrays.asList(1, 2, 5, 4, 6, 5, 4, 3, 8);
        System.out.println(getEvenDoubledGreaterThanList(values, 3));
        System.out.println(getEvenDoubledGreaterThanListSample(values, 3));
        System.out.println(getEvenDoubleGreaterThan3StreamAnd(values)) ;
        System.out.println(Stream.of(2).count())    ;
        tryInstanceOf();
   //     values.parallelStream().flatMapToInt()
//        intGenerator();

//        IntSupplier i = ()-> Integer.MAX_VALUE;
//
//        System.out.println(i.getAsInt());
    }

    /*
     * Declarative - what we do
     * is immutable
     */
    private static boolean isPrimeDeclarative(final int number) {
        return IntStream.range(2, number).noneMatch(i -> number % i == 0);
    }

    private static boolean isPrimeDeclarativeWithPredicate(final int number) {

        IntPredicate isDivisible = i -> number % i == 0;
        //       Predicate<Integer> isDiv = i -> number % i == 0;
        return IntStream.range(2, number).noneMatch(isDivisible);
    }

    /*
     * Imperative - how we do it
     * is mutable
     */
    private static boolean isPrimeImperative(final int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    private static int getEvenDoubledGreaterThan(final int number) {
        return IntStream.range(number + 1, 100)
                .filter(i -> i % 2 == 0)
                .map(i -> 2 * i)
                .findFirst()
                .getAsInt();
    }

    private static int getEvenDoubledGreaterThanList(List<Integer> values, final int number) {
        return values.stream()
                .filter(i -> i > number)
                .filter(i -> i % 2 == 0)
                .map(i -> 2 * i)
                .findFirst().get();
    }

    private static int getEvenDoubledGreaterThanListSample(List<Integer> values, final int number) {
        return getEvenDoubleGreaterThan3Stream(values)
                .findFirst().get();
    }

    private static Stream<Integer> getEvenDoubleGreaterThan3Stream(List<Integer> values) {
        Predicate<Integer> greater3 = i -> i > 3;
        Function<Integer, Predicate<Integer>> isGreaterThan = compareNumb -> curNumber -> curNumber > compareNumb;
        return values.stream()
    //            .filter( FunctionalProgramming::isGreaterThan3 )
    //            .filter( greater3)
                .filter( isGreaterThan.apply(4))
                .filter(FunctionalProgramming::isEven)
                .map(FunctionalProgramming::doubleNumber);
    }

    private static Integer getEvenDoubleGreaterThan3StreamAnd(List<Integer> values) {
        return values.stream()
                .filter(FunctionalProgramming.isGreaterThan3().and(isEven()))
                .map(FunctionalProgramming::doubleNumber).findFirst().get();
    }
    private static Function<Integer, Integer> multiplyBy2() {
        return i -> 2 * i;
    }

    private static int doubleNumber(int number){
        System.out.printf("\nLet's double -> " + number);
        return number * 2;
    }

    private static Predicate<Integer> isEven() {
        return i -> i % 2 == 0;
    }

    private static Predicate<Integer> isGreaterThan3() {
        return i -> i > 3;
    }

    private static boolean isEven(Integer number) {
        System.out.printf("\nIs even -> " + number);
        return number % 2 == 0;
    }

    private static boolean isGreaterThan3(Integer number) {
        System.out.printf("\nIs greater than 3 -> " + number);
        return number > 3;
    }

    public static void intGenerator() {
        IntStream i = IntStream.generate(()->{return (int)(Math.random()*100);});
        i.limit(10).forEach(System.out::println);
    }
    public static void tryInstanceOf() {
        List<String> strings = Stream.of(1, 2.03, "Petit France", 3).filter(String.class::isInstance).map(String.class::cast).collect(Collectors.toList());
        System.out.println("This is list " + strings);
        String string = Stream.of(1, 2.03, "Petit France", 3).filter(String.class::isInstance).map(String.class::cast).collect(Collectors.joining(","));
        System.out.println("This is string " + string);
        Stream.of(1, 2.03, "Petit France", 3).filter(String.class::isInstance).map(String.class::cast).forEach(e -> System.out.println("This is string in lambdas for each " + e));
        Stream.of(1, 2.03, "Petit France", 3).filter(Integer.class::isInstance).map(Integer.class::cast).forEach(System.out::println);
        Stream.of(1, 2.03, "Petit France", 3).filter(e -> e instanceof Double).map(e -> (Double) e).forEach(System.out::println);
    }
}
