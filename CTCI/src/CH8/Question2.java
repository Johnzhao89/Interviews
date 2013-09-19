package CH8;
/**
 * Imagine you have a call center with three levels of employees: respondent, manager, and director.
 *  An incoming telephone call must be first allocated to a respondent who is free. 
 *  If the respondent can't handle the call, he or she must escalate the call to a manager. 
 *  If the manager is not free or not able to handle it, then the call should be escalatedto 
 *  a director. Designthe classesand datastruc- turesforthisproblem.
 *  Implement a method dispatchCall()which assignsa call to the first available employee.
 * @author heguangliu
 *
 */

import java.util.*;
class CallHandler{
	List<List<Employee>> employeeLevels;
	List<List<Call>> callQueues;
	protected CallHandler(){
		
	}
	public static CallHandler getInstance(){
		
	}
	public Employee hetHandlerForCall(Call call){
		
	}
	public void dispatchCall(Caller caller){
		
	}
	public void dispatchCall(Call call){}
	public boolean assignCall(Employee emp){}
}

abstract class Employee{
	private Call currentCall = null;
	protected Rank rank;
	public Employee(){
		
	}
	public void receivedCall(Call call){
		
	}
	public void callCompleted(){
		
	}
	public void escalateAndReassign(){
		
	}
	public boolean assignNewCall(){
		
	}
	public boolean isFree(){
		
	}
	public Rank getRank(){
		
	}
}

class Respondent extends Employee{
	public Respondent(){
		rank=Rank.Responder;
	}
}

class Manager extends Employee{
	public Manager(){
		rank = Rank.Responder;
	}
}
class Director extends Employee{
	public Director(){
		rank=Rank.Director;
	}
}

class Call{
	private Rank rank;
	private Caller caller;
	private Employee handler;
	public Call(Caller c){
		
	}
	public void setHandler(Employee e){
		
	}
	public void reply(String message){
		
	}
	public Rank getRank(){
		
	}
	public void setRank(Rank r){
		
	}
	public Rank incrementRank(){
		
	}
	public void disconnect(){
		
	}
}

class Caller{
	private String name;
	private int userId;
	public Caller(int id, String nm){
		name =nm;
		userId= id;
	}
}

enum Rank{
	Responder(0),
	Manager(1),
	Director(2);
	private int value;
	private Rank(int v){
		value = v;
	}
	public int getValue(){
		return value;
	}
}


public class Question2{
	
	
	
	
}