package CH8;
/**
 * Explain how you would design a chat server. In particular, provide details about
 the various backend components, classes, and methods. What would be the
 hardest problems to solve?
 * @author heguangliu
 *
 */
import java.util.*;
class UserManager{
	private static UserManager instance;
	private HashMap<Integer, User> usersById=new HashMap<Integer, User>();
	private HashMap<String, User> usersByAccountName = new HashMap<String, User>();
	private HashMap<Integer, User> onlineUsers = new HashMap<Integer, User>();
	
	public static UserManager getInstance(){
		if(instance == null){
			instance = new UserManager();
		}
		return instance;
	}
	public void addUser(User fromUser, String toAccountName){
		
	}
	public void approveAddRequest(AddRequest req){
		
	}
	public void rejectAddRequest(AddRequest req){
		
	}
	public void userSignedOn(String accountName){
		
	}
	public void userSignedOff(String accoutName){
		
	}
}
enum UserStatusType{Offline, Away, Idle, Available, Busy}
class UserStatus{
	private String message;
	private UserStatusType type;
	public UserStatus(UserStatusType type, String message){}
	public UserStatusType getStatusType(){}
	public String getMessage(){}
}
class User{
	private int id;
	private UserStatus status = null;
	private HashMap<Integer, PrivateChat> privateChats = new HashMap<Integer, PrivateChat>();
	private ArrayList<GroupChat> groupChats = new ArrayList<GroupChat>();
	private HashMap<Integer, AddRequest> receivedAddRequests = new HashMap<Integer, AddRequest>();
	private HashMap<Integer, AddRequest> sentAddRequests = new HashMap<Integer, AddRequest>();
	
	private HashMap<Integer, User> contacts = new HashMap<Integer, User>(); 
	private String accountName;
	private String fullName;
	public User(int id, String accountName,String fullName){}
	public boolean sendMessageToUser(User toUser, String content){}
	public boolean sendMessageToGroupChat(int gropId,String content){}
	public void setStatus(UserStatus status){}
	public UserStatus getStatus(){}
	public boolean addContact(User user){}
	public void receivedAddRequest(AddRequest req){}
	public void sentAddRequest(AddRequest req){}
	public void removeAddRequest(AddRequest req){}
	public void requestAddUser(String accountName){}
	public void addConversion(PrivateChat conversation){}
	public void addConversation(GroupChat conversation) {}
	public int getId(){}
	public String getAccountName(){}
	public String getFullName(){}
}
enum RequestStatus{Unread, Read, Accepted, Rejected}
class Message{
	private String content;
	private Date data;
	public Message(String content, Date date){}
	public String getContent(){}
	public Date getDate(){}
}
abstract class Conversation{
	protected ArrayList<User> pariticipants = new ArrayList<User>();
	protected int id;
	protected ArrayList<Message> messages = new ArrayList<Message>();
	public ArrayList<Message> getMessage(){}
	public boolean addMessage(Message m){}
	public int getId(){}
}
class PrivateChat extends Conversation{
	public PrivateChat(User user1, User user2){}
	public User getOtherParticipant(User primary){}
}
class GroupChat extends Conversation{
	public void removeParticipant(User user){}
	public void addParticipant(User user){}
}
public class AddRequest{
	private User fromUser;
	private User toUser;
	private Date date;
	RequestStatus status;
	public AddRequest(User from, User to, Date date){}
	public RequestStatus getStatus(){}
	public User getFromUser(){}
	public User getToUser(){}
	public Date getDate(){}
}
public class Question7{
	
}