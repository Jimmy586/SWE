import java.util.Scanner;

class Item{
	public String name;
	public String description;
	public int ItemID;
	public int UserID;
	public boolean claim;
	public Category category;
	public Questionnaire questions;
	
	Item(){}
	
	Item(String n,int ItemID,String description){
		name=n;
		this.ItemID=ItemID;	
		this.description=description;
	}
	
}


public class SearchItem {
	public Item it;
	public int choiceToClaim=0;
	Scanner sc= new Scanner(System.in);
	
	public SearchItem(Item it) {
		this.it=it;
	}
	
	public void DisplayItem(Category c) {
		int i=c.ItemList.size();
		for(int j=0;j<i;j++) {
			if(!c.ItemList.get(i).claim) {
				System.out.println(j+1 +" "+c.ItemList.get(i).name+"\t"+c.ItemList.get(i).description);
			}
		}
		System.out.println("Enter the number of your item from the list:(0 if not on the list)");
		choiceToClaim= sc.nextInt();
		if(choiceToClaim==0 || choiceToClaim+1>=i) {
			return;
		}
		else {
			it=c.ItemList.get(choiceToClaim);
			DataPersistanceUser dt;
			boolean authentication= it.questions.validate();
			if(authentication) {
				it.claim=true;
				System.out.println("we confirm your Claim....");
				System.out.println("here is the details of the user who posted it:");
				dt.load(it.UserID);
				System.out.println("Press 0 to sing out");
			}
		}
	}
}
