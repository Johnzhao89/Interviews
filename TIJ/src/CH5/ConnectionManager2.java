package CH5;
public class ConnectionManager2{
	private static Connection2[] pool = new Connection2[10];
	static{
		for(int i = 0; i< pool.length; i++)
			pool[i] = new Connection2();
	}
	public static Connection2 getConnection(){
		for(int i= 0; i<pool.length; i++)
			if(pool[i]!=null){
				Connection2 c = pool[i];
				pool[i] = null;// indicate i use
				return c;
			}
		return null;// none left
	}
	public static void checkIn(Connection2 c){
		for(int i = 0; i<pool.length; i++)
			if(pool[i] == null){
				pool[i]=c;
				return;
			}
	}
}