package Questions;

import Controllers.InputHandler;

public class TrueFalse  extends Question{
	private static final long serialVersionUID = -4562128543020835558L;
	private Boolean answer;
	public TrueFalse(boolean needsAnswer){
		prompt = InputHandler.getString("Enter the prompt for your True/False question:");
		if (needsAnswer){
			setCorrectAnswer();
		}
	}
	@Override
	public void setCorrectAnswer() {
		answer = InputHandler.getString("Is the answer true or false?").trim().toLowerCase().indexOf("true")>=0?true:false;
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
		return (Boolean)InputHandler.getString("").toLowerCase().contains("true");
	}
	@Override
	public Boolean compareAnswer(Object input) {
		if (!(input instanceof Boolean)) return false;
		return (Boolean)input.equals(answer);
	}
	@Override
	public void printAnswer(Object answer) {
		if (!(answer instanceof Boolean)) return;
		System.out.print((Boolean) answer);
	}
}
