package Questions;

import Controllers.InputHandler;

public class ShortAnswer  extends Question{
	private static final long serialVersionUID = -6373846795472587290L;
	private String answer;
	public ShortAnswer(boolean needsAnswer){
		prompt = InputHandler.getString("Enter the prompt for your Short Answer question:");
		if (needsAnswer){
			setCorrectAnswer();
		}
	}
	@Override
	public void setCorrectAnswer() {
		answer = InputHandler.getString("Enter the correct answer: ");
	}
	@Override
	public void display(Boolean showCorrect) {
		System.out.println(prompt);
		if (answer!=null && showCorrect){
			System.out.println("The answer is: " + answer);
		}
	}
	@Override
	public Object promptForAnswer() {
		String choice = InputHandler.getString("");
		return choice;
	}
	@Override
	public Boolean compareAnswer(Object input) {
		if (!(input instanceof String)) return false;
		String inputStr = (String) input;
		return inputStr.trim().compareToIgnoreCase(answer.trim())==0;
	}
	@Override
	public void printAnswer(Object answer) {
		if (!(answer instanceof String)) return;
		System.out.print((String)answer);
	}
}
