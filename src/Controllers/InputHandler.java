package Controllers;

import java.util.InputMismatchException;
import java.util.Scanner;

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
}
