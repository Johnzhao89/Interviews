package Array;

import java.util.Arrays;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.
 * @author heguangliu
 *
 */
public class SudokuSolver{
	// use this version
	public void solveSudoku(char[][] board){
		solveSudoku(board, 0);
	}
	private boolean solveSudoku(char[][] board, int n){
		int row = n/board.length;
		int col = n%board.length;
		if(row>=board.length) return true;
		if(board[row][col]!='.') return solveSudoku(board,n+1);
		boolean[] flag = new boolean[10];
		Arrays.fill(flag, true);
		for(int i=0; i<board.length; i++){
			if(board[row][i]!='.')
				flag[board[row][i]-'0']=false;
			if(board[i][col]!='.')
				flag[board[i][col]-'0']=false;
		}
		for(int i=(row/3)*3; i< (row/3)*3+3; i++){
			for(int j=(col/3)*3; j<(col/3)*3 + 3; j++){
				if(board[i][j] == '.')
					continue;
				flag[board[i][j]-'0']=false;
			}
		}
		for(int i=1; i< flag.length; i++)
			if(flag[i]){
				board[row][col]=(char)(i+'0');
				if(solveSudoku(board, n+1))
					return true;
			}
		board[row][col]='.';
		return false;
	}
	 
	 // less good, need static matrix
	 boolean[][] row, col, grid;
	    boolean dfs(int pos, char[][] board){
	        if(pos == 81) return true;
	        int r = pos / 9;
	        int c = pos % 9;
	        if(board[r][c] != '.') return dfs(pos + 1, board);
	        for(int i = 1; i <= 9; i++){
	            if(!row[r][i] && !col[c][i] && !grid[r / 3 * 3 + c / 3][i]){
	                row[r][i] = col[c][i] = true;
	                grid[r / 3 * 3 + c / 3][i] = true;
	                board[r][c] = (char)(i + '0');
	                if(dfs(pos + 1, board)) return true;
	                row[r][i] = col[c][i] = false;
	                grid[r / 3 * 3 + c / 3][i] = false;
	            }
	        }
	        board[r][c] = '.';
	        return false;
	    }
	    public void solveSudoku2(char[][] board) {
	        
	        row = new boolean[9][10];
	        col = new boolean[9][10];
	        grid = new boolean[9][10];
	        for(int i = 0; i < 9; i++)
	            for(int j = 0; j < 9; j++)
	                if(board[i][j] != '.'){
	                    row[i][board[i][j] - '0'] = true;
	                    col[j][board[i][j] - '0'] = true;
	                    grid[i / 3 * 3 + j / 3][board[i][j] - '0'] = true;
	                }
	        dfs(0, board);
	    }
}