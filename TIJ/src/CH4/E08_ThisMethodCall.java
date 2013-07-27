package CH4;
/****************** Exercise 8 *****************
 * Create a class with two methods. Within the
 * first method call the second method twice to
 * see it work, the first time without using this,
 * and the second time using this.
 * (You should not use this form in practice.)
 ***********************************************/
class Person{
	public void eat(Apple apple){
		Apple peeled = apple.getPeeled();
		System.out.println("Yummy");
	}
}
class Peeler{
	public static Apple peel(Apple apple){
		// remove peel
		return apple;
	}
}
class Apple{
	public Apple getPeeled(){
		return Peeler.peel(this);
	}
}

public class E08_ThisMethodCall {
	public static void main(String[] args){
		new Person().eat(new Apple());
	}
}
