package CH8;

import java.util.Arrays;

class Waveform{
	private static long counter;
	private final long id = counter++;
	public String toString() {
		return "Waveform "+ id;
	}
}

class Filter{
	public String name(){
		return getClass().getSimpleName();
	}
	public Waveform process(Waveform input){
		return input;
	}
}

interface Processor{
	String name();
	Object process(Object input);
}

class Apply{
	public static void process(Processor p, Object s){
		System.out.println("Using Processor " + p.name());
		System.out.println(p.process(s));
	}
}

public abstract class StringProcessor implements Processor{
	public String name(){
		return getClass().getSimpleName();
	}
	public abstract String process(Object input);
	public static String s =
		    "If she weighs the same as a duck, she¡¯s made of wood";
	public static void main(String[] args){
		Apply.process(new Upcase(), s);
		
	}
}

class Upcase extends StringProcessor {
	  public String process(Object input) { // Covariant return
	    return ((String)input).toUpperCase();
	  }
	}
	class Downcase extends StringProcessor {
	  public String process(Object input) {
	    return ((String)input).toLowerCase();
	  }
	}
	class Splitter extends StringProcessor{
		public String process(Object input){
			return Arrays.toString(((String)input).split(" "));
		}
	}



class LowPass extends Filter{
	double cutoff;
	public LowPass(double cutoff) { this.cutoff = cutoff; }
	public Waveform process(Waveform input) {
	return input; // Dummy processing
	}
}

class HighPass extends Filter{
	double cutoff;
	public HighPass(double cutoff) { this.cutoff = cutoff; }
	public Waveform process(Waveform input) { return input; }
}

class BandPass extends Filter{
	double lowCutoff, highCutoff;
	  public BandPass(double lowCut, double highCut) {
	    lowCutoff = lowCut;
	    highCutoff = highCut;
	  }
	  public Waveform process(Waveform input) { return input; }
}





