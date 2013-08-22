package CH15;
/****************** Exercise 1 ******************
 * Create a method that takes an array of
 * BerylliumSphere as an argument. Call the method,
 * creating the argument dynamically. Demonstrate
 * that ordinary aggregate array initialization
 * doesn¡¯t work in this case. Discover the only
 * situations where ordinary aggregate array
 * initialization works, and where dynamic aggregate
 * initialization is redundant.
 ************************************************/
public class E01_ArrayInitialization {
    static void hide(BerylliumSphere[] s) {
      System.out.println("Hiding " + s.length + " sphere(s)");
    }
    public static void main(String[] args){
    	hide(new BerylliumSphere[]{new BerylliumSphere(),
                new BerylliumSphere()});
    	BerylliumSphere[] d={new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere()};
    	hide(d);
    	BerylliumSphere[] a = new BerylliumSphere[]{
                new BerylliumSphere(), new BerylliumSphere() };
    	hide(a);
    }
}