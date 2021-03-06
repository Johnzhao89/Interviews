package CtCILibrary;
import java.util.*;

public class TrieNode{
	private LinkedList <TrieNode> children;
	private boolean terminates = false;
	private char character;
	
	public TrieNode(){
		children = new LinkedList<TrieNode>();
	}
	
	public TrieNode(char charater){
		this();
		this.character = character;
	}
	
	public char getChar(){
		return character;
	}
	
	public void addWord(String word){
		if(word ==null || word.isEmpty()){
			return;
		}
		TrieNode child;
		char firstChar = word.charAt(0);
		TrieNode t = getChild(firstChar);
		
		if(t == null){
			child = new TrieNode(firstChar);
			children.add(child);
		}else{
			child = t;
		}
		
		if(word.length()>1){
			child.addWord(word.substring(1));
		}else{
			child.setTerminates(true);
		}
	}
	
	TrieNode getChild(char c){
		for(TrieNode t: children){
			if(t.getChar() == c){
				return t;
			}
		}
		return null;
	}
	
	public boolean terminates(){
		return terminates;
	}
	
	public void setTerminates(boolean t){
		terminates = t;
	}
}



