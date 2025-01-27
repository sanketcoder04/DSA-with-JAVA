import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetMain {
    public static void main(String[] args) {
        HashSet<String> hashset = new HashSet<>();
        hashset.add("Delhi");
        hashset.add("Mumbai");
        hashset.add("Kolkata");
        hashset.add("Chennai");

        // Iteration using Iterator
        Iterator<String> iter = hashset.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }

        // Iteration using for each loop
        hashset.forEach(elem -> {
            System.out.println(elem);
        });

        // Other type of HashSets

        LinkedHashSet<String> lhset = new LinkedHashSet<>();
        lhset.add("Delhi");
        lhset.add("Mumbai");
        lhset.add("Kolkata");
        lhset.add("Chennai");

        TreeSet<String> treeset = new TreeSet<>();
        treeset.add("Delhi");
        treeset.add("Mumbai");
        treeset.add("Kolkata");
        treeset.add("Chennai");

        // Union, Intersection and Complement of two sets 

        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("Union : " + union);

        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("Intersection : " + intersection);

        Set<Integer> complement = new HashSet<>(set1);
        complement.removeAll(set2);
        System.out.println("Complement : " + complement);
    }
}
