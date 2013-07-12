package CH1;

/****************** Exercise 5 ******************
 * Modify Exercise 4 so the values
 * of the data in DataOnly are assigned to and
 * printed in main().
 ************************************************/

public class E05_DataOnly2 
{
       public static void main(String[] args) {
       E04_DataOnly d = new E04_DataOnly();
       d.i = 47;
       d.d = 1.1;
       d.b = false;
       E05_DataOnly2.print(d.i, d.d, d.b);
       }
       
       public static void print(int i, double d, boolean b){
    	   System.out.println("d.i = " + i);
    	   System.out.println("d.d = " + d);
    	   System.out.println("d.b = " + b);
       }
}