package Questions;

import java.io.Serializable;

/**
 * Represents a single question
 */
public abstract class Question implements Serializable{
	private static final long serialVersionUID = 9020224599023001291L;
	
	//The question's title
	protected String prompt;
	
	/**
	 * Displays the Question
	 * @param showCorrect Determines whether the answer is printed if there is one. 
	 */
	public abstract void display(Boolean showCorrect);
	public void display(){this.display(true);}
	
	/**
	 * Prompts the user for the correct answer, and stores the result.
	 */
	public abstract void setCorrectAnswer();
	
	
	/**
	 * Prompts the user for an Answer to the question, and returns the result.
	 * @return A String, Boolean, ArrayList, HashMap, or other depending of the implementation.
	 */
	public abstract Object promptForAnswer();
	
	/**
	 * Prints an arbitrary assuming that it is in the sub-classes implemented data type.  See method implementation for details. 
	 * @param answer The answer to print.
	 */
	public abstract void printAnswer(Object answer);
	
	/**
	 * Compares the provided answer with the question's answer.
	 * @param input An Object originally generated through an implementation of Question.
	 * @return True is the objects represent the same value, otherwise false.
	 */
	public abstract Boolean compareAnswer(Object input);
	public String getPrompt(){
		return prompt;
	}
	public void setPrompt(String prompt){
		this.prompt = prompt;
	}
}
