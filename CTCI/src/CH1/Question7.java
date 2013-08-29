package CH1;
/**
 * 
 * @author heguangliu
 *
 */
import java.util.*;
import CtCILibrary.AssortedMethods;

public class Question7{
	//use bit vector, time efficient
	public static void setZeros0(int[][] matrix){
		int[] rowVec= new int[matrix.length%32==0? matrix.length/32:matrix.length/32+1];
		int[] columnVec= new int[matrix[0].length%32==0? matrix[0].length/32: matrix[0].length/32+1];
		for(int i=0;i<matrix.length; i++){
			for(int j=0; j<matrix[0].length;j++){
				if(matrix[i][j]==0){
					rowVec[i/32] =rowVec[i/32]|(1<<i);
					columnVec[j/32]= columnVec[i/32]|(1<<j);
				}
			}
		}
		
		for(int i=0; i<matrix.length;i++){
			for(int j=0; j<matrix[0].length;j++){
				if((((rowVec[i/32]>>(i%32)) &1) ==1)||((columnVec[j/32]>>(j%32))&1)==1){
					matrix[i][j]=0;
				}
			}
		}
	}
	//use TreeSet , space efficient
	public static void setZero1(int[][] matrix){
		Set<Integer> rowSet = new TreeSet<Integer>();
		Set<Integer> columnSet= new TreeSet<Integer>();
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				if(matrix[i][j]==0){
					rowSet.add(i);
					columnSet.add(j);
				}
			}
		}
		
		for(int i=0;i<matrix.length;i++){
			for(int j=0; j<matrix[0].length;j++){
				if(rowSet.contains(i)||columnSet.contains(j)){
					matrix[i][j]=0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = AssortedMethods.randomMatrix(3, 5, 0, 5);
		int[][] matrix1 = AssortedMethods.randomMatrix(3, 5, 0, 5);
		AssortedMethods.printMatrix(matrix);
		System.out.println();
		setZeros0(matrix);
		AssortedMethods.printMatrix(matrix);
		System.out.println();
		
		AssortedMethods.printMatrix(matrix1);
		setZero1(matrix1);
		System.out.println();
		AssortedMethods.printMatrix(matrix1);
		//AssortedMethods.printMatrix(matrix);
	}
}