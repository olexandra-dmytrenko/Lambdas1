package lambdas;

import java.util.Arrays;
import java.util.List;

/**
 * Created by olexandra on 1/17/16.
 *  *  * Strategy Pattern
 */
public class InterfacesDI1 {

    public static void main(String[] args) {
        System.out.println(totalValues(Arrays.asList(1, 5, 3, 2, 8), new EvenSelector()));

    }

   public static int totalValues(List<Integer> values, Selector selector){
       int sum = 0;
       for (Integer value : values) {
           if(selector.pick(value))
           sum +=value;
       }
return sum;
   }
    interface Selector{
        public boolean pick(int element);

    }
    static class EvenSelector implements Selector{

        @Override
        public boolean pick(int element) {
            return element % 2 == 0;
        }
    }
}
