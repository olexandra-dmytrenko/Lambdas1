package lambdas;

/**
 * Created by olexandra on 2/6/16.
 */
class MultipleInheritance implements Multiple1, Multiple2 {

    public static void main(final String[] args) {
        MultipleInheritance multipleInheritance = new MultipleInheritance();
        Multiple1 m1 = new Multiple1() {
        };
        Multiple2 m2 = new Multiple2() {
        };
        System.out.println(multipleInheritance.multi());
        System.out.println(m1.multi());
        System.out.println(m2.multi());
        System.out.println(Multiple1.multiStatic());
        System.out.println(Multiple2.multiStatic());
    }

    @Override
    public String multi() {
        return "I'm in realization";
    }
}

interface Multiple1 {
    default String multi() {
        return "I'm Multi 1";
    }

    static String multiStatic() {
        return "I'm Static 1";
    }
}

interface Multiple2 {
    default String multi() {
        return "I'm Multi 2";
    }

    static String multiStatic() {
        return "I'm Static 2";
    }
}
