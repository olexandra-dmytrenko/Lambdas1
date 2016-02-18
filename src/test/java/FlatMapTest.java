import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by olexandra on 1/20/16.
 */
public class FlatMapTest {
    public static void main(String[] args) {
        FlatMapTest  flatMapTest = new FlatMapTest();
        flatMapTest.flatMap();
    }
    @Test
    public void flatMap() {
        List<Developer> team = new ArrayList<>();
        Developer polyglot = new Developer("esoteric");
        polyglot.add("clojure");
        polyglot.add("scala");
        polyglot.add("groovy");
        polyglot.add("go");

        Developer busy = new Developer("pragmatic");
        busy.add("java");
        busy.add("javascript");

        team.add(polyglot);
        team.add(busy);

        List<String> teamLanguages = team.stream().
                map(d -> d.getLanguages()).
                flatMap(l -> l.stream()).
                collect(Collectors.toList());
        System.out.println(teamLanguages);
    }

    private class Developer {
        String name;
        List<String> langs = new LinkedList<>();

        public Developer(String name) {
            this.name = name;
        }

        private void add(String lang) {
            langs.add(lang);
        }

        private List<String> getLanguages() {
            return this.langs;
        }
    }
}
