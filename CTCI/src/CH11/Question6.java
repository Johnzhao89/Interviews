package CH11;
import java.util.*;
import CtCILibrary.*;


public class Question6{
	// from top right to bottom left
	public static boolean findElement0(int[][] matrix, int elem){
		int row =0;
		int col = matrix[0].length-1;
		while(row < matrix.length && col >=0){
			if(matrix[row][col]== elem){
				System.out.println("find at ("+row+", "+col+").");
				return true;
			}else if(matrix[row][col]>elem){
				col--;
			}else{
				row++;
			}
		}
		return false;
	}
	
	static class Coordinate implements Cloneable{
		public int row;
		public int column;
		public Coordinate(int r, int c){
			row = r;
			column = c;
		}
		public boolean inbounds(int[][] matrix){
			return row>=0 && row< matrix.length && column >= 0&& column < matrix[0].length;
		}
		public boolean isBefore(Coordinate p){
			return row <=p.row && column <= p.column;
		}
		public Object clone(){
			return new Coordinate(row, column);
		}
		public void moveDownRight(){
			row++;
			column++;
		}
		public void setToAverage(Coordinate min, Coordinate max){
			row = (min.row + max.row) / 2;
			column = (min.column + max.column) / 2;
		}
	}
	
	public static Coordinate findElement1(int[][] matrix, int x){
		Coordinate origin = new Coordinate(0,0);
		Coordinate dest = new Coordinate(matrix.length-1, matrix[0].length-1);
		return findElement1(matrix, origin, dest, x);
	}
	
	public static Coordinate findElement1(int[][] matrix, Coordinate origin, Coordinate dest, int x){
		if(!origin.inbounds(matrix)||!dest.inbounds(matrix)){
			return null;
		}
		if(matrix[origin.row][origin.column]==x){
			return origin;
		}else if(!origin.isBefore(dest)){
			return null;
		}
		
		Coordinate start = (Coordinate) origin.clone();
		int diagDist = Math.min(dest.row-origin.row, dest.column - origin.column);
		Coordinate end = new Coordinate(start.row+diagDist, start.column+diagDist);
		Coordinate p = new Coordinate(0,0);
		
		while(start.isBefore(end)){
			p.setToAverage(start, end);
			if(x> matrix[p.row][p.column]){
				start.row = p.row +1;
				start.column = p.column +1; 
			}else{
				end.row = p.row -1;
				end.column = p.column -1;
			}
		}
		return partitionAndSearch(matrix, origin, dest, start, x);
	}
	
	public static Coordinate partitionAndSearch(int[][] matrix, Coordinate origin, Coordinate dest, Coordinate pivot, int elem){
		Coordinate lowerLeftOrigin = new Coordinate(pivot.row, origin.column);
		Coordinate lowerLeftDest = new Coordinate(dest.row, pivot.column - 1);
		Coordinate upperRightOrigin = new Coordinate(origin.row, pivot.column);
		Coordinate upperRightDest = new Coordinate(pivot.row - 1, dest.column);
		
		Coordinate lowerLeft = findElement1(matrix, lowerLeftOrigin, lowerLeftDest, elem);
		if (lowerLeft == null) {
			return findElement1(matrix, upperRightOrigin, upperRightDest, elem);
		}
		return lowerLeft;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{15, 30,  50,  70,  73}, 
				 	 	  {35, 40, 100, 102, 120},
				 	 	  {36, 42, 105, 110, 125},
				 	 	  {46, 51, 106, 111, 130},
				 	 	  {48, 55, 109, 140, 150}};
	
		AssortedMethods.printMatrix(matrix);
		int m = matrix.length;
		int n = matrix[0].length;
		
		int count = 0;
		int littleOverTheMax = matrix[m - 1][n - 1] + 10;
		for (int i = 0; i < littleOverTheMax; i++) {
			Coordinate c = findElement1(matrix, i);
			if (c != null) {
				System.out.println(i + ": (" + c.row + ", " + c.column + ")");
				count++;
			}
		}
		System.out.println("Found " + count + " unique elements.");
	}
}