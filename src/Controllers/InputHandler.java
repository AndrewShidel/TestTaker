package Controllers;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A utility class for handling user input.
 */
@SuppressWarnings("resource")
public class InputHandler {
	/**
	 * Get an integer from the command line.
	 * @param prompt A string to display
	 * @return The value that the user entered
	 */
	public static int getInt(String prompt){
		Integer input = null;
		Scanner scanner = new Scanner(System.in);
		while (input==null){
			System.out.print(prompt);
			try{
				input = scanner.nextInt();
			}catch(InputMismatchException e){
				System.out.println("The value entered must be an integer.");
			}finally{
				scanner.nextLine();
			}
		}
		return input;
	}
	/**
	 * Get an integer from the command line.  If the value is not between from and to, the user will be warned and prompted again.
	 * @param prompt A String to display
	 * @param from The lowest acceptable input
	 * @param to The highest acceptable input
	 * @return The integer that the user entered
	 */
	public static int getInt(String prompt, int from, int to){
		int choice = getInt(prompt);
		if (choice < from || choice > to){
			System.out.println("Choice is out of range");
			return getInt(prompt, from, to);
		}
		return choice;
	}
	/**
	 * Get a sting from the command line
	 * @param prompt A string to display
	 * @return The value that the user entered
	 */
	public static String getString(String prompt){
		String input = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println(prompt);
		input = scanner.nextLine();
		return input;
	}
	
	/**
	 * Get the answer to a yes or no question as a Boolean.
	 * @param prompt A string to display
	 * @return The value that the user entered as a Boolean
	 */
	public static boolean getYesOrNo(String prompt){
		return getString(prompt).toLowerCase().indexOf("yes")>=0;
	}
}
