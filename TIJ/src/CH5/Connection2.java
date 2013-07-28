package CH5;

public class Connection2{
	private static int counter = 0;
	private int id = counter++;
	Connection2() {}
	public String toString(){
		return "Connection "+ id;
	}
	public void doSomthing() {}
	public void checkIn(){
		ConnectionManager2.checkIn(this);
	}
}