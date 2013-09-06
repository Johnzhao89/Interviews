package CH9;
import java.util.*;
import CtCILibrary.*;

public class Question9{
	public static int GRID_SIZE=8;
	
	public static boolean checkValid(Integer[] columns, int row1, int column1){
		for(int row2=0; row2<row1; row2++){
			int column2= columns[row2];
			if(column1==column2){
				return false;
			}
			int columnDistance = Math.abs(column2-column1);
			int rowDistance = row1- row2;
			if(columnDistance == rowDistance){
				return false;
			}
		}
		return true;
	}
	
	//placeQueens(0, columns, results);
	public static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results){
		if(row == GRID_SIZE){
			results.add(columns.clone());
		}else{
			for(int col=0; col<GRID_SIZE; col++){
				if(checkValid(columns,row, col)){
					columns[row]=col;
					placeQueens(row+1, columns, results);
				}
			}
		}
	}
	
	public static void clear(Integer[] columns) {
		for (int i = 0; i < GRID_SIZE; i++) {
			columns[i] = -1;
		}
	}
	
	public static void printBoard(Integer[] columns) {
		System.out.println("-----------------");
		for(int i = 0; i < GRID_SIZE; i++){
			System.out.print("|");
			for (int j = 0; j < GRID_SIZE; j++){
			    if (columns[i] == j) {
			    	System.out.print("Q|");
			    } else {
			    	System.out.print(" |");
			    }
			}
			System.out.println("\n-----------------");
		}
		System.out.println("");
	}
	
	public static boolean equals(Integer[] first, Integer[] second) {
		for (int k = 0; k < GRID_SIZE; k++) {
			if (first[k] != second[k]) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isUnique(ArrayList<Integer[]> boards, int index) {
		Integer[] first = boards.get(index);
		for (int i = 0; i < index; i++) {
			Integer[] second = boards.get(i);
			if (equals(first, second)) {
				return false;
			}
		}
		return true;
	}
	
	public static void checkBoard(Integer[] columnsForRow) {
		for (int i = 0; i < GRID_SIZE; i++) {
			
		}
	}
	
	public static void printBoards(ArrayList<Integer[]> boards) {
		for (int i = 0; i < boards.size(); i++) {
			Integer[] board = boards.get(i);
			printBoard(board);
		}
	}
	   
	public static void main(String[] args) {
		ArrayList<Integer[]> results = new ArrayList<Integer[]>();
		Integer[] columns = new Integer[GRID_SIZE];
		clear(columns);
		placeQueens(0, columns, results);
		printBoards(results);
		System.out.println(results.size());
	}
	
	
}


