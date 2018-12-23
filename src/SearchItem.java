import java.util.Scanner;

class Item{
	public String name;
	public String description;
	public static int ItemID;
	public int UserID;
	public boolean claim;
	public Category category;
	public Questionnaire questions;
	
	Item(){}
	
	Item(String n,int ItemID,String description){
		name=n;	
		this.description=description;
	}
	
}


public class SearchItem {
	public Item it;
	public int choiceToClaim=0;
	//Scanner sc= new Scanner(System.in);
	
	SearchItem(){
		it = new Item();
	}
	
	public SearchItem(Item it) {
		this.it=it;
	}
	
	@SuppressWarnings("null")
	public void DisplayItem(Category c) {
		Scanner sc= new Scanner(System.in);
		int i=c.itemList.size();
		
		if(i==0) {
			System.out.println("No Item found yet...");return;
		}
		for(int j=0;j<i;j++) {
			if(!c.itemList.get(j).claim) {
				System.out.println(j+1 +" "+c.itemList.get(j).name+"\t"+c.itemList.get(j).description);
			}
		}
		System.out.println("Enter the number of your item from the list:(0 if not on the list)");
		choiceToClaim= sc.nextInt();
		if(choiceToClaim==0 /*|| choiceToClaim+1>=i*/) {
			return;
		}
		else {
			it=c.itemList.get(choiceToClaim-1);
			DataPersistanceUser dt = new DataPersistanceUser(System.getProperty("user.dir")+"/user_data.txt");
			System.out.println("Please answer these question: ");
			boolean authentication= it.questions.validate();
			if(authentication) {
				it.claim=true;
				System.out.println("we confirm your Claim....");
				System.out.println("here is the details of the user who posted it:");
				dt.load(it.UserID);

			}
			else
			{
				System.out.println("The item is not yours");
			}
		}
		//sc.close();
	}
}
