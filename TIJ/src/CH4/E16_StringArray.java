package CH4;
/****************** Exercise 16 *****************
 * Assign a string to each element of an array of
 * String objects. Print the array using a for loop.
 ************************************************/
public class E16_StringArray{
	public static void main(String[] args){
		String[] sa1=new String[]{"These", "are","some","String"};
		for(int i = 0; i < sa1.length; i++)
            System.out.println(sa1[i]);
		String sa2[] = {
	               "These", "are", "some", "strings"
	             };
	             for(int i = 0; i < sa2.length; i++)
	               System.out.println(sa2[i]);
	}
}