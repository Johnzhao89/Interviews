package CH3;

/****************** Exercise 7 ******************
 * Modify Exercise 1 so the program exits by
 * using the break keyword at value 99. Try using
 * return instead.
 ************************************************/
public class E07_To98{
	public static void mian(String[] args){
		for(int i = 0; i< 100; i++){
			if(i == 74) break;
			if(i % 9 != 0) continue;
			System.out.print(i + " ");
		}
		System.out.println();
		
		int i = 0;
		while(true){
			i++;
			int j = i *27;
			if(j == 1269) break;
			if(i % 10 != 0) continue;
			System.out.print(i+" ");
		}
	}
}