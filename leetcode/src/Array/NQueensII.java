package Array;

/**
 * Now, instead outputting board configurations, 
 * return the total number of distinct solutions.
 * @author heguangliu
 *
 */
public class NQueensII{
	int num;
	boolean[] colFlags;
	boolean[] lDiaFlags;
	boolean[] rDiaFlags;
	// DFS solution
	public int totalNQueens(int n){
		StringBuilder[] chess = new StringBuilder[n];
		num =0;
		colFlags = new boolean[n];
		lDiaFlags = new boolean[2*n-1];
        rDiaFlags = new boolean[2*n-1];
        
        for(int k =0; k<n; ++k){
        	chess[k] = new StringBuilder(n);
        	for(int j=0; j< n; j++){
        		chess[k].append('.');
        	}
        }
        dfs(chess,0);
        return num;
	}
	
	void dfs(StringBuilder[] chess, int row){
		int n = chess.length;
		for(int j=0; j<n; j++){
			if(!colFlags[j] && !lDiaFlags[row+j] && !rDiaFlags[j-row+n-1]){
				chess[row].setCharAt(j, 'Q');
				colFlags[j] = true;
				lDiaFlags[row+j] = true;
                rDiaFlags[j-row+n-1] = true;
                if (row == n-1) {
                    num++;
                } else {
                    dfs(chess, row + 1);
                }
                colFlags[j] = false;
                lDiaFlags[row+j] = false;
                rDiaFlags[j-row+n-1] = false;
                chess[row].setCharAt(j, '.');
			}
		}
		return;
	}
	
	
	// bit operation, better one, need understanding
	static int result = 0;
	static int upperLimit = 0;
	public static int totalNQueens2(int n) {
	    upperLimit = (1 << n)-1;
	    //System.out.println(Integer.toBinaryString(upperLimit));
	    result = 0;
	    int row = 0;
	    int ld = 0;
	    int rd = 0;
	    dfs(row,ld,rd);
	    return result;
	}
	private static void dfs(int row, int ld, int rd) {
		//System.out.print("Row: "+Integer.toBinaryString(row));
		//System.out.print(" LD: "+Integer.toBinaryString(ld));
		//System.out.println(" RD: "+Integer.toBinaryString(rd));
	    if(row >= upperLimit){
	        result++;
	        return;
	    }
	    int pos = upperLimit &(~(row|ld|rd));
	    int p = 0;
	    while(pos > 0){
	        p = pos & (~pos+1);
	        pos = pos-p;
	        dfs(row+p,(ld+p)<<1,(rd+p)>>1);
	    }

	}
	public static void main(String[] args){
	    //System.out.println(totalNQueens(8));
	}
}