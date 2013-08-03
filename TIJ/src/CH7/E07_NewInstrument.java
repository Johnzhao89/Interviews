package CH7;
/****************** Exercise 7 *****************
 * Add a new type of Instrument to Music3.java
 * and verify that polymorphism works for your
 * new type.
 ***********************************************/
class Electronic extends Instrument3 {
    void play(Note n) { System.out.println("Electronic.play() " + n); }
    public String toString() { return "Electronic"; }
}
  public class E07_NewInstrument {
    static Instrument3[] orchestra = {
      new Wind3(),
      new Percussion3(),
      new Stringed3(),
      new Brass3(),
      new Woodwind3(),
      new Electronic()
    };
    public static void main(String args[]) {
      for(Instrument3 i : orchestra) {
        i.play(Note.MIDDLE_C);
        i.adjust();
        System.out.println(i);
} }
  }