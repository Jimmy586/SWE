import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PostItem {
	
	void post(User user, Category[] cat) throws IOException
	{
		Questionnaire q = new Questionnaire();
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
		choice = sc.nextInt();
		switch(choice)
		{
		case 1: 
			System.out.println("Please enter name");
			name = sc.next();
			item.name = name;
			
			System.out.println("Please enter description");
			description = sc.next();
			item.description = description;
			
			System.out.println("Please create the questionnaire (5)");
			for(int i=0; i<5; i++)
			{
				System.out.println("Enter question " + i);
				question.add(sc.next());
				System.out.println("Enter answer " + i);
				answer.add(sc.next());
			}
			q = new Questionnaire(question, answer);
			item.questions = q;
			item.UserID = userID;
			item.claim = false;
			Item.ItemID++;
			item.category = cat[0];
			cat[0].itemList.add(item);
			break;
		case 2: 
			System.out.println("Please enter name");
			name = sc.next();
			item.name = name;
			
			System.out.println("Please enter description");
			description = sc.next();
			item.description = description;
			
			System.out.println("Please create the questionnaire (5)");
			for(int i=0; i<5; i++)
			{
				System.out.println("Enter question " + i);
				question.add(sc.next());
				System.out.println("Enter answer " + i);
				answer.add(sc.next());
			}
			q = new Questionnaire(question, answer);
			item.questions = q;
			item.claim = false;
			item.UserID = userID;
			Item.ItemID++;
			item.category = cat[1];
			cat[1].itemList.add(item);
			break;
		case 3: 
			System.out.println("Please enter name");
			name = sc.next();
			item.name = name;
			
			System.out.println("Please enter description");
			description = sc.next();
			item.description = description;
			
			System.out.println("Please create the questionnaire (5)");
			for(int i=0; i<5; i++)
			{
				System.out.println("Enter question " + i);
				question.add(sc.next());
				System.out.println("Enter answer " + i);
				answer.add(sc.next());
			}
			q = new Questionnaire(question, answer);
			item.questions = q;
			item.claim = false;
			item.UserID = userID;
			Item.ItemID++;
			item.category = cat[2];
			cat[2].itemList.add(item);
			break;
		case 4: 
			System.out.println("Please enter name");
			name = sc.next();
			item.name = name;
			
			System.out.println("Please enter description");
			description = sc.next();
			item.description = description;
			
			System.out.println("Please create the questionnaire (5)");
			for(int i=0; i<5; i++)
			{
				System.out.println("Enter question " + i);
				question.add(sc.next());
				System.out.println("Enter answer " + i);
				answer.add(sc.next());
			}
			q = new Questionnaire(question, answer);
			item.questions = q;
			item.claim = false;
			Item.ItemID++;
			item.UserID = userID;
			item.category = cat[3];
			cat[3].itemList.add(item);
			break;
		case 5: 
			System.out.println("Please enter name");
			name = sc.next();
			item.name = name;
			
			System.out.println("Please enter description");
			description = sc.next();
			item.description = description;
			
			System.out.println("Please create the questionnaire (5)");
			for(int i=0; i<5; i++)
			{
				System.out.println("Enter question " + i);
				question.add(sc.next());
				System.out.println("Enter answer " + i);
				answer.add(sc.next());
			}
			q = new Questionnaire(question, answer);
			item.questions = q;
			item.claim = false;
			Item.ItemID++;
			item.UserID = userID;
			item.category = cat[4];
			cat[4].itemList.add(item);
			break;
		case 6: 
			System.out.println("Please enter name");
			name = sc.next();
			item.name = name;
			
			System.out.println("Please enter description");
			description = sc.next();
			item.description = description;
			
			System.out.println("Please create the questionnaire (5)");
			for(int i=0; i<5; i++)
			{
				System.out.println("Enter question " + i);
				question.add(sc.next());
				System.out.println("Enter answer " + i);
				answer.add(sc.next());
			}
			q = new Questionnaire(question, answer);
			item.questions = q;
			item.claim = false;
			Item.ItemID++;
			item.UserID = userID;
			item.category = cat[5];
			cat[5].itemList.add(item);
			break;
		case 7: 
			System.out.println("Please enter name");
			name = sc.next();
			item.name = name;
			
			System.out.println("Please enter description");
			description = sc.next();
			item.description = description;
			
			System.out.println("Please create the questionnaire (5)");
			for(int i=0; i<5; i++)
			{
				System.out.println("Enter question " + i);
				question.add(sc.next());
				System.out.println("Enter answer " + i);
				answer.add(sc.next());
			}
			q = new Questionnaire(question, answer);
			item.questions = q;
			item.claim = false;
			Item.ItemID++;
			item.UserID = userID;
			item.category = cat[6];
			cat[6].itemList.add(item);
			break;
		}
		/*Save Item data in a file*/
		DataPersistanceItem dpi;
		dpi = new DataPersistanceItem(System.getProperty("user.dir")+"/item_data.txt");
		dpi.save(item, user);
		//sc.close();
	}
}