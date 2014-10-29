package Models;
import Questions.Question;

public abstract class Document {
	protected String name;
	protected Question[] questions;
	public void display(){
		for (Question question: questions)
			question.display();
	}
	public void add(Question question){}
}
