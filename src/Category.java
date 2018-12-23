

import java.util.ArrayList;

public class Category {
	public ArrayList<Item> itemList;
	public String name;
	
	Category()
	{
		this.name= new String();
		this.itemList = new ArrayList<Item>();
	}
	Category(String n)
	{
		this.name = n;
		this.itemList = new ArrayList<Item>();
	}
}