package Questions;

import java.util.ArrayList;
import java.util.Scanner;

public class MultipleChoice  extends Question{
	private ArrayList<String> choices;
	private int answer;
	public MultipleChoice(boolean needsAnswer){
		System.out.println("Enter the prompt for your Multiple Choice question:");
		Scanner scanner = new Scanner(System.in);
		prompt = scanner.nextLine();
		System.out.println("Enter the number of choices:");
		int numChoices = scanner.nextInt();
		for (int i=0; i<numChoices; i++){
			System.out.println("Enter choice #"+i+":");
			choices.add(scanner.nextLine());
		}
		if (needsAnswer){
			System.out.println("Enter the correct choice: ");
			answer = scanner.nextInt();
		}
		scanner.close();
	}
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
}