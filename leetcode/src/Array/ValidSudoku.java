package Array;
/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
   The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * @author heguangliu
 *
 */
public class ValidSudoku{
	public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(board == null || board.length != 9 || board[0].length != 9 )
        	return false;
        
        // check row
        for(int i = 0; i < 9; i++){
        	boolean[] row = new boolean[9];
        	for(int j = 0; j < 9; j++){
        		if(!check(board[i][j], row))
        			return false;
        	}
        }
        
        // check column
        for(int j =0; j< 9; j++){
        	boolean[] column = new boolean[9]; 
        	for(int i =0; i< 9; i++){
        		if(!check(board[i][j], column))
        			return false;
        	}
        }
        
        // check block
        for(int row = 0; row<9; row+=3){
        	for(int col = 0; col < 9; col += 3){
        		boolean[] block = new boolean[9];
        		for(int i=0; i< 3; i++)
        			for(int j =0; j< 3; j++){
        				if(!check(board[row+i][col+j], block))
        				return false;
        			}
        	}
        }
        return true;
    }
	
	boolean check(char a, boolean[] array){
		if(a =='.')
			return true;
		else if(a>='1' && a<='9'){
			if(array[a-'1'] == true)
				return false;
			array[a - '1']= true;
			return true;
		}else
			return false;
			
	}
}