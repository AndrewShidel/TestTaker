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
	public DocumentType docType;
	public Document(DocumentType docType){
		questions = new ArrayList<Question>();
		name  = InputHandler.getString("What is the name of this Document?");
		this.docType = docType;
	}
	/**
	 * Displays the document
	 */
	public void display(){
		int count = 0;
		for (Question question: questions){
			count++;
			System.out.print(count + ").");
			question.display();
		}
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
	public int getQuestionCount() {
		 return questions.size();
	}
	public Question getQuestion(int index){
		return questions.get(index);
	}
}
