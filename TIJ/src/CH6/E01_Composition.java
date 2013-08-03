package CH6;
/****************** Exercise 1 *****************
 * Create a simple class. Inside a second class,
 * define a reference to an object of the first
 * class. Use lazy initialization to instantiate
 * this object.
 ***********************************************/
class Simple {
    String s;
    public Simple(String si) { s = si; }
    public String toString() { return s; }
    public void setString(String sNew) { s = sNew; }
}

class Second{
	Simple simple;
	String s;
	public Second(String si){
		s= si;
	}
	public void check(){
		if(simple == null)
			System.out.println("not initialized");
		else
			System.out.println("initialized");
	}
	private Simple lazy(){
		if(simple == null){
			System.out.println("Creating Simple");
			simple = new Simple(s);
		}
		return simple;
	}
	public Simple getSimple() {return lazy();}
	public String toString(){
		return lazy().toString();
	}
	public void setSimple(String sNew){
		lazy().setString(sNew);
	}
}