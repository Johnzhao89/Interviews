package CH6;
/****************** Exercise 18 *****************
 * Create a class with a static final field and a
 * final field and demonstrate the difference
 * between the two.
 ***********************************************/
class SelfCounter{
	private static int count;
	private int id = count++;
	public String toString(){
		return "SelfCounter " + id;
	}
}

class WithFinalFields{
	final SelfCounter scf = new SelfCounter();//ÿ�ζ�initial
	static final SelfCounter scsf = new SelfCounter();//ֻ��initialһ��
	public String toString(){
		return "scf = "+ scf+ "\nscsf = "+ scsf;
	}
}

public class E18_FinalFields{
	public static void main(String args[]) {
        System.out.println("First object:");
        System.out.println(new WithFinalFields());
        System.out.println("Second object:");
        System.out.println(new WithFinalFields());
   }
}


