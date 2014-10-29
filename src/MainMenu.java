import java.util.Scanner;

import Controllers.*;
import Models.Document;
import Models.DocumentType;


public class MainMenu {
	private static Document currentDocument;

	public static void main(String[] args) {
		while (true){
			int choice = showMainPrompt();
			switch (choice){
			case 1:
				currentDocument = TestCreator.createTest(DocumentType.Survay);
				break;
			case 2:
				currentDocument = TestCreator.createTest(DocumentType.Test);
				break;
			case 3:
			case 4:
				if (currentDocument==null){
					System.out.println("Please create or load a test/survay. ");
					continue;
				}
				currentDocument.display();
				break;
			case 5:
			case 6:
				currentDocument = TestIO.load();
				break;
			case 7:
			case 8:
				TestIO.save(currentDocument);
				break;
			case 9:
				return;
			}
		}
	}
	
	private static int showMainPrompt(){
		String displayStr = "1) Create a new Survey\n"
				+"2) Create a new Test\n" 
				+"3) Display a Survey\n"
				+"4) Display a Test\n" 
				+"5) Load a Survey\n"
				+"6) Load a Test\n" 
				+"7) Save a Survey\n"
				+"8) Save a Test\n" 
				+"9) Quit\n";
		System.out.println(displayStr);
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
		//reader.close();
		int choice;
		try{
			choice = Integer.parseInt(input);
			if (choice<1 || choice > 9)
				throw new NumberFormatException();
		}catch(NumberFormatException e){
			System.out.println("Invalid Choice.\n");
			return showMainPrompt();
		}
		return choice;
	}
}
