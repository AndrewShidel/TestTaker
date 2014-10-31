package Questions;

import Controllers.InputHandler;

public class TrueFalse  extends Question{
	private static final long serialVersionUID = -4562128543020835558L;
	private Boolean answer;
	public TrueFalse(boolean needsAnswer){
		prompt = InputHandler.getString("Enter the prompt for your True/False question:");
		if (needsAnswer){
			answer = InputHandler.getString("Is the answer true or false?").trim().toLowerCase()=="true"?true:false;
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
