package CH7;
/****************** Exercise 4 *****************
 * Add a new type of Shape to Shapes.java and
 * verify in main() that polymorphism works for
 * your new type as it does in the old types.
 ***********************************************/

public class E04_NewShapeType {
    public static void main(String args[]) {
      Shape2[] shapes = {
        new Circle2(), new Square2(), new Triangle2(),
        new Tetrahedron2()
      };
      // Make polymorphic method calls:
      for(Shape2 shape : shapes) {
        shape.draw();
        shape.erase();
        shape.msg();
} 
}
}