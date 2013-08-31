package CommDS;
import java.util.*;
/**
 * 
 * @author heguangliu
 *
 */
public class Graph_AdjMatrix{
	private int size;
	private Vertex[] vertexList;
	private int[][] adjMatrix;
	private int numVertices;
	private Stack<Integer> stack;
	private Queue<Integer> q;
	
	public Graph_AdjMatrix(int s){
		size = s;
		vertexList = new Vertex[size];
		numVertices =0;
		adjMatrix = new int[s][s];
		
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++){
				adjMatrix[i][j] =0;
			}
		}
	}
	
	public void addVertex(char label){
		vertexList[numVertices++]= new Vertex(label);
	}
	
	public void addEdge(int start, int end){
		adjMatrix[start][end]=1;
		adjMatrix[end][start]=1;
	}
	
	public void displayVertex(int v){
		System.out.print(vertexList[v].getLabel()+" ");
	}
	
	public void DFS(){
		stack = new Stack<Integer>();
		vertexList[0].visit();
		displayVertex(0);
		stack.push(0);
		while(!stack.isEmpty()){
			int v= getAdjUnvisitedVertex(stack.peek());
			if(v == -1)
				stack.pop();
			else{
				vertexList[v].visit();
				displayVertex(v);
				stack.push(v);
			}
		}
		reset();
	}
	
	public void BFS(){
		q = new LinkedList<Integer>();
		vertexList[0].visit();
		displayVertex(0);
		q.offer(0);
		int v2;
		
		while(!q.isEmpty()){
			int v1 = q.poll();
			while((v2 = getAdjUnvisitedVertex(v1)) != -1){
				vertexList[v2].visit();
				displayVertex(v2);
				q.offer(v2);
			}
		}
		reset();
	}
	
	public int getAdjUnvisitedVertex(int v){
		for(int i=0; i<numVertices; i++){
			if(adjMatrix[v][i]==1 && vertexList[i].visited==false){
				return i;
			}
		}
		return -1;
	}
	
	private void reset(){
		for(int i=0; i<numVertices; i++){
			vertexList[i].reset();
		}
	}
	
	
	
	public class Vertex{
		private char label;
		private boolean visited;
		
		public Vertex(char lebel){
			this.label = label;
			visited = false;
		}
		
		public char getLabel(){
			return label;
		}
		
		public void visit(){
			visited = true;
		}
		
		public void reset(){
			visited = false;
		}
	}
}