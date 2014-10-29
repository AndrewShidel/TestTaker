package Questions;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Scanner;

public class Ranking  extends Question{
	private Dictionary<Integer, String> items;
	private boolean hasAnswer;
	public Ranking(boolean needsAnswer){
		hasAnswer = needsAnswer;
		System.out.println("Enter the prompt for your Multiple Choice question:");
		Scanner scanner = new Scanner(System.in);
		prompt = scanner.nextLine();
		System.out.println("Enter the number of items:");
		int numChoices = scanner.nextInt();
		for (int i=0; i<numChoices; i++){
			System.out.println("Enter item #"+i+":");
			String item = scanner.nextLine();
			if (hasAnswer){
				while (true){
					System.out.println("Enter the rank of this item:");
					int rank = scanner.nextInt();
					if (items.get(rank)==null){
						System.out.println("That rank has already been taken.");
						continue;
					}
					items.put(rank, item);
					break;
				}
			}else{
				items.put(i, item);
			}
		}
	}
	@Override
	public void display() {
		// TODO Auto-generated method stub

	}
}
