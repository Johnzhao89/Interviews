package CH8;
/**
 * Othello is played as follows: Each Othello piece is white on one side and black
on the other. When a piece is surrounded by its opponents on both the left and
right sides,or both the top and bottom, it is said to be captured and its color is
flipped. On your turn, you must capture at least one of your opponent's pieces.
The game ends when either user has no more valid moves. The win is assigned
to the person with the most pieces. Implement the object-oriented design for
Othello. * @author heguangliu
 *
 */
import java.util.*;
class Automator{
	private Player[] players;
	private Player lastPlayer = null;
	public ArrayList<Location> remainingMoves = new ArrayList<Location>();
	private static Automator instance;
	private Automator(){
		
	}
	public static Automator getInstance(){}
	public void initialize(Player[] ps){}
	public void shuffler(){}
	public void removeLocation(int r, int c){}
	public Location getLocation(int index){}
	public boolean playRandom(){}
	public boolean isOver(){}
	public void printScores(){}
}
class Board{
	private int blackCount =0;
	private int whiteCount =0;
	private Piece[][] board;
	public Board(int rows, int columns){}
	public boolean placeColor(int row, int column, Color color){}
	private int flipSection(int row, int column, Color color,Direction d){}
	public int getScoreForColor(Color c){}
	public void updateScore(Color newColor, int newPieces){}
	public void printBoard(){}
}
class Game{
	private final int ROWS=10;
	private final int COLUMNS =10;
	private Player[] players;
	private static Game instance;
	private Board board;
	private Game(){
		board = new Board(ROWS, COLUMNS);
		players = new Player[2];
		players[0] = new Player(Color.Black);
		players[1] = new Player(Color.White);
		Automator.getInstance().initialize(players);
	}
	public static Game getInstance(){
		if(instance == null){
			instance = new Game();
		}
		return instance;
	}
	public Board getBoard(){
		return board;
	}
}
class Player{
	private Color color;
	public Player(Color c){
		color =c;
	}
	public int getScore(){
		return Game.getInstance().getBoard().getScoreForColor(color);
	}
	public boolean playPiece(int row, int column){
		return Game.getInstance().getBoard().placeColor(row, column, color);
	}
	public Color getColor(){
		return color;
	}
}
class Piece{
	private Color color;
	public Piece(Color c){color = c;}
	public void flip(){}
	public Color getColor(){}
}

enum Direction{left, right, up, down}
enum Color{White, Black}
class Location{
	private int row;
	private int column;
	public Location(int r, int c){
		row = r;
		column =c;
	}
	public boolean isSameAs(int r, int c){
		return row == r && column ==c;
	}
	public int getRow(){return row;}
	public int getColumn(){return column;}
}

public class Question8{
	
}