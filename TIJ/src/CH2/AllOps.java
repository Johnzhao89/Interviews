package CH2;

public class AllOps{
	void f(boolean b){}
	void boolTest(boolean x, boolean y){
		//********************* Arithmetic operations ******************//
		//! x = x * y;
        //! x = x / y;
        //! x = x % y;
        //! x = x + y;
        //! x = x - y;
        //! x++;
        //! x--;
        //! x = +y;
        //! x = -y;
		//********************* Relational and logical *****************//
        //! f(x > y);
        //! f(x >= y);
        //! f(x < y);
        //! f(x <= y);
		f( x == y);
		f( x != y);
		f(!y);
		x =x && y;
		x = x|| y;
		//******************** Bitwise operators **********************//
		//! x = ~y;
		x = x & y;
		x = x | y;
		x = x ^ y;
		//! x = x<< 1;
		//! x = x >> 1;
		//! x = x >>> 1;
		//******************** Compound assignment *******************//
		//! x += y;
        //! x -= y;
        //! x *= y;
        //! x /= y;
        //! x %= y;
        //! x <<= 1;
        //! x >>= 1;
        //! x >>>= 1;
        x &= y;
        x ^= y;
        x |= y;
        //************************ Casting **************************//
		//! char c= (char)x;
        //! byte b = (byte)x;
        //! short s= (short)x;
        //! int i = (int)x;
        //! long l = (long)x;
        //! float f= (float) x;
        //! double d = (double)x;
	}
	void charTest(char x, char y){
		//********************* Arithmetic operations ******************//
		x = (char) (x * y);
		x = (char) (x / y);
		x = (char) (x % y);
		x = (char) (x - y);
		x = (char) (x + y);
		x++;
		x--;
		x = (char) -y;
		x = (char) +y;
		//********************* Relational and logical *****************//
		f(x > y);
		f(x >= y);
		f(x < y);
		f(x <= y);
		f(x == y);
		f(x != y);
		//! f(!x);
		//! f(x && y);
		//! f(x || y);
		
		//******************** Bitwise operators ***********************//
		x = (char) ~y;
		x = (char)(x | y);
		x = (char)(x ^ y);
		x = (char)(x << 1);
		x = (char)(x >> 1);
		x = (char)(x >>> 1);
		
		//******************** Compound assignment *********************//
		x += y;
		x -= y;
		x *= y;
		x /= y;
		x %= y;
		x <<= 1;
		x >>= 1;
		x >>>= 1;
		x &= y;
		x ^= y;
		x |= y;
		
		//************************ Casting *****************************//
		//! boolean bl= (boolean)x;
		byte b= (byte)x;
		short s =(short)x;
		int i = (int)x;
		long l = (long)x;
		float f =(float)x;
		double d = (double)x;
	}
	
	void byteTest(byte x, byte y){
		//********************* Arithmetic operations ******************//
		x = (byte)(x * y);
		x = (byte)(x / y);
		x = (byte)(x % y);
		x = (byte)(x + y);
		x = (byte)(x - y);
		x++;
		x--;
		x = (byte)+y;
		x = (byte)-y;
		//********************* Relational and logical *****************//
		f(x > y);
		f(x >= y);
		f(x <= y);
		f(x == y);
		f(x != y);
		//! f(!x);
		//! f(x && y);
		//! f(x || y);
		//******************** Bitwise operators ***********************//
		x = (byte)~y;
		x = (byte)(x & y);
		x = (byte)(x | y);
		x = (byte)(x ^ y);
		x = (byte)(x << y);
		x = (byte)(x >> 1);
		x = (byte)(x >>> 1);
		//******************** Compound assignment *********************//
		x += y;
		x -= y;
		x *= y;
		x /= y;
		x %= y;
		x <<= 1;
		x >>= 1;
		x >>>= 1;
		x &= y;
		x ^= y;
		x |= y;
		//************************ Casting *****************************//
		//! boolean bl= (boolean)x;
		char c= (char)x;
		short s = (short)x;
		long l = (long)x;
		int i= (int)x;
		byte b = (byte)x;
		float f = (float)x;
		double d = (double)x;
	}
	
	void shortTest(short x, short y){
		//********************* Arithmetic operations ******************//
		x = (short)(x * y);
		x = (short)(x / y);
		x = (short)(x + y);
		x = (short)(x - y);
		x = (short)(x % y);
		x++;
		x--;
		x = (short)+y;
		x = (short)-y;
		
		//********************* Relational and logical *****************//
		f(x > y);
		f(x >= y);
		f(x <= y);
		f(x < y);
		f(x == y);
		f(x != y);
		//! f(x || y);
		//! f(x && y);
		//! f(!x);
		//******************** Bitwise operators ***********************//
		x = (short)~y;
		x = (short)(x & y);
		x = (short)(x | y);
		x = (short)(x ^ y);
		x = (short)(x << 1);
		x = (short)(x >> 1);
		x = (short)(x >>> 1);
		//******************** Compound assignment *********************//
		x += y;
		x -= y;
		x *= y;
		x /= y;
		x %= y;
		x <<= 1;
		x >>= 1;
		x >>>= 1;
		x &= y;
		x ^= y;
		x |= y;
		//************************ Casting *****************************//	
		//! boolean bl = (boolean)x;
		char c = (char)x;
		byte b = (byte)x;
		int i = (int)x;
		long l = (long)x;
		float f = (float)x;
		double d = (double)x;
		
	}
		
