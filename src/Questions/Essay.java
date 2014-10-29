package Questions;

import java.util.Scanner;

public class Essay extends Question{
	public Essay(boolean needsAnswer){
		System.out.println("Enter the prompt for your Essay question:");
		Scanner scanner = new Scanner(System.in);
		prompt = scanner.nextLine();
	}
	@Override
	public void display() {
		System.out.println(prompt);
	}
}
