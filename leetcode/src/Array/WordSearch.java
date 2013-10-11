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
	
	// Preprocess map one
	public boolean exist2(char[][] board, String word){
		HashMap<Character, ArrayList<Integer>> map = preprocess(board);
		if(!map.containsKey(word.charAt(0))) return false;
		boolean[] visited = new boolean[board.length*board[0].length];
		for(int node: map.get(word.charAt(0))){
			if(expand(map, node, visited, word,1, board[0].length)) return true;
		}
		return false;
	}
	
	private boolean expand(HashMap<Character, ArrayList<Integer>> map, int preNode, boolean[] visited, String word, int cur, int m){
		if(cur == word.length()) return true;
		if(!map.containsKey(word.charAt(cur))) return false;
		visited[preNode] = true;
		for(int node: map.get(word.charAt(cur))){
			if(!visited[node] && isAdjacent(preNode, node, m)&& expand(map, node, visited, word, cur+1, m))
				return true;
		}
		visited[preNode] = false;
		return false;
	}
	private HashMap<Character, ArrayList<Integer>> preprocess(char[][] board){
		HashMap<Character, ArrayList<Integer>> map = new HashMap<Character, ArrayList<Integer>>();
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[0].length; j++){
				if(!map.containsKey(board[i][j])){
					map.put(board[i][j], new ArrayList<Integer>());
				}
				map.get(board[i][j]).add(i*board[0].length+j);
			}
		}
		return map;
	}
	
	private boolean isAdjacent(int n1, int n2, int m){
		int min = Math.min(n1, n2), max = Math.max(n1, n2);
		return ((max-min)==m || (max-min==1 && (max%m)!=0));
	}
	
	
}