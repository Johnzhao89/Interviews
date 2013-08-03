package CH6;
/****************** Exercise 20 ****************
 * Show that the @Override annotation solves the
 * problem from the "final and private" section.
 ***********************************************/
class OverridingPrivateE20 extends WithFinals {
    private final void f() {
      System.out.println("OverridingPrivateE20.f()");
    }
    private void g() {
    	System.out.println("OverridingPrivateE20.g()");
    } 
}
class OverridingPrivate2E20 extends OverridingPrivateE20 {
    public final void f() {
    	System.out.println("OverridingPrivate2E20.f()");
    }
    public void g() {
    	System.out.println("OverridingPrivate2E20.g()");
} 
}

public class E20_OverrideAnnotation {
    public static void main(String[] args) {
        OverridingPrivate2E20 op2 = new OverridingPrivate2E20();
        op2.f();
        op2.g();
}
}





