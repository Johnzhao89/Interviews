package CH7;
/****************** Exercise 8 *****************
 * Modify Music3.java so it randomly creates
 * Instrument objects the way Shapes.java does.
 ***********************************************/
class InstrumentGenerator{
	java.util.Random gen = new java.util.Random(47);
	public Instrument3 next(){
		switch(gen.nextInt(6)){
		default:
		case 0:return new Wind3();
		case 1:return new Percussion3();
		case 2:return new Stringed3();
		case 3:return new Brass3();
		case 4:return new Woodwind3();
		case 5:return new Electronic();
		}
	}
}

class InstrumentGenerator2{
	java.util.Random gen = new java.util.Random(47);
	Class<?> instruments[] = {
		Wind3.class,
		Percussion3.class,
		Stringed3.class,
		Brass3.class,
        Woodwind3.class,
        Electronic.class};
public Instrument3 next() {
	try{
		int idx = Math.abs(gen.nextInt(instruments.length));
		return (Instrument3) instruments[idx].newInstance();
	}catch(Exception e){
		throw new RuntimeException("Cannot Create", e);
	}}
}

public class E08_RandomInstruments {
    public static void main(String args[]) {
      InstrumentGenerator gen = new InstrumentGenerator();
      for(int i = 0; i < 20; i++)
        System.out.println(gen.next());
    }
  }
