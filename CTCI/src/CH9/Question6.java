package CH9;
import java.util.*;
import CtCILibrary.*;

public class Question6{
	public static String insertInside(String str, int leftIndex){
		String left = str.substring(0,leftIndex+1);
		String right = str.substring(leftIndex+1);
		return left+"()"+right;
	}
	
	public static Set<String> generateParens0(int remaining){
		Set<String> set = new HashSet<String>();
		if(remaining == 0){
			set.add("");
		}else{
			Set<String> prev = generateParens0(remaining -1);
			for(String str:prev){
				for(int i=0; i<str.length(); i++){
					if(str.charAt(i)=='('){
						String s = insertInside(str,i);
						set.add(s);
					}
				}
				if(!set.contains("()"+str)){
					set.add("()"+str);
				}
			}
		}
		return set;
	}
	
	public static ArrayList<String> generateParens1(int count){
		char[] str = new char[count*2];
		ArrayList<String> list = new ArrayList<String>();
		addParen(list, count,count, str, 0);
		return list;
	}
	
	public static void addParen(ArrayList<String> list, int leftRem, int rightRem,char[] str, int count){
		if(leftRem<0 || rightRem < leftRem)
			return ;
		if(leftRem==0 && rightRem == 0){
			String s = String.copyValueOf(str);
			list.add(s);
		}else{
			if(leftRem>0){
				str[count]='(';
				addParen(list, leftRem-1, rightRem, str,count+1);
			}
			if(rightRem > leftRem){
				str[count]=')';
				addParen(list, leftRem,rightRem-1, str, count+1);
			}
		}
	}
	
	
	public static void main(String[] args) {
		Set<String> list = generateParens0(2);
		for (String s : list) {
			System.out.println(s);
		}
		System.out.println(list.size());
	}
	
}