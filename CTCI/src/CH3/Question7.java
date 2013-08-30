package CH3;

import java.util.*;
import CtCILibrary.*;

/**
 * 
 * @author heguangliu
 *
 */
public class Question7{
	abstract static class Animal{
		private int order;
		protected String name;
		public Animal(String n){
			name =n;
		}
		public void setOrder(int order){
			this.order = order;
		}
		public int getOrder(){
			return order;
		}
		public boolean isOlderThan(Animal a){
			return this.order<a.getOrder();
		}
		public abstract String name();
	}
	static class Cat extends Animal{
		public Cat(String n) {
			super(n);
		}
		public String name(){
			return "Cat: "+name;
		}
	}
	static class Dog extends Animal{
		public Dog(String n){
			super(n);
		}
		public String name(){
			return "Dog: "+name;
		}
	}
	Queue<Dog> dogs = new LinkedList<Dog>();
	Queue<Cat> cats = new LinkedList<Cat>();
	private int order=0;
	
	public void enqueue(Animal a){
		a.setOrder(order);
		order++;
		if(a instanceof Dog){
			dogs.offer((Dog) a);
		}else if(a instanceof Cat){
			cats.offer((Cat) a);
		}
	}
	public Animal dequeueAny(){
		if(dogs.size()==0){
			return dequeueCats();
		}else if(cats.size()==0){
			return dequeueDogs();
		}
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if(dog.isOlderThan(cat)){
			return dogs.poll();
		}else{
			return cats.poll();
		}
	}
	public Animal peek(){
		if (dogs.size() == 0) {
			return cats.peek();
		} else if (cats.size() == 0) {
			return dogs.peek();
		}
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if (dog.isOlderThan(cat)) {
			return dog;
		} else {
			return cat;
		}
	}
	public int size(){
		return dogs.size() + cats.size();
	}
	public Dog dequeueDogs(){
		return dogs.poll();
	}
	public Dog peekDogs(){
		return dogs.peek();
	}
	public Cat dequeueCats(){
		return cats.poll();
	}
	public Cat peekCats(){
		return cats.peek();
	}
	
	public static void main(String[] args) {
		Question7 animals = new Question7();
		animals.enqueue(new Cat("Callie"));
		animals.enqueue(new Cat("Kiki"));
		animals.enqueue(new Dog("Fido"));
		animals.enqueue(new Dog("Dora"));
		animals.enqueue(new Cat("Kari"));
		animals.enqueue(new Dog("Dexter"));
		animals.enqueue(new Dog("Dobo"));
		animals.enqueue(new Cat("Copa"));
		
		System.out.println(animals.dequeueAny().name());	
		System.out.println(animals.dequeueAny().name());	
		System.out.println(animals.dequeueAny().name());	
		
		animals.enqueue(new Dog("Dapa"));
		animals.enqueue(new Cat("Kilo"));
		
		while (animals.size() != 0) {
			System.out.println(animals.dequeueAny().name());	
		}
	}
}