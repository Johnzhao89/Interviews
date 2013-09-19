package Array;

/**
 * The n-queens puzzle is the problem of placing n queens on an n¡Án chessboard such that no two queens attack each other.
 * @author heguangliu
 *Given an integer n, return all distinct solutions to the n-queens puzzle.

 Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 */
import java.util.*;

public class NQueens {
	
	//DFS, my prefer way
	public ArrayList<String[]> solveNQueens(int n) {
		ArrayList<String[]> ret = new ArrayList<String[]>();
		StringBuilder[] chess = new StringBuilder[n];
		for(int k=0; k< n; k++){
			chess[k] = new StringBuilder(n);
			for(int j=0; j< n; j++){
				chess[k].append('.');
			}
		}
		dfs(chess,0,ret);
		return ret;
	}
	
	void dfs(StringBuilder[] chess, int row, ArrayList<String[]> ret){
		int n = chess.length;
		for(int j=0; j<n; j++){
			if(validate(chess,row, j)){
				chess[row].setCharAt(j,'Q');
				if (row == n-1) {
                    String[] s = new String[n];
                    for ( int k = 0; k < n; ++k ) {
                        s[k] = chess[k].toString();
                    }
                    ret.add(s);
                } else {
                    dfs(chess, row + 1, ret);
                }
				chess[row].setCharAt(j,'.');
			}
		}
		return;
	}
	
	boolean validate(StringBuilder[] chess, int row, int col) {
        int n = chess.length;
        for(int i=0; i<n; i++)
        	for(int j=0; j<n; j++){
        		if(i!= row && chess[i].charAt(col)=='Q')
        			return false;
        		if(i!= row && Math.abs(i-row)== Math.abs(j-col)&& chess[i].charAt(j)=='Q')
        			return false;
        	}
        return true;
    }
	

	// bit solution, better performance
	public ArrayList<String[]> solveNQueens2(int n) {
		return solveNQueensHelper(new long[n], 0, 0, 0, 0,
				new ArrayList<String[]>());
	}

	private ArrayList<String[]> solveNQueensHelper(long[] rows, int cur,
			long row, long lDiagonal, long rDiagonal,
			ArrayList<String[]> results) {
		long validator = (1 << rows.length) - 1;
		if (row == validator) {
			return convertSolution(rows, results);
		} else {
			long candidates = ((~(row | lDiagonal | rDiagonal)) & validator);
			while (candidates > 0) { // find potential positions
				// pick up lowest bit
				long pos = (candidates & (0 - candidates));
				candidates -= pos;
				rows[cur] = pos;
				solveNQueensHelper(rows, cur + 1, (row | pos),
						((lDiagonal | pos) << 1), ((rDiagonal | pos) >> 1),
						results);
			}
		}
		return results;
	}

	private ArrayList<String[]> convertSolution(long[] rows,
			ArrayList<String[]> results) {
		String[] res = new String[rows.length];
		for (int i = 0; i < rows.length; ++i) {
			res[i] = Long.toBinaryString(rows[i]).replace('0', '.')
					.replace('1', 'Q');
			while (res[i].length() < rows.length)
				res[i] = '.' + res[i];
		}
		results.add(res);
		return results;
	}

	// brute force, pointer move back and force
	public ArrayList<String[]> solveNQueens3(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String[]> result = new ArrayList<String[]>();
		int[] rec = new int[n];
		rec[0] = -1;
		int k = 0;
		while (k >= 0) {
			rec[k] = rec[k] + 1;// move forward to avoid in same col
			while (rec[k] < n && !isValid(rec, k))
				// move forward until find a valid position
				rec[k] += 1;
			if (rec[k] < n) {
				if (k == n - 1) {
					createQ(rec, n, result);// find one solution
					k = k - 1;// move back for another
				} else {
					k++;
					rec[k] = -1;
				}
			} else
				k--;// if all possible has been tried, go back
		}
		return result;
	}

	public void createQ(int[] rec, int n, ArrayList<String[]> result) {
		String[] s = new String[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j == rec[i])
					s[i] = j == 0 ? "Q" : s[i] + 'Q';
				else
					s[i] = j == 0 ? "." : s[i] + '.';
			}
		}
		result.add(s);
	}

	public boolean isValid(int[] rec, int k) {
		for (int i = 0; i < k; i++) {
			if (rec[i] == rec[k]
					|| Math.abs(rec[i] - rec[k]) == Math.abs(i - k))
				return false;
		}
		return true;
	}
}
