package CH9;
import java.awt.*;
import java.util.*;
import CtCILibrary.*;

public class Question2{
	public static int[][] maze = new int[10][10];
	
	public static boolean isFree(int x, int y){
		if(maze[x][y]==0){
			return false;
		}else{
			return true;
		}
	}
	// top to bottom
	public static boolean getPath0(int x, int y, ArrayList<Point> path){
		Point p = new Point(x, y);
		if(x ==0 && y ==0){
			return true;
		}
		boolean success = false;
		if(x>=1 && isFree(x-1, y)){
			success = getPath0(x-1, y, path);
		}
		if(!success && y>=1 && isFree(x, y-1)){
			success = getPath0(x, y-1, path);
		}
		if(success){
			path.add(p);
		}
		return success;
	}
	
	public static boolean getPath1(int x, int y , ArrayList<Point> path, HashMap<Point, Boolean> cache){
		Point p = new Point(x, y);
		if(cache.containsKey(p)){
			return cache.get(p);
		}
		if(x==0 && y==0){
			cache.put(new Point(0,0), true);
			return true;
		}
		boolean success = false;
		if(x>=1 && isFree(x-1, y)){
			success = getPath1(x-1, y, path, cache);
		}
		if(!success && y >=1 && isFree(x, y-1)){
			success = getPath1(x, y-1, path , cache);
		}
		if(success){
			path.add(p);
		}
		cache.put(p, success);
		return success;
	}
	
	public static void main(String[] args){
		maze = AssortedMethods.randomMatrix(10, 10, 0, 5);
		AssortedMethods.printMatrix(maze);
		ArrayList<Point> path = new ArrayList<Point>();
		HashMap<Point, Boolean> cache = new HashMap<Point, Boolean>();
		boolean success = getPath1(9,9,path, cache);
		if(success){
			String s = AssortedMethods.listOfPointsToString(path);
			System.out.println(s);
		}else{
			System.out.println("No path found.");
		}
	}
}