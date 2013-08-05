package CH8;

interface Instrument4 {
	int VALUE = 5; // static & final

	void play(Note n);

	void adjust();
}

class Wind4 implements Instrument4 {
	public void play(Note n) {
		System.out.println(this + ".play() " + n);
	}

	public String toString() {
		return "Wind";
	}

	public void adjust() {
		System.out.println(this + ".adjust()");
	}
}

class Percussion4 implements Instrument4 {
	public void play(Note n) {
		System.out.println(this + ".play() " + n);
	}

	public String toString() {
		return "Percussion";
	}

	public void adjust() {
		System.out.println(this + ".adjust()");
	}
}

class Stringed4 implements Instrument4 {
	public void play(Note n) {
		System.out.println(this + ".play() " + n);
	}

	public String toString() {
		return "Stringed";
	}

	public void adjust() {
		System.out.println(this + ".adjust()");
	}
}

class Bass4 extends Wind4 {
	public String toString() {
		return "Brass";
	}
}

class Woodwind4 extends Wind4 {
	public String toString() {
		return "Woodwind";
	}
}

public class Music5{
	static void tune(Instrument4 i){
		i.play(Note.MIDDLE_C);
	}
	
	static void tuneAll(Instrument4[] e){
		for(Instrument4 i : e)
			tune(i);
	}
	
	public static void main(String[] args){
		Instrument4[] orchestra = {
			      new Wind4(),
			      new Percussion4(),
			      new Stringed4(),
			      new Bass4(),
			      new Woodwind4()
			    };
			    tuneAll(orchestra);
	}
}


























