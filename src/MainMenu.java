/**
 * Author: Andrew Shidel
 * Description: A command line utility for creating, viewing, loading, and saving tests and survays.
 */

import Controllers.*;
import Models.Document;
import Models.DocumentType;

public class MainMenu {
	private static Document currentDocument;

	public static void main(String[] args) {
		//Loop until the user decides to exit
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
				currentDocument = TestIO.load(DocumentType.Survay);
				break;
			case 6:
				currentDocument = TestIO.load(DocumentType.Test);
				break;
			case 7:
			case 8:
				if (currentDocument==null){
					System.out.println("Please create or load a test/survay.");
					continue;
				}
				TestIO.save(currentDocument);
				break;
			case 9:
			case 10:
				if (currentDocument==null){
					System.out.println("Please create or load a test/survay.");
					continue;
				}
				TestModifier.modify(currentDocument);
				break;
			case 11:
			case 12:
			case 13:
			case 14:
			case 15:
			case 16:
				return;
			}
		}
	}
	/**
	 * Give the user a list of options, and return the result
	 * @return The index of the chosen item
	 */
	private static int showMainPrompt(){
		if (currentDocument!=null){
			System.out.println("\nOpen Document: " + currentDocument.getName());
		}
		String displayStr = "1) Create a new Survey\n"
				+"2) Create a new Test\n" 
				+"3) Display a Survey\n"
				+"4) Display a Test\n" 
				+"5) Load a Survey\n"
				+"6) Load a Test\n" 
				+"7) Save a Survey\n"
				+"8) Save a Test\n" 
				+ "9) Modify an Existing Survey\n"
				+"10) Modify an Existing Test\n"
				+"11) Take a Survey\n"
				+"12) Take a Test\n" 
				+"13) Grade a Test\n"
				+"14) Tabulate a Survey\n"
				+"15) Tabulate a Test\n"
				+"16) Quit \n";
		int choice = InputHandler.getInt(displayStr);
		if (choice<1 || choice > 16){
			System.out.println("Invalid Choice.\n");
			return showMainPrompt();
		}
		return choice;
	}
}
