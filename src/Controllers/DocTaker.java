package Controllers;

import Models.Document;
import Models.DocumentType;
import Models.TestAttempt;
import Questions.Question;

public class DocTaker {
	/**
	 * Walks the user through taking a Test/Survay.
	 * @param doc The Test/Survay to take.
	 */
	public static void takeTest(Document doc){
		TestAttempt attempt = new TestAttempt(doc, InputHandler.getString("What is your name?"));
		for (int i=0; i<doc.getQuestionCount(); i++){
			Question question = doc.getQuestion(i);
			question.display(false);
			Object answer = question.promptForAnswer();
			if ( doc.docType.equals(DocumentType.Test) && !(question instanceof Questions.Essay) ){
				Boolean correct = question.compareAnswer(answer);
				if (!correct) System.out.println("WRONG!!!");
				attempt.addAnswer(answer, correct);
			}else{
				attempt.addAnswer(answer);
			}
		}
		attempt.save();
		if (doc.docType.equals(DocumentType.Test))
			System.out.println("\nYour score: " + attempt.getScore()+"%");
	}
}


