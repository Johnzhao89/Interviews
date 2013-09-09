package CH8;
/**
 * Design a musicaljukebox using object-oriented principles.
 *  @author heguangliu
 * Terrible design
 */

class JukeBox{
	private CDPlayer cdPlayer;
	private User user;
	private Set<CD> cdCollection;
	private SongSelector ts;
	public JukeBox(CDPlayer cdPlayer, User user, Set<CD> cdCollection, SongSelector ts){
		
	}
	public Song getCurrentSong(){
		
	}
	public setUser(User u){
		
	}
}
class Song{
	private String songName;
}
class CD{} 
class CDPlayer{
	private Playlist p;
	private CD c;
	public Playlist getPlaylist(){}
	public CD getCD(){}
	public void playSong(Song s){}
}
class SongSelector{
	private Song currentSong;
	public SongSelector(Song s){}
	public void setSong(Song s){}
	public Song getCurrentSong(){}
}
class Playlist{
	private Song song;
	private Queue<Song> queue;
	public Playlist(Song song, Queue<Song> queue){
		
	}
	public Song getNextSongToPlay(){}
	public void queueUpSong(Song s){}
}
class User{
	private String name;
	private long ID;
	public String getName(){}
	public void setName(String nm){}
	public long getID(){}
	public void setID(){}
	public User getUser{}
	public static User addUser(String name, long ID){}
}
public class Question3{
	
}