package lambdas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by olexandra on 1/18/16.
 * Examples: https://docs.oracle.com/javase/tutorial/collections/interfaces/map.html
 */
public class Maps {
    public static void main(String[] args) {
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(2, "2");
        map.put(3, "3");
        map.put(1, "1");
        map.entrySet().stream().forEach(System.out::println);
        //        map.entrySet().stream().forEach(e -> System.out.println(e));
        System.out.println(map);
        System.out.println((Object) map.entrySet().stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1,
                        LinkedHashMap::new)));
    }
}