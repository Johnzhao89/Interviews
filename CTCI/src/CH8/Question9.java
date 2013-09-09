package CH8;

/**
 * Explain the data structures and algorithms that you would use to design an
 * in-memory file system. Illustrate with an example in code where possible. * @author
 * heguangliu
 * 
 */
import java.util.*;
abstract class Entry{
	protected String name;
	protected Directory parent;
	protected long created;
	protected long lastUpdated;
	protected long lastAccessed;
	public abstract int size();
	public Entry(String n, Directory p){
		name =n;
		parent =p;
		created = System.currentTimeMillis();
	}
	public boolean delete(){
		if(parent == null){
			return false;
		}
		return parent.deleteEntry(this);
	}
	public String getFullPath(){}
	public void changename(String n){}
	public String getName(){}
	public long getCreationTime(){}
	public long getLastUpdatedTime(){}
	public long getLastaccessedTime(){}
}
class Directory extends Entry{
	protected ArrayList<Entry> contents;
	public Directory(String n, Directory p){
		super(n,p);
		contents = new ArrayList<Entry>();
	}
	protected ArrayList<Entry> getContents(){}
	public int size(){}
	public int numberOfFiles(){}
	public boolean deleteEntry(Entry entry){}
	public deleteEntry(Entry entry){}
	public void addEntry(Entry entry){}
}
class File extends Entry{
	private String content;
	private int size;
	public File(String n, Directory p, int sz){
	}
	public int size(){}
	public String getContents(){}
	public void setContents(String c){}
}


public class Question9 {
	public static void main(String[] args) {
		Directory root = new Director("Food", null);
		File taco = new File("Taco", root, null);
		File hamburger = new File("Hamburger", root, 9);
		root.addEntry(taco);
		root.addEntry(hamburger);
		Directory healthy = new Directory("Healthy", root);
		Directory fruits = new Directory("Fruits", healthy);
		File apple = new File("Apple", fruits, 5);
		File banana = new File("Banana", fruits, 6);
		fruits.addEntry(apple);
		fruits.addEntry(banana);
		healthy.addEntry(fruits);

		Directory veggies = new Directory("Veggies", healthy);
		File carrot = new File("Carrot", veggies, 6);
		File lettuce = new File("Lettuce", veggies, 7);
		File peas = new File("Peas", veggies, 4);
		veggies.addEntry(carrot);
		veggies.addEntry(lettuce);
		veggies.addEntry(peas);

		healthy.addEntry(veggies);

		root.addEntry(healthy);

		System.out.println(root.numberOfFiles());
		System.out.println(veggies.getFullPath());
	}
}