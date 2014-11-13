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
	public void display() {
		System.out.println(prompt);
		for (int key: items.keySet()){
			System.out.println("\t-" + items.get(key));
		}
		if (hasAnswer){
			System.out.println("The correct ranking is:");
			for (int key=1; key <= items.size(); key++){
				System.out.println("\t-" + items.get(key));
			}
		}
	}
}
