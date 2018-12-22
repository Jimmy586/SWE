import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws IOException {
		PostItem postItem = new PostItem();
		boolean check= true;
		Category []category=new Category[7];
		category[0]=new Category("electronic");
		category[1]=new Category("academic");
		category[2]=new Category("walet");
		category[3]=new Category("bag");
		category[4]=new Category("clothing");
		category[5]=new Category("wearable");
		category[6]=new Category("card");
		User user;
		SearchItem sri = null;
		Scanner sc= new Scanner(System.in);
		DataPersistanceUser ud = new DataPersistanceUser(System.getProperty("user.dir")+"/user_data.txt");
		final int ID=1;
		int choice1,choice2,choice3;
		do {
			System.out.println("1:Create a new Account");
			System.out.println("2:Sign In");
			choice1=sc.nextInt();
			switch (choice1) {
			case 1:{
				System.out.println("Name:");
				String name=sc.next();
				System.out.println("Password:");
				String password=sc.next();
				System.out.println("Phone Number:");
				int phone=sc.nextInt();
				user=new User(ID,name,password,phone);
				user.setNotification("Sample Nitification");
				ud.save(user);
				boolean test2=true;
				do {
					System.out.println("1:Post Found Item");
					System.out.println("2:Search for lost Item:");
					choice2=sc.nextInt();
					switch(choice2) {
						case 1:{
							/*choices();
							choice3=sc.nextInt();*/
							postItem.post(user, category);
							System.out.println("Press 0 to log out");
							int choice6=sc.nextInt();
							if(choice6==0) {
								System.out.println("see you again...");
								test2=false;
							}
							break;
						}
						case 2:{
							choices();
							choice3=sc.nextInt();
							sri.DisplayItem(category[choice3-1]);
							System.out.println("Press 0 to log out");
							int choice6=sc.nextInt();
							if(choice6==0) {
								System.out.println("see you again...");
								test2=false;
								}
							break;
						}
						default:{System.out.println("enter a valid choice,Please try again");check=true;break;}
					}
				}while(test2);
				break;
			}
			
			case 2:{
				System.out.println("Name:");
				String name=sc.next();
				System.out.println("Password:");
				String password=sc.next();
				user=ud.load(name);
				if(user!=null) {
					if(user.getPassword()==password) {
						boolean test2=true;
						do {
							System.out.println("1:Post Found Item");
							System.out.println("2:Search for lost Item:");
							choice2=sc.nextInt();
							switch(choice2) {
								case 1:{
									/*choices();
									choice3=sc.nextInt();*/
									postItem.post(user, category);
									System.out.println("Press 0 to log out");
									int choice6=sc.nextInt();
									if(choice6==0) {
										System.out.println("see you again...");
										test2=false;
									}
									break;
								}
								case 2:{
									choices();
									choice3=sc.nextInt();
									sri.DisplayItem(category[choice3-1]);
									System.out.println("Press 0 to log out");
									int choice6=sc.nextInt();
									if(choice6==0) {
										System.out.println("see you again...");
										test2=false;
									}
									break;
								}
								default:{System.out.println("enter a valid choice,Please try again");check=true;break;}
							}
						}while(test2);
					}else {
						System.out.println("Wrong Password,you can create an account if you don't have yet...");check=true;
					}
				}else {
					System.out.println("The Username you entered doesn't exist");check=true;
				}
				break;
			}
			
			default: {System.out.println("enter a valid choice,Please try again");check=true;break;}
			}
		} while(check);
		sc.close();
	}
	public static void choices() {
		System.out.println("Choose Form the category:");
		System.out.println("1:Electronics");
		System.out.println("2:Academic Stuff");
		System.out.println("3:Walet");
		System.out.println("4:bags");
		System.out.println("5:Clothing");
		System.out.println("6:Wearable(watch,glasses...)");
		System.out.println("7:cards(Personal ID,bank card...)");
	}
}
