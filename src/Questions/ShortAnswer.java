package Questions;

import Controllers.InputHandler;

public class ShortAnswer  extends Question{
	private static final long serialVersionUID = -6373846795472587290L;
	private String answer;
	public ShortAnswer(boolean needsAnswer){
		prompt = InputHandler.getString("Enter the prompt for your Short Answer question:");
		if (needsAnswer){
			answer = InputHandler.getString("Enter the correct answer: ");
		}
	}
	@Override
	public void display() {
		System.out.println(prompt);
		if (answer!=null){
			System.out.println("The answer is: " + answer);
		}
	}
}
