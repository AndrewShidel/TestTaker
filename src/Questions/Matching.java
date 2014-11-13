package Questions;

import java.util.ArrayList;
import java.util.HashMap;
import Controllers.InputHandler;

public class Matching  extends Question{
	private static final long serialVersionUID = -8641698262205674808L;
	private ArrayList<String> col1Choices, col2Choices;
	private HashMap<Integer, Integer> answer;
	public Matching(boolean needsAnswer){
		col1Choices = new ArrayList<String>();
		col2Choices = new ArrayList<String>();
		answer = new HashMap<Integer, Integer>();
		prompt = InputHandler.getString("Enter the prompt for your Matching question:");
		int numChoices = InputHandler.getInt("Enter the number of choices: ");

		for (int i=1; i<=numChoices; i++){
			col1Choices.add(InputHandler.getString("Enter column 1 row "+i+":"));
		}
		for (int i=1; i<=numChoices; i++){
			col2Choices.add(InputHandler.getString("Enter column 2 row "+i+":"));
		}
		if (needsAnswer){
			setCorrectAnswer();
		}
	}
	@Override
	public void setCorrectAnswer() {
		for (int i=1; i<=col1Choices.size(); i++){
			int choice = InputHandler.getInt("Which item in column 2 matches item "+i+" from column 1?");
			answer.put(i, choice);
		}
	}
	@Override
	public void display() {
		System.out.println(prompt);

		for ( int i=0; i < col1Choices.size(); i++){
			System.out.println(col1Choices.get(i) + "\t" + col2Choices.get(i));
		}
		
		if (answer.size()>0){
			System.out.println("The Correct answer is: ");
			for (int key: answer.keySet()){
				System.out.println(col1Choices.get(key-1) + "\t" + col2Choices.get(answer.get(key)-1));
			}
		}
	}

}
