package Array;

/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region .

For example,

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
 * @author heguangliu
 *
 */

import java.util.*;
public class SurroundedRegions{
	// DFS
	public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(board == null || board.length == 0)
        	return;
        for(int i=0; i< board.length; i++){
        	DFS(i, 0, board);
        	DFS(i, board[0].length-1,board);
        }
        for(int i=0; i<board[0].length; i++){
        	DFS(0, i, board);
        	DFS(board.length-1, i, board);
        }
        for(int i=0; i< board.length; i++)
        	for(int j=0; j< board[0].length ; j++){
        		if(board[i][j]=='O')
        			board[i][j] ='X';
        		else if(board[i][j]=='A')
        			board[i][j]='O';
        	}
    }
	public void DFS(int x, int y, char[][] board){
		if(x<0 || y<0 || x>= board.length|| y>= board[0].length||board[x][y]!='O')
			return;
		board[x][y]='A';
		DFS(x-1 , y, board);
		DFS(x+1, y, board);
		DFS(x, y-1, board);
		DFS(x, y+1, board);
	}
	
	//BFS
	public static void solve2(char[][] board) {
		if(board==null || board.length == 0)
			return;
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0; i< board.length; i++){
			BFS(i, 0, board, queue);
			BFS(i, board[0].length-1, board, queue);
		}
		for(int i=0; i< board[0].length; i++){
			BFS(0, i, board, queue);
			BFS(board.length-1,i,board, queue );
		}
		for(int i=0; i< board.length; i++)
        	for(int j=0; j< board[0].length ; j++){
        		if(board[i][j]=='O')
        			board[i][j] ='X';
        		else if(board[i][j]=='A')
        			board[i][j]='O';
        	}
	}
	
	static void expand(int x, int y, char[][] board, Queue<Integer> queue){
		if(x < 0|| y<0|| x>= board.length || y>= board[0].length|| board[x][y]!='O')
			return;
		queue.offer(x*board.length+y);
		board[x][y]='A';
	}
	
	static void BFS(int x, int y, char[][] board, Queue<Integer> queue){
		expand(x, y, board,queue);
		while(!queue.isEmpty()){
			int row = queue.peek()/board.length;
			int col = queue.poll()%board.length;
			expand(row-1, col, board,queue);
			expand(row+1, col, board,queue);
			expand(row, col-1, board,queue);
			expand(row, col+1, board,queue);
		}
	}
	
	public static void main(String[] args){
		char[][] test = {{'O','O','O'},{'O','O','O'},{'O','O','O'}};
		solve2(test);
		
		System.out.println(Arrays.deepToString(test));
	}
	
}