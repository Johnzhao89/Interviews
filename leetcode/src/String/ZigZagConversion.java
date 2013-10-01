package String;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * @author heguangliu
 *
 */
public class ZigZagConversion{
	public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(nRows == 1)
        	return s;
        StringBuilder sb = new StringBuilder();
        int n = 2* nRows-2;
        for(int i=0; i< nRows; i++){
        	int curr =i;
        	while(curr < s.length()){
        		sb.append(s.charAt(curr));
        		curr+=n;
        		if(i != 0 && i!= nRows-1&& curr-i*2< s.length()){
        			sb.append(s.charAt(s.charAt(curr -2*i)));
        		}
        	}
        }
        return sb.toString();
    }
	
}