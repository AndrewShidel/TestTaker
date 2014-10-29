package Models;

import java.util.Scanner;

import Questions.Question;

public class Test extends Document{
	private Answer[] answers;
	public Test(){
		System.out.println("What is the name of this Document? ");
		Scanner scanner = new Scanner(System.in);
		name  = scanner.nextLine();
		scanner.close();
	}
	@Override
	public void display(){
		for (Question question: questions){
			question.display();
		}
	}
}
