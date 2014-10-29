package Questions;

import Models.Answer;

public abstract class Question {
	protected String prompt;
	protected Answer correctAnswer;
	public abstract void display();
}
