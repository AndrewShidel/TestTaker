package Questions;

import Controllers.InputHandler;

public class Essay extends Question{
	private static final long serialVersionUID = -3394003854972077480L;
	public Essay(boolean needsAnswer){
		prompt = InputHandler.getString("Enter the prompt for your Essay question:");
	}
	@Override
	public void display(Boolean showCorrect) {
		System.out.println(prompt);
	}
	@Override
	public void setCorrectAnswer() {}
	
	@Override
	public Object promptForAnswer() {
		return InputHandler.getString("");
	}
	@Override
	public Boolean compareAnswer(Object input) {
		return true;
	}
	@Override
	public void printAnswer(Object answer) {
		if (!(answer instanceof String)) return;
		System.out.print((String)answer);
	}
}
