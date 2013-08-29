package CH1;
/**
 * 
 * @author heguangliu
 *
 */

public class Question5{
	
	public static String compress0(String str){
		if(str.length()<=compressCount(str))
			return str;
		StringBuilder sb = new StringBuilder();
		char last=str.charAt(0);
		int count=1;
		for(int i=1; i<str.length();i++){
			if(str.charAt(i)==last)
				count++;
			else{
				sb.append(last);
				sb.append(count);
				last=str.charAt(i);
				count =1;
			}
		}
		sb.append(last);
		sb.append(count);
		return sb.toString();
	}
	
	// no string buffer allowed
	public static String compress1(String str){
		int length=compressCount(str);
		if(str.length()<=length)
			return str;
		char[] result = new char[length];
		int count =1;
		char last =str.charAt(0);
		for(int i=1,j=0; i<str.length();i++){
			if(str.charAt(i)==last){
				count++;
			}else{
				copyChar(last, count, result,j);
				j+=(count+"").length()+1;
				count=1;
				last=str.charAt(i);
			}
			copyChar(last,count,result, j);
		}
		return new String(result);
	}
	
	public static void copyChar(char last, int count, char[] result, int index){
		result[index++]=last;
		char[] cnt= String.valueOf(count).toCharArray();
		for(char c: cnt){
			result[index++]=c;
		}
	}
	
	public static int compressCount(String str){
		int count=1;
		int sum=0;
		char last=str.charAt(0);
		for(int i=1; i<str.length();i++){
			if(str.charAt(i)==last)
				count++;
			else{
				sum+=(1+(count+"").length());
				count=1;
				last=str.charAt(i);
			}
		}
		sum+=(1+(count+"").length());
		return sum;
	}
	
	public static void main(String[] args){
		String[] strs= {"abcdefg","aaabbbbbcdefffgg","abcddeeffgg","aaaaabbbbbb","aaabbb","dasljklllllll"};
		for(String str:strs){
			System.out.println(str+" count:"+compressCount(str)+" after compress0: "+compress0(str)+
					" after compress1: "+compress1(str));
		}
	}
	
	
}