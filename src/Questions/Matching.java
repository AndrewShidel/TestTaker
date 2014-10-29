package Questions;

import java.util.ArrayList;
import java.util.Scanner;

public class Matching  extends Question{
	private ArrayList<String> choices;
	private ArrayList<Integer> answer;
	public Matching(boolean needsAnswer){
		System.out.println("Enter the prompt for your Matching question:");
		Scanner scanner = new Scanner(System.in);
		prompt = scanner.nextLine();
		System.out.println("Enter the number of choices:");
		int numChoices = scanner.nextInt();
		for (int i=0; i<numChoices; i++){
			System.out.println("Enter option #"+i+":");
			choices.add(scanner.nextLine());
		}
		if (needsAnswer){
			for (int i=0; i<choices.size(); i++){
				System.out.println("Which option matches option #"+i+"?");
				answer.add(scanner.nextInt());
			}
		}
		scanner.close();
	}
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
}
