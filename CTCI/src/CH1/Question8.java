package CH1;
/**
 * 
 * @author heguangliu
 *
 */

public class Question8{
	public static boolean isSubstring(String big, String small){
		return big.indexOf(small)==-1? false: true;
	}
	
	public static boolean isRotation(String s1, String s2){
		if(s1.length()!=s2.length()|| s1==null||s2==null)
			return false;
		return isSubstring(s1+s1,s2);
	}
	
	public static void main(String[] args){
		String[][] pairs ={{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
		for(String[] pair: pairs){
			boolean is_rotate= isRotation(pair[0],pair[1]);
			System.out.println(pair[0]+", "+ pair[1]+": "+is_rotate);
		}
	}
}