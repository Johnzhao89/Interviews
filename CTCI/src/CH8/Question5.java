package CH8;
/**
 * Design the data structures for an online book reader system.
 * @author heguangliu
 *
 */
import java.util.*;
class OnlineReaderSystem{
	private Library library;
	private UserManager userManager;
	private Display display;
	public Library getLibrary(){}
	public UserManager getUserManager(){}
	public Display getDisplay(){}
}
class Library{
	private HashMap<Integer, Book> books;
	public Book addBook(int id, String details){}
	public boolean remove(Book b){}
	public boolean remove(int id){}
	public Book find(int id){}
}
class Book{
	private int bookId;
	private String details;
	public Book(int id, String det){}
	public void update(){}
	public int getID(){}
	public void setID(int id){}
	public String getDetails(){}
	public void setDetails(String details){}
}
class UserManager{
	private HashMap<Integer, User> users;
	public User addUser(int id, String details, int accountType){}
	public boolean remove(User u){}
	public boolean remove(int id){}
	public User find(int id){}
}
enum Account{normal, VIP1, VIP2}
class User{
	private int userId;
	private String details;
	private Account accountType;
	public void renewMembership(){}
	public User(int id, String details, int accountType){}
}
class Display{
	private Book activeBook;
	private User activeUser;
	private int pageNumber=0;
	public void displayUser(User user){}
	public void displayBook(Book book){}
	public void turnPageForward(){}
	public void turnPageBackward(){}
}
class Question5{
	
}