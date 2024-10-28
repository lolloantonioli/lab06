package it.unibo.collections;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int ELEMS = 100_000;
    private static final long READ_ELEMS = 1000;
    private static final long AMERICA_POP = 972_005_000;
    private static final long AFRICA_POP = 1_110_635_000;
    private static final long ANTARTICA_POP = 0;
    private static final long ASIA_POP = 4_298_723_000L;
    private static final long EUROPE_POP = 742_452_000;
    private static final long OCEANIA_POP = 38_304_000;


    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final List<Integer> list1 = new ArrayList<>();
        for (int i = 1000; i < 2000; i++) {
            list1.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> list2 = new LinkedList<>();
        list2.addAll(list1);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final int temp = list1.getLast();
        list1.set(list1.size() - 1, list1.getFirst());
        list1.set(0, temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (final int e : list1) {
            System.out.println(e);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        
        long time = System.nanoTime();
        for (int i = 1; i <= ELEMS; i++) {
            list1.addFirst(i);
        }
        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
            "Inserting "
                + ELEMS
                + " elements as first in an ArrayList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        time = System.nanoTime();
        for (int i = 1; i <= ELEMS; i++) {
            list2.addFirst(i);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
            "Inserting "
                + ELEMS
                + " elements as first in an LinkedList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
         
        time = System.nanoTime();
        for (int i = 1; i <= READ_ELEMS; i++) {
            list1.get((int)(list1.size() - 1) / 2);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
            "Reading "
                + READ_ELEMS
                + " elements in the middle of an ArrayList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        time = System.nanoTime();
        for (int i = 1; i <= READ_ELEMS; i++) {
            list2.get((int)(list1.size() - 1) / 2);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(
            "Reading "
                + READ_ELEMS
                + " elements in the middle of a LinkedList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final Map<Long, String> continents = new HashMap<>();
        Collection<Long> pop = new HashSet<>();

        continents.put(AFRICA_POP, "Africa");
        continents.put(AMERICA_POP, "Americas");
        continents.put(ANTARTICA_POP, "Antartica");
        continents.put(ASIA_POP, "Asia");
        continents.put(EUROPE_POP, "Europe");
        continents.put(OCEANIA_POP, "Oceania");
        
        pop = continents.keySet();
        /*
         * 8) Compute the population of the world
         */
        long population = 0;
        for (final long k : pop) {
            population += k;
        }
        System.out.println(population);
        
    }
}
