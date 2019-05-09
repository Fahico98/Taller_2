
/**
 * Generating Class of Prime Numbers...
 * 
 * TreeSet<T> class:
 * A type tree collection that contains no duplicate elements. The elements are
 * ordered using their natural ordering, or by a "Comparator" provided at set 
 * creation time, depending on which constructor is used. This implementation
 * provides guaranteed log(n) time cost for the basic operations.
 * 
 * Stream<T> interface:
 * All the information about Stream interface here: 
 * https://www.oracle.com/technetwork/es/articles/java/procesamiento-streams-java-se-8-2763402-esa.html
 */

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class PrimeNumber {

    /**
    * Java 8 / Lambda approach to generate Prime number.
    * Prime always start to look from number 1.
    * @param top Number of how many Prime number should be generated
    * @return List holding resulting Prime number.
    */
    public static List<Integer> generate(int top) {
        Set<Integer> set = new TreeSet<>();
        return Stream
                .iterate(2, i -> ++i)
                //.filter(i -> i % 2 != 0)
                .filter(i -> {
                    set.add(i);
                    return(
                            0 == set.stream()
                            .filter(p -> p != 1)
                            .filter(p -> !Objects.equals(p, i))
                            .filter(p -> i % p == 0)
                            .count()
                    );
                })
                .limit(top)
                .collect(toList());
    }
    
    /*
    public static void main(String[] args) {
        List<Integer> generate = PrimeNumber.generate(20);
        System.out.println(generate);
    }
    */
}
