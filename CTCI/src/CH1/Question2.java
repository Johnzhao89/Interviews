package CH1;

public class Question2{
	public static String reverse(String str){
		StringBuilder dst= new StringBuilder(str.length());
		for(int i=0; i<str.length(); i++){
			dst.append(str.charAt(str.length()-i-1));
		}
		return dst.toString();
	}
	
	public static void main(String[] args){
		System.out.println("Hello after reverse: "+ reverse("Hello"));
	}
}