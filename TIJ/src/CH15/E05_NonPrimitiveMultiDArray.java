package CH15;
/****************** Exercise 5 *****************
 * Demonstrate that multidimensional arrays of
 * non-primitive types are automatically initialized
 * to null.
 ***********************************************/
import java.util.*;
public class E05_NonPrimitiveMultiDArray {
    public static void main(String[] args) {
      System.out.println(
        Arrays.deepToString(new Object[3][3][3]));
      System.out.println(
    	        Arrays.toString(new Object[3][3][3]));
    }
    
  }