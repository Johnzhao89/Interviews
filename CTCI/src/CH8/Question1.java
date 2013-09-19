package CH8;
/**
 * Design the data structures for a generic deck of cards. 
 * Explain how you would subclass the data s
 * tructures to implement blackjack.
 * @author heguangliu
 *
 */

import java.util.*;
abstract class Card{
	private boolean available = true;
	protected int faceValue;
	protected Suit suit;
	public Card(int c, Suit s){
		
	}
	public abstract int value();
	public Suit suit(){
		
	}
	public boolean isAvailable(){
		
	}
	public void markUnavailable(){
		
	}
	public void markAvailable(){
		
	}
	public void print(){
		
	}
}

class BlackJackCard extends Card{
	public BlackJackCard(int c, Suit s){
		super(c,s);
	}
	public int value(){
		
	}
	public int minValue(){
		
	}
	public int maxValue(){
		
	}
	public boolean isAce(){
		
	}
	public boolean isFaceCard(){
		
	}
}

class Hand<T extends Card>{
	protected ArrayList<T> cards = new ArrayList<T>();
	public int score(){
		
	}
	public void addCard(T card){
		
	}
	public void print(){
		
	}
}

class BlackJackHand extends Hand<BlackJackCard>{
	public BlackJackHand(){
		
	}
	public int score(){
		
	}
	private ArrayList<Integer> possibleScores(){
		
	}
	private void addCardToScoreList(BlackJackCard card, ArrayList<Integer> scores){
		
	}
	public boolean busted(){
		
	}
	public boolean is21(){
		
	}
	public boolean isBlackJack(){
		
	}
}

class Deck <T extends Card>{
	private ArrayList<T> cards;
	private int dealtIndex =0;
	public Deck(){
		
	}
	public void setDeckOfCards(ArrayList<T> deckOfCards){
		
	}
	public void shuffle(){
		
	}
	public int remainingCards(){
		
	}
	public T[] dealHand(int number){
		
	}
	public T dealCard(){
		
	}
}

enum Suit{
	Club(0),Diamond(1),Heart(2), Spade(3);
	private int value;
	private Suit(int v) {
		value = v;
	}
	
	public int getValue() {
		return value;
	}
	
	public static Suit getSuitFromValue(int value) {
		switch (value) {
		case 0:
			return Suit.Club;
		case 1:
			return Suit.Diamond;
		case 2:
			return Suit.Heart;
		case 3: 
			return Suit.Spade;
		default:
				return null;
		}
	}
}


class BlackJackGameAutomator{
	private Deck<BlackJackCard> deck;
	private BlackJackHand[] hands;
	private static final int HIT_UNTIL = 16;
	public BlackJackGameAutomator(int numPlayers){
		
	}
	public boolean dealInitilal(){
		
	}
	public ArrayList<Integer> getBlackJacks(){
		
	}
	public boolean playHand(int i){
		
	}
	public boolean playHand(BlackJackHand hand){}
	public boolean playAllHands(){}
	public ArrayList<Integer> getWinners(){}
	public void initializeDeck(){}
	public void printHandsAndScore() {}
}





public class Question1{
	static class BlackJackGameAutomator{
		public BlackJackGameAutomator(int numPlayers){
			
		}
	}
	
	public static void main(String[] args){
		int numHands=5;
		BlackJackGameAutomator automator = new BlackJackGameAutomator(numHands);
		automator.initializeDeck();
		boolean success = automator.dealInitial();
		if(!success){
			System.out.println("Error. Out of cards.");
		}else{
			System.out.println("\n-- Completed Game --");
			automator.printHandsAndScore();
			ArrayList<Integer> blackjacks = automator.getBlackJacks();
			ArrayList<Integer> winners = automator.getWinners();
			if(winners.size()>0){
				System.out.print("Winners: ");
				for (int i : winners) {
					System.out.print(i + ", ");
				}
			}else{
				System.out.println("Draw. All players have busted.");
			}
		}
	}
}