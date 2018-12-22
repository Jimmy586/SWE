
public class Main {
	public static void main(String args[]) {
		User user = new User(1, "user1", "12345");
		//user.setNotification("Sample Nitification");
		
		DataPersistanceUser ud = new DataPersistanceUser(System.getProperty("user.dir")+"/user_data.txt");
		//ud.save(user);
		user = ud.load("user1");
		if(user != null) System.out.println(user.getID()+" "+user.getName()+" "+user.getPassword()+" "+user.getNotification());
	}
}
