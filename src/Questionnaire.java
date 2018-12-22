package swe_phase3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Questionnaire {
	public ArrayList<String> question;
	public ArrayList<String> answer;
	
	Questionnaire(){}
	
	Questionnaire(ArrayList<String>q, ArrayList<String>a)
	{
		this.question = q;
		this.answer = a;
	}
	
	boolean validate()
	{
		Scanner sc = new Scanner(System.in);
		String ans = new String();
		for(int i = 0; i < question.size(); i++)
		{
			System.out.println(question.get(i));
			ans = sc.nextLine();
			if(!(ans.equals(answer.get(i))))
			{
				return false;
			}
		}
		return true;
	}
}
