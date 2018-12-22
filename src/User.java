
public class User implements IUser{
	private int ID;
	private String Name;
	private String Password;
	private String Notification;
	private int ItemID;
	
	public User() {
		
	}
	public User(int id, String name, String password) {
		this.ID = id;
		this.Name = name;
		this.Password = password;
	}
	@Override
	public int getID() {
		return this.ID;
	}
	@Override
	public String getName() {
		return this.Name;
	}
	@Override
	public void setID(int id) {
		this.ID = id;
	}
	@Override
	public void setName(String name) {
		this.Name = name;
	}
	@Override
	public String getPassword() {
		return this.Password;
	}
	@Override
	public void setPassword(String psw) {
		this.Password = psw;
	}
	@Override
	public void setNotification(String notification) {
		this.Notification = notification;
	}
	@Override
	public String getNotification() {
		return this.Notification;
	}
	
}
