package Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Matching  extends Question{
	private ArrayList<String> col1Choices, col2Choices;
	private HashMap<Integer, Integer> answer;
	public Matching(boolean needsAnswer){
		col1Choices = new ArrayList<String>();
		col2Choices = new ArrayList<String>();
		answer = new HashMap<Integer, Integer>();
		System.out.println("Enter the prompt for your Matching question:");
		Scanner scanner = new Scanner(System.in);
		prompt = scanner.nextLine();
		System.out.println("Enter the number of choices:");
		int numChoices = scanner.nextInt();

		for (int i=1; i<=numChoices; i++){
			System.out.println("Enter column 1 row "+i+":");
			col1Choices.add(scanner.nextLine());
		}
		for (int i=1; i<=numChoices; i++){
			System.out.println("Enter column 2 row "+i+":");
			col2Choices.add(scanner.nextLine());
		}
		if (needsAnswer){
			for (int i=0; i<col1Choices.size(); i++){
				System.out.println("Which item in column 2 matches item "+i+" from column 1?");
				answer.put(i, scanner.nextInt());
			}
		}
	}
	@Override
	public void display() {
		System.out.println(prompt);
		if (answer.size()>0){
			System.out.println("The Correct answer is: ");

		}
	}
}
