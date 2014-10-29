package Controllers;
import java.util.Scanner;

import Models.Document;
import Models.DocumentType;
import Models.Survay;
import Models.Test;
import Questions.*;

public class TestCreator {
	public static Document createTest(){
		return null;
	}

	public static Document createTest(DocumentType test) {
		Document document;
		boolean needsAnswer = test.equals(DocumentType.Test);
		if (needsAnswer)
			document = new Test();
		else 
			document = new Survay();
		while(true){
			switch(showMainPrompt()){
			case 1:
				document.add(new TrueFalse(needsAnswer));
				break;
			case 2:
				document.add(new MultipleChoice(needsAnswer));
				break;
			case 3:
				document.add(new ShortAnswer(needsAnswer));
				break;
			case 4:
				document.add(new Essay(needsAnswer));
				break;
			case 5:
				document.add(new Ranking(needsAnswer));
				break;
			case 6:
				document.add(new Matching(needsAnswer));
				break;
			case 7:
				return document;
			}
		}
	}
	private static int showMainPrompt(){
		String displayStr = "1) Add a new T/F question\n"
			+"2) Add a new multiple choice question\n"
			+"3) Add a new short answer question\n"
			+"4) Add a new essay question\n"
			+"5) Add a new ranking question\n"
			+"6) Add a new matching question\n"
			+"7) Finish";
		System.out.println(displayStr);
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
		reader.close();
		int choice;
		try{
			choice = Integer.parseInt(input);
			if (choice<1 || choice > 7)
				throw new NumberFormatException();
		}catch(NumberFormatException e){
			System.out.println("Invalid Choice.\n");
			return showMainPrompt();
		}
		return choice;
	}
}
