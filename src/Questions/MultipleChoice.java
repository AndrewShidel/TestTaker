package Questions;

import java.util.ArrayList;

import Controllers.InputHandler;

public class MultipleChoice  extends Question{
	private static final long serialVersionUID = 870500995185622824L;
	private ArrayList<String> choices;
	private ArrayList<String> answers;
	public MultipleChoice(boolean needsAnswer){
		choices = new ArrayList<String>();
		answers = new ArrayList<String>();
		prompt = InputHandler.getString("Enter the prompt for your Multiple Choice question:");
		int numChoices = InputHandler.getInt("Enter the number of choices: ");
		for (int i=1; i<=numChoices; i++){
			choices.add(InputHandler.getString("Enter choice #"+i+":"));
		}
		if (needsAnswer){
			setCorrectAnswer();
		}
	}
	@Override
	public void setCorrectAnswer() {
		int numberOfAnswers = InputHandler.getInt("How many answers are correct? ");
		for (int i=0; i<numberOfAnswers; i++){
			answers.add(InputHandler.getString("Enter a correct choice: "));
		}
	}
	@Override
	public void display(Boolean showCorrect) {
		System.out.println(prompt);
		int count = 1;
		for (String item: choices){
			System.out.println("\t"+count+"). "+item);
			++count;
		}
		if (answers.size()>0 && showCorrect){
			System.out.println("The answers are: " + answers.toString());
		}
	}
	public void changeAnswer(int index, String value){
		answers.set(index, value);
	}
	@Override
	public Object promptForAnswer() {
		String input = InputHandler.getString("");
		if (input.contains(" ") || input.contains(",")){
			String[] choices = input.split(",|\\s");
			return choices;
		}
		return new String[]{input};
	}
	@Override
	public Boolean compareAnswer(Object input) {
		if (!(input instanceof String[])) return false;
		String[] inputArray = (String[])input;
		for (int i=0; i<inputArray.length; i++){
			if (!answers.contains(inputArray[i])) return false;
		}
		return true;
	}
	@Override
	public void printAnswer(Object answer) {
		if (!(answer instanceof String[])) return;
		for (String choice: (String[]) answer){
			System.out.print(choice + "  ");
		}
	}
}
