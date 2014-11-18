package Questions;

import java.util.HashMap;

import Controllers.InputHandler;

public class Ranking  extends Question{
	private static final long serialVersionUID = -5166990686935315729L;
	private HashMap<Integer, String> items;
	private boolean hasAnswer;
	public Ranking(boolean needsAnswer){
		items = new HashMap<Integer, String>();
		hasAnswer = needsAnswer;
		prompt = InputHandler.getString("Enter the prompt for your Multiple Choice question:");
		int numChoices = InputHandler.getInt("Enter the number of items: ");
		for (int i=1; i<=numChoices; i++){
			String item = InputHandler.getString("Enter item #"+i+":");
			if (hasAnswer){
				setCorrectAnswer(item);
			}else{
				items.put(i, item);
			}
		}
	}
	@Override
	public void setCorrectAnswer() {
		for (int i=1; i<=items.size(); i++){
			String item = InputHandler.getString("Enter item #"+i+":");
			setCorrectAnswer(item);
		}
	}
	public void setCorrectAnswer(String item) {
		while (true){
			int rank = InputHandler.getInt("Enter the rank of this item:");
			if (items.get(rank)!=null){
				System.out.println("That rank has already been taken.");
				continue;
			}
			items.put(rank, item);
			break;
		}
	}
	@Override
	public void display(Boolean showCorrect) {
		System.out.println(prompt);
		int count = 1;
		for (int key: items.keySet()){
			System.out.println("\t" + count + "). " + items.get(key));
			++count;
		}
		if (hasAnswer && showCorrect){
			System.out.println("The correct ranking is:");
			for (int key=1; key <= items.size(); ++key){
				System.out.println("\t" + key + "). " + items.get(key));
			}
		}
	}
	@Override
	public Object promptForAnswer() {
		String[] choices = InputHandler.getString("Enter the correct order in the form \"3 2 1 4\":").split("\\s");
		int[] intChoices = new int[choices.length];
		for (int i=0; i<choices.length; i++){
			try{
				intChoices[i]=Integer.parseInt(choices[i]);
			}catch(NumberFormatException e){
				System.out.println(choices[i] + " is not a number.");
				return promptForAnswer();
			}
		}
		return intChoices;
	}
	@Override
	public Boolean compareAnswer(Object input) {
		if (!(input instanceof int[])) return false;
		int[] inputArray = (int[])input;
		if (inputArray.length!=items.size()) return false;
		int count = 0;
		for (Integer key: items.keySet()){
			if ( inputArray[count] != key) return false;
			++count;
		}
		return true;
	}
	@Override
	public void printAnswer(Object answer) {
		if (!(answer instanceof int[])) return;
		int[] choices = (int[]) answer;
		for (int i=0; i<choices.length; i++){
			System.out.println(i+"). "+choices[i]);
		}
	}
}
