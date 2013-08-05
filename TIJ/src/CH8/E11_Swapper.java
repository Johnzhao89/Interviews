package CH8;
/****************** Exercise 11 ******************
 * Create a class with a method that takes a String
 ￼￼￼￼￼￼￼￼￼￼￼￼￼￼￼￼￼￼￼￼￼￼￼￼￼￼￼￼￼￼￼￼￼￼￼￼￼￼* argument and produces a result that swaps each
 * pair of characters in that argument. Adapt the
 * class to work with
 * interfaceprocessor.Apply.process().
 ***********************************************/

interface Processor1{
	String name();
	Object process(Object input);
}

class Apply1{
	public static void process(Processor1 p, Object s){
		System.out.println("Using Processor " + p.name());
		System.out.println(p.process(s));
	}
}

class CharacterPairSwapper{
	static String swap(String s){
		StringBuilder sb= new StringBuilder(s);
		for(int i =0; i< sb.length() - 1; i+=2){
			char c1= sb.charAt(i);
			char c2= sb.charAt(i+1);
			sb.setCharAt(i,c2);
			sb.setCharAt(i+1, c1);
		}
		return sb.toString();
	}
}

class SwapperAdapter implements Processor1{
	public String name(){
		return CharacterPairSwapper.class.getSimpleName();
	}
	public String process(Object input){
		return CharacterPairSwapper.swap((String)input);
	}
}

public class E11_Swapper{
	public static void main(String[] args) {
        Apply1.process(new SwapperAdapter(), "1234");
        Apply1.process(new SwapperAdapter(), "abcde");
      }
}

