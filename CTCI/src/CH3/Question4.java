package CH3;

import java.util.*;
import CtCILibrary.*;

/**
 * 
 * @author heguangliu
 *
 */
public class Question4{
	static class Tower{
		private Stack<Integer> disks;
		private int index;
		
		public Tower(int i){
			disks= new Stack<Integer>();
			index =i;
		}
		
		public int index(){
			return index;
		}
		
		public void add(int d){
			if(!disks.isEmpty() && disks.peek()<=d){
				System.out.println("Error placing disk "+d);
			}else{
				disks.push(d);
			}
		}
		
		public void moveTopTo(Tower t){
			int top = disks.pop();
			t.add(top);
		}
		
		public void print(){
			System.out.println("Contents of Tower "+ index()+": " + disks.toString());
		}
		
		public void moveDisks(int n, Tower destination, Tower buffer){
			if(n > 0){
				moveDisks(n-1, buffer, destination);
				System.out.println("Stage 1:");
				this.print();
				buffer.print();
				destination.print();
				moveTopTo(destination);
				System.out.println("Stage 2:");
				this.print();
				buffer.print();
				destination.print();
				buffer.moveDisks(n-1, destination, this);
				System.out.println("Stage 3:");
				this.print();
				buffer.print();
				destination.print();
			}
		}
	}
	
	public static void main(String[] args){
		int n=5;
		Tower[] towers = new Tower[3];
		for(int i = 0; i< 3; i++){
			towers[i]= new Question4.Tower(i);
		}
		for(int i = n-1; i>=0 ; i--){
			towers[0].add(i);
		}
		towers[0].moveDisks(n, towers[2], towers[1]);
	}
}