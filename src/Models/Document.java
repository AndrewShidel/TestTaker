package Models;
import java.io.Serializable;
import java.util.ArrayList;
import Controllers.InputHandler;
import Questions.Question;

/**
 * Represents a Test or a Survey
 * @author andrew
 */
public class Document implements Serializable{
	private static final long serialVersionUID = -4237689455651023962L;
	protected String name;
	protected ArrayList<Question> questions;
	public Document(){
		questions = new ArrayList<Question>();
		name  = InputHandler.getString("What is the name of this Document?");
	}
	/**
	 * Displays the document
	 */
	public void display(){
		for (Question question: questions)
			question.display();
	}
	/**
	 * Adds a new question to the Document
	 * @param question The question to add
	 */
	public void add(Question question){
		questions.add(question);
	}
	/**
	 * Gets the name of the Document
	 * @return The name of the Document
	 */
	public String getName(){
		return name;
	}
}
