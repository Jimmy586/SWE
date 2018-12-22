package swe_phase3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PostItem {
	
	void post(User user) throws IOException
	{
		Item item = new Item();
		String[] categories = {"Electronic", "Academic", "Walet", "Bag", "Clothing", "Wearable", "Card"};
		ArrayList<String> question = new ArrayList<String>();
		ArrayList<String>  answer = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		int choice;
		String name = new String();
		String description = new String();

		int userID = user.getID();
		
		item.UserID = userID;
		
		System.out.println("Please choose a category");
		for(int i = 0; i < 7; i++)
		{
			System.out.println(i+1 + " " + categories[i]);
		}
		String category = new String();
		choice = sc.nextInt();
		switch(choice)
		{
		case 1: 
			category = categories[0];
			break;
		case 2: 
			category = categories[1];
			break;
		case 3: 
			category = categories[2];
			break;
		case 4: 
			category = categories[3];
			break;
		case 5: 
			category = categories[4];
			break;
		case 6: 
			category = categories[5];
			break;
		case 7: 
			category = categories[6];
			break;
		}
		
		System.out.println("Please enter name");
		name = sc.nextLine();
		item.name = name;
		
		System.out.println("Please enter description");
		description = sc.nextLine();
		item.description = description;
		
		System.out.println("Please create the questionnaire (5)");
		for(int i=0; i<5; i++)
		{
			System.out.println("Enter question " + i+1);
			question.add(sc.nextLine());
			System.out.println("Enter answer " + i+1);
			answer.add(sc.nextLine());
		}
		Questionnaire q = new Questionnaire(question, answer);
		item.questions = q;
		
		/*Save Item data in a file*/
		DataPersistanceItem dpi;
		try {
			dpi = new DataPersistanceItem(System.getProperty("user.dir")+"/item_data.txt");
			dpi.connection = "itemDB.txt";
			dpi.save(item, user, category);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
