package Questions;

import java.util.Scanner;

public class ShortAnswer  extends Question{
	private String answer;
	public ShortAnswer(boolean needsAnswer){
		System.out.println("Enter the prompt for your Short Answer question:");
		Scanner scanner = new Scanner(System.in);
		prompt = scanner.nextLine();
		if (needsAnswer){
			System.out.println("Enter the correct answer: ");
			answer = scanner.nextLine();
		}
	}
	@Override
	public void display() {
		// TODO Auto-generated method stub

	}
}
