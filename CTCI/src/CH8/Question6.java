package CH8;
/**
 * Implement ajigsaw puzzle. Design the data structuresand explain an algorithm tosolvethepuzzle.YoucanassumethatyouhaveafitsWith method which,
when passed two puzzle pieces, returns true if the two pieces belong together.
 * @author heguangliu
 * need further modification, like color match, image match
 */
class Piece{
	Edge[] edges;
	boolean isCorner(){}
}
class Edge{
	enum Type{inner, outer, flat}
	Piece parent;
	Type type;
	int index;
	Edge attached_to;
	boolean fitsWith(Edge edge)
}
class Puzzle{
	Piece[] pieces;
	Piece[][] solution;
	Edge[] inners, outers, flats;
	Piece[] corners;
	void solve(){}
	void sort(){}
	
}
public class Question6{
	
}