package Questions;

import java.io.Serializable;

/**
 * Represents a single question
 * @author andrew
 */
public abstract class Question implements Serializable{
	private static final long serialVersionUID = 9020224599023001291L;
	
	//The question's title
	protected String prompt;
	
	/**
	 * Displays the Question
	 */
	public abstract void display();
}
