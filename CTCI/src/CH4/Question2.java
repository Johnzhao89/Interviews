package CH4;
import java.util.*;
import CtCILibrary.*;

/**
 * 
 * @author heguangliu
 *
 */
public class Question2{
	public enum State{
		Unvisited, Visited, Visiting;
	}
	private Node adjacent[];
	public int adjacentCount;
	private String vertex;
	public State state;
	
	class Node{
		private Node adjacent[];
		public int adjacentCount;
		private String vertex;
		public State state;
		public Node(String vertex, int adjacentLength){
			
		}
	}
	
}