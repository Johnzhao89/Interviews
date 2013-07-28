package CH5;

public class E08_ConnectionManager2{
	public static void main(String[] args){
		Connection2[] ca = new Connection2[10];
		for(int i=0; i<10; i++)
			ca[i]=ConnectionManager2.getConnection();
		System.out.println(ConnectionManager2.getConnection());
		for(int i=0; i<5; i++){
			ca[i].checkIn();
			Connection2 c = ConnectionManager2.getConnection();
			System.out.println(c);
			c.doSomthing();
			c.checkIn();
		}
	}
}