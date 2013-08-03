package CH7;

/****************** Exercise 17 ****************
* Add a balance() method to Unicycle and Bicycle
 * but not to Tricycle, using the Cycle hierarchy
 * from Exercise 1. Upcast instances of all
 * three types to an array of Cycle. Try to call
 * balance() on each element of the  array and
 * observe the results. Downcast and call
 * balance() and observe what happens.
 ***********************************************/
class Useful {
	  public void f() {}
	  public void g() {}
	}
	class MoreUseful extends Useful {
	  public void f() {}
	  public void g() {}
	  public void u() {}
	  public void v() {}
	  public void w() {}
	}
	public class E17_RTTI {
	  public static void main(String[] args) {
	    Useful[] x = {
	      new Useful(),
	      new MoreUseful()
	    };
	    x[0].f();
	    x[1].g();
	    // Compile time: method not found in Useful:
	    //! x[1].u();
	    ((MoreUseful)x[1]).u(); // Downcast/RTTI
	    ((MoreUseful)x[0]).u(); // Exception thrown
	}
	}


