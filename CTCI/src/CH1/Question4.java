package CH1;
/**
 * 
 * @author heguangliu
 *
 */

public class Question4{
	
	public static String replaceSpace(String source){
		if(source==null || source.length()==0)
			return source;
		
		int oldLength= source.length(), spaceCount=0, newLength;//local var need initialize
		for(char c: source.toCharArray())
			if(c==' ')
				spaceCount++;
		newLength=oldLength+2*spaceCount;
		if(newLength==oldLength)
			return source;
		
		char[] result=new char[newLength];
		for(int j=oldLength-1, i=newLength-1;j>=0; j--){
			if(source.charAt(j)!=' ')
				result[i--]=source.charAt(j);
			else{
				result[i--]='0';
				result[i--]='2';
				result[i--]='%';
			}
		}
		return new String(result);
	}
	
	public static void main(String[] args){
		String st1= new String("hello world world ");
		String st2= new String("hello");
		System.out.println(st1+" after relace "+replaceSpace(st1));
		System.out.println(st2+" after replace "+replaceSpace(st2));
	}
	
}