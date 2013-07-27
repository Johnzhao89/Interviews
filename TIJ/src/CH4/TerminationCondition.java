package CH4;
class Book{
	boolean checkedOut = false;
	Book(boolean checkOut){
		checkedOut = checkOut;
	}
	void checkIn(){
		checkedOut = false;
	}
	protected void finalize() {
		    if(checkedOut)
		      System.out.println("Error: checked out");
		    // Normally, you¡¯ll also do this:
		    //super.finalize(); // Call the base-class version
	} 
}

public class TerminationCondition{
	public static void main(String[] args){
		Book novel = new Book(true);
		novel.checkIn();
		new Book(true);
		System.gc();
	}
}
