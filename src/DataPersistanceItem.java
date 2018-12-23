

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class DataPersistanceItem {
	String connection;
	Category cat;
	DataPersistanceItem(String connection){
		this.connection=connection;
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
	
	void save(Item item, User user)
	{				
		String str = new String();
		str += Item.ItemID;
		str += "-"+user.getID();
		str += "-"+item.category.name;
		str += "-"+item.name;
		str += "-"+item.description;
		for(int i = 0; i < 5; i++)
		{
			str += "-"+item.questions.question.get(i);
			str += "-"+item.questions.answer.get(i);
		}
		str += "-"+Boolean.toString(item.claim);
		try {
			Files.write(new File(this.connection).toPath(), str.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
