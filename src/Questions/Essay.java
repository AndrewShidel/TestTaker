package Questions;

import Controllers.InputHandler;

public class Essay extends Question{
	private static final long serialVersionUID = -3394003854972077480L;
	public Essay(boolean needsAnswer){
		prompt = InputHandler.getString("Enter the prompt for your Essay question:");
	}
	@Override
	public void display() {
		System.out.println(prompt);
	}
}
