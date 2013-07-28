package CH4;
/****************** Exercise 18 *****************
 * Create objects to attach to the array of
 * references for Exercise 17.
 ************************************************/

public class E18_ObjectArray{
	public static void main(String[] args){
		Test[] array= new Test[5];
		for(int i =0; i< array.length; i++){
			array[i] = new Test(Integer.toString(i));
		}
	}
}