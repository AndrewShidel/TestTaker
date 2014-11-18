/**
 * Author: Andrew Shidel
 * Description: A command line utility for creating, viewing, loading, and saving tests and survays.
 */

import Controllers.DocCreator;
import Controllers.DocIO;
import Controllers.DocModifier;
import Controllers.DocTabulate;
import Controllers.DocTaker;
import Controllers.InputHandler;
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
				currentDocument = DocCreator.createTest(DocumentType.Survay);
				break;
			case 2:
				currentDocument = DocCreator.createTest(DocumentType.Test);
				break;
			case 3:
				if (currentDocument==null){
					System.out.println("Select a Document to load.");
					currentDocument = DocIO.load();
					if (currentDocument==null) continue;
				}
				currentDocument.display();
				break;
			case 4:
				currentDocument = DocIO.load();
				break;
			case 5:
				if (currentDocument==null){
					System.out.println("You must first create or load a document to save.");
					continue;
				}
				DocIO.save(currentDocument);
				break;
			case 6:
				if (currentDocument==null){
					System.out.println("Select a Document to modify.");
					currentDocument = DocIO.load();
					if (currentDocument==null) continue;
				}
				DocModifier.modify(currentDocument);
				break;
			case 7:
				if (currentDocument==null){
					System.out.println("Select a Document to take.");
					currentDocument = DocIO.load();
					if (currentDocument==null) continue;
				}
				DocTaker.takeTest(currentDocument);
				break;
			case 8:
				System.out.println("\nTests are automaticly graded after being taken.");
				System.out.println("Please take a test to get the grade.\n");
				break;
			case 9:
				if (currentDocument==null){
					System.out.println("Select a Document to tabulate.");
					currentDocument = DocIO.load();
					if (currentDocument==null) continue;
				}
				DocTabulate.tabulate(currentDocument.getName());
				break;
			case 10:
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
		String displayStr = "1). Create a new Survey\n"
				+"2). Create a new Test\n" 
				+"3). Display a Document\n"
				+"4). Load a Document\n"
				+"5). Save a Document\n"
				+"6). Modify an Existing Document\n"
				+"7). Take a Survey/Test\n"
				+"8). Grade a Test\n"
				+"9). Tabulate a Document\n"
				+"10). Quit \n";
		int choice = InputHandler.getInt(displayStr, 1, 10);
		return choice;
	}
}
