package CH7;
/****************** Exercise 3 *****************
 * Add a new method in the base class of
 * Shapes.java that System.out.printlns a message, but don't
 * override it in the derived classes. Explain
 * what happens. Now override it in only one of the
 * derived classes and see what happens. Finally,
 * override it in all the derived classes.
 ***********************************************/

class Shape2{
	public void draw() {}
	public void erase() {}
	public void msg() {System.out.println("Base class msg()");} 
}

class Circle2 extends Shape2 {
    public void draw() { System.out.println("Circle.draw()"); }
    public void erase() { System.out.println("Circle.erase()"); }
    //public void msg() { System.out.println("Circle.msg()"); }
}

class Square2 extends Shape2 {
    public void draw() { System.out.println("Square.draw()"); }
    public void erase() { System.out.println("Square.erase()"); }
    public void msg() { System.out.println("Square.msg()"); }
} 

class Triangle2 extends Shape2 {
    public void draw() { System.out.println("Triangle.draw()"); }
    public void erase() { System.out.println("Triangle.erase()"); }
    public void msg() { System.out.println("Triangle.msg()"); }
} 

class Tetrahedron2 extends Shape2 {
    public void draw() { System.out.println("Tetrahedron.draw()"); }
    public void erase() { System.out.println("Tetrahedron.erase()"); }
    public void msg() { System.out.println("Tetrahedron.msg()"); }
}

public class E03_NewShapeMethod{
	public static void main(String[] args){
		Shape2[] shapes = {new Circle2(), new Square2(), new Triangle2()};
		for(Shape2 shape: shapes){
			shape.draw();
			shape.erase();
			shape.msg();
		}
		
	}
}
