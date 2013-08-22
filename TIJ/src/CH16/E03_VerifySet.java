package CH16;
/****************** Exercise 3 ******************
 * Using Countries, fill a Set with the same data
 * multiple times, then verify that the Set ends up
 * with only one of each instance. Try this with
 * HashSet, LinkedHashSet, and TreeSet.
 ************************************************/
import java.util.*;

public class E03_VerifySet {
    public static void main(String[] args) {
      Set<String> set = new LinkedHashSet<String>();
      for(int i = 0; i < 5; i++)
        set.addAll(Countries.names(10));
      System.out.println(set);
    }
  }