package CH1;

/****************** Exercise 11 *****************
 * Turn the AllTheColorsOfTheRainbow example into
 * a program that compiles and runs.
 ************************************************/

public class E11_AllTheColorsOfTheRainbow{
	int anIntegerRepresentingColors;
	void changeTheHueOfTheColor(int newHue){
		anIntegerRepresentingColors=newHue;
	}
	public static void main(String[] args){
		E11_AllTheColorsOfTheRainbow all=new E11_AllTheColorsOfTheRainbow();
		all.changeTheHueOfTheColor(27);
	}
}