public class ShowProperties{
	public static void main(String[] args){
		//displays all of the ˇ°propertiesˇ± from the system where you are running the program
		System.getProperties().list(System.out);
		System.out.println(System.getProperty("user.name"));
		System.out.println(
				System.getProperty("java.library.path"));
	}
}