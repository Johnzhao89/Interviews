package Array;

/**
 * Now, instead outputting board configurations, return the total number of
 * distinct solutions.
 * 
 * @author heguangliu
 * 
 */
public class NQueensII {
	
	public int totalNQueens(int n) {
		int[] count = new int[1];
		solveNQueensHelper(n, 0, 0, 0,count);
		return count[0];
	}

	private void solveNQueensHelper(int n, long row, long lDiagonal,
			long rDiagonal, int[] count) {
		long validator = (1<<n)-1;
		if(row == validator){
			count[0]++;
		}else{
			long candidates = (~(row| lDiagonal|rDiagonal)) &(validator);
			while(candidates>0){
				long pos = (candidates & (0-candidates));
				candidates-= pos;
				solveNQueensHelper(n, (row| pos), ((lDiagonal | pos) << 1), ((rDiagonal | pos) >> 1), count);
			}
		}
	}
}