package Questions;

import java.util.Scanner;

public class TrueFalse  extends Question{
	private boolean answer;
	public TrueFalse(boolean needsAnswer){
		System.out.println("Enter the prompt for your True/False question:");
		Scanner scanner = new Scanner(System.in);
		prompt = scanner.nextLine();
		if (needsAnswer){
			System.out.println("Is the answer true or false?");
			answer = scanner.nextLine().trim().toLowerCase()=="true"?true:false;
		}
	}
	@Override
	public void display() {
		// TODO Auto-generated method stub

	}
}
