package CH8;

/******************
 * Exercise 9 ****************** Refactor Music5.java by moving the common
 * methods in Wind3, Percussion and Stringed into an abstract class.
 ***********************************************/

abstract class Instrument3 {
	public void play(Note n) {
		System.out.println(this + ".play() " + n);
	}

	public void adjust() {
		System.out.println(this + ".adjust()");
	}
	// Forces implementation in derived class:
	public abstract String toString();
}

class Wind3 extends Instrument3 {
	public String toString() {
		return "Wind3";
	}
}

class Percussion3 extends Instrument3 {
	public String toString() {
		return "Percussion";
	}
}

class Stringed3 extends Instrument3 {
	public String toString() {
		return "Stringed";
	}
}

class Bass3 extends Wind3 {
	public String toString() {
		return "Brass";
	}
}

class Woodwind3 extends Wind3 {
	public String toString() {
		return "Woodwind";
	}
}

public class E09_AbstractMusic5 {
	static void tune(Instrument3 i) {
		i.adjust();
		i.play(Note.MIDDLE_C);
	}

	static void tuneAll(Instrument3[] e) {
		for (Instrument3 i : e)
			tune(i);
	}

	public static void main(String[] args) {
		Instrument3[] orchestra = { new Wind3(), new Percussion3(),
				new Stringed3(), new Bass3(), new Woodwind3() };
		tuneAll(orchestra);
	}
}
