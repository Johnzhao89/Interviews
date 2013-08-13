package CH12;
/****************** Exercise 2 ******************
 * Repair InfiniteRecursion.java.
 ************************************************/
import java.util.*;

public class E02_RepairInfinite {
    public String toString() {
      return " E02_RepairInfinite address: "
        + super.toString() + "\n";
    }
    public static void main(String[] args) {
      List<E02_RepairInfinite> v =
        new ArrayList<E02_RepairInfinite>();
      for(int i = 0; i < 10; i++)
        v.add(new E02_RepairInfinite());
      System.out.println(v);
    }
 }