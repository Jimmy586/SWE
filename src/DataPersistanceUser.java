import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class DataPersistanceUser {
	private String Connection;
	
	public DataPersistanceUser(String connection) {
		this.Connection = connection;
		File f = new File(connection);
		if(!(f.exists() && f.isDirectory())) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void save() {
		
	}
	public User load(String name) {
		User user = null;
		List<String> users = null;
		try {
			users = Files.readAllLines(new File(this.Connection).toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(String usr : users) {
			String[] usrarr = usr.split("~");
			if(usrarr[1].equals(name)) {
				user = new User((Integer.valueOf(usrarr[0])), usrarr[1], usrarr[2],(Integer.valueOf(usrarr[3])));
				user.setNotification(usrarr[4]);
			}
			
		}
		return user;
	}
	
	public User load(int id) {
		User user = null;
		List<String> users = null;
		try {
			users = Files.readAllLines(new File(this.Connection).toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(String usr : users) {
			String[] usrarr = usr.split("~");
			if(usrarr[0].equals(String.valueOf(id))) {
				user = new User((Integer.valueOf(usrarr[0])), usrarr[1], usrarr[2],(Integer.valueOf(usrarr[3])));
				user.setNotification(usrarr[4]);
			}
			
		}
		if(user != null) System.out.println(user.getID()+" : "+user.getName()+";");
		return user;
	}
	
	public void save(User user) {
		String usrstr = "";
		usrstr += user.getID();
		usrstr += "~"+user.getName();
		usrstr += "~"+user.getPassword();
		usrstr += "~"+user.getTelNumber();
		usrstr += "~"+user.getNotification();
		usrstr += "\n";
		
		try {
			Files.write(new File(this.Connection).toPath(), usrstr.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}