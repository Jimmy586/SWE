package swe_phase3;

import java.util.ArrayList;

public class Category {
	public ArrayList<Item> itemList;
	public String name;
	
	Category(String n)
	{
		this.name = n;
		this.itemList = new ArrayList<Item>();
	}
}
