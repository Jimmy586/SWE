package swe_phase3;

import java.io.FileWriter;
import java.io.IOException;

public class DataPersistanceItem {
	String connection;
	Category cat;
	
	void save(Item item, User user, String catName) throws IOException
	{
		cat = new Category(catName);
		cat.itemList.add(item);
		
		FileWriter fileWriter = new FileWriter(connection, true);
		
		fileWriter.write(item.ItemID);
		fileWriter.write("-");
		fileWriter.write(user.getID());
		fileWriter.write("-");
		fileWriter.write(item.category.name);
		fileWriter.write("-");
		fileWriter.write(item.name);
		fileWriter.write("-");
		fileWriter.write(item.description);
		fileWriter.write("-");
		for(int i = 0; i < 5; i++)
		{
			fileWriter.write(item.questions.question.get(i));
			fileWriter.write("-");
			fileWriter.write(item.questions.answer.get(i));
			fileWriter.write("-");
		}
		fileWriter.write(Boolean.toString(item.claim));
	}
	
}
