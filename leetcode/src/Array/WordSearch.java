package Array;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 The word can be constructed from letters of sequentially adjacent cell, 
 where "adjacent" cells are those horizontally or vertically neighboring. 
 The same letter cell may not be used more than once.
 * @author heguangliu
 *
 */
import java.util.*;

public class WordSearch {
	// HashMap not a good choice, because not dup
	// DFS
	public boolean exist(char[][] board, String word) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (board == null || board.length == 0 || board[0].length == 0)
			return false;
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++)
				if (existDfs(board, i, j, word, visited))
					return true;
		}
		return false;
	}

	public boolean existDfs(char[][] board, int i, int j, String word,
			boolean[][] visited) {
		if (word.length() == 0 || word.length() == 1
				&& word.charAt(0) == board[i][j])
			return true;
		if (word.charAt(0) != board[i][j])
			return false;
		visited[i][j] = true;
		String subWord = word.substring(1);
		boolean found = (i + 1 < board.length && !visited[i + 1][j] ? existDfs(
				board, i + 1, j, subWord, visited) : false)
				|| (i - 1 >= 0 && !visited[i - 1][j] ? existDfs(board, i - 1,
						j, subWord, visited) : false)
				|| (j + 1 < board[i].length && !visited[i][j + 1] ? existDfs(
						board, i, j + 1, subWord, visited) : false)
				|| (j - 1 >= 0 && visited[i][j - 1] ? existDfs(board, i, j - 1,
						subWord, visited) : false);
		if (found == true) {
			return found;
		} else {
			visited[i][j] = false;
			return false;
		}
	}
}