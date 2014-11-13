package Controllers;

import Models.Document;
import Questions.Essay;
import Questions.MultipleChoice;
import Questions.Question;

public class TestModifier {
	public static void modify(Document doc){
		int choice = InputHandler.getInt("Enter a question number to edit, or 0 to view the test.", 0, doc.getQuestionCount());
		if (choice==0) {
			doc.display();
			modify(doc);
			return;
		}
		Question question = doc.getQuestion(choice-1);
		System.out.println(question.getPrompt());
		if (InputHandler.getYesOrNo("Would you like to change the prompt (yes/no)?")){
			System.out.println(question.getPrompt());
			question.setPrompt(InputHandler.getString("Enter a new prompt:"));
		}

		if (question instanceof MultipleChoice){
			if (InputHandler.getYesOrNo("Do you wish to modify choices (yes/no)?")){
				question.display();
				int index = InputHandler.getInt("Which choice do you want to modify?", 1, doc.getQuestionCount());
				String newAnswer = InputHandler.getString("Enter the choice.");
				((MultipleChoice) question).changeAnswer(index, newAnswer);
			}
		}
		if (!(question instanceof Essay)){
			if (InputHandler.getYesOrNo("Do you wish to modify the correct answer (yes/no)?")){
				question.display();
				question.setCorrectAnswer();
			}
		}
	}
}