	void intTest(int x, int y){
		//********************* Arithmetic operations ******************//
		x = x * y;
		x = x / y;
		x = x + y;
		x = x - y;
		x = x % y;
		x ++;
		x --;
		x = -y;
		x = +y;
		//********************* Relational and logical *****************//
		f(x > y);
		f(x < y);
		f(x >= y);
		f(x <= y);
		f(x != y);
		f(x == y);
		//! f(!x);
		//! f(x && y);
		//! f(x || y);
		
		//******************** Bitwise operators ***********************//
		x = ~y;
		x = x & y;
		x = x | y;
		x = x ^ y;
		x = x << y;
		x = x >> y;
		x = x >>> y;
		
		//******************** Compound assignment *********************//
		x += y;
		x -= y;
		x *= y;
		x /= y;
		x %= y;
		x <<= y;
		x >>= y;
		x >>>= y;
		x &= y;
		x ^= y;
		x |= y;
		
		//************************ Casting *****************************//
		//! boolean bl= (boolean)x;
		char c = (char)x;
		short s = (short)x;
		long l = (long)x;
		float f = (float)x;
		double d = (double)x;
		byte b = (byte)x;
	}
	
	void longTest(long x, long y){
		x = x * y;
		  x = x / y;
		  x = x % y;
		  x = x + y;
		  x = x - y;
		  x++;
		  x--;
		  x = +y;
		  x = -y;
		  // Relational and logical:
		  f(x > y);
		  f(x >= y);
		  f(x < y);
		  f(x <= y);
		  f(x == y);
		  f(x != y);
		  //! f(!x);
		  //! f(x && y);
		  //! f(x || y);
		  // Bitwise operators:
		  x = ~y;
		  x = x & y;
		  x = x | y;
		  x = x ^ y;
		  x = x << 1;
		  x = x >> 1;
		  x = x >>> 1;
		  // Compound assignment:
		  x += y;
		  x -= y;
		  x *= y;
		  x /= y;
		  x %= y;
		  x <<= 1;
		  x >>= 1;
		  x >>>= 1;
		  x &= y;
		  x ^= y;
		  x |= y;
		  // Casting:
		  //! boolean bl = (boolean)x;
		  char c = (char)x;
		  byte b = (byte)x;
		  short s = (short)x;
		  int i = (int)x;
		  float f = (float)x;
		  double d = (double)x;
	}
	
	void floatTest(float x, float y){
		x = x * y;
		  x = x / y;
		  x = x % y;
		  x = x + y;
		  x = x - y;
		  x++;
		  x--;
		  x = +y;
		  x = -y;
		  // Relational and logical:
		  f(x > y);
		  f(x >= y);
		  f(x < y);
		  f(x <= y);
		  f(x == y);
		  f(x != y);
		  //! f(!x);
		  //! f(x && y);
		  //! f(x || y);
		  // Bitwise operators:
		  //! x = ~y;
		  //! x = x & y;
		  //! x = x | y;
		  //! x = x ^ y;
		  //! x = x << 1;
		  //! x = x >> 1;
		  //! x = x >>> 1;
		  // Compound assignment:
		  x += y;
		  x -= y;
		  x *= y;
		  x /= y;
		  x %= y;
		  //! x <<= 1;
		  //! x >>= 1;
		  //! x >>>= 1;
		  //! x &= y;
		  //! x ^= y;
		  //! x |= y;
		  // Casting:
		  //! boolean bl = (boolean)x;
		  char c = (char)x;
		  byte b = (byte)x;
		  short s = (short)x;
		  int i = (int)x;
		  long l = (long)x;
		  double d = (double)x;
	}
	
	void doubleTest(double x, double y){
		// Arithmetic operators:
		  x = x * y;
		  x = x / y;
		  x = x % y;
		  x = x + y;
		  x = x - y;
		  x++;
		    x--;
		    x = +y;
		    x = -y;
		    // Relational and logical:
		    f(x > y);
		    f(x >= y);
		    f(x < y);
		    f(x <= y);
		    f(x == y);
		    f(x != y);
		    //! f(!x);
		    //! f(x && y);
		    //! f(x || y);
		    // Bitwise operators:
		    //! x = ~y;
		    //! x = x & y;
		    //! x = x | y;
		    //! x = x ^ y;
		    //! x = x << 1;
		    //! x = x >> 1;
		    //! x = x >>> 1;
		    // Compound assignment:
		    x += y;
		    x -= y;
		    x *= y;
		    x /= y;
		    x %= y;
		    //! x <<= 1;
		    //! x >>= 1;
		    //! x >>>= 1;
		    //! x &= y;
		    //! x ^= y;
		    //! x |= y;
		    // Casting:
		    //! boolean bl = (boolean)x;
		    char c = (char)x;
		    byte b = (byte)x;
		    short s = (short)x;
		    int i = (int)x;
		    long l = (long)x;
		    float f = (float)x;
	}
		
}
