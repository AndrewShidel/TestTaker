package Controllers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import Models.Document;
import Models.TestAttempt;

public class DocTabulate {
	/**
	 * Displays information about a specific document.
	 * @param docName The name of the document to tabulate.
	 */
	public static void tabulate(String docName){
		File folder = new File(DocIO.SAVE_PATH+docName+"Results");
		System.out.println(folder.getAbsoluteFile());
		File[] listOfFiles = folder.listFiles();
		if (listOfFiles==null){
			System.out.println("There are no documents with that name.");
			return;
		}
		ArrayList<TestAttempt> attempts = new ArrayList<TestAttempt>();
 		ArrayList<String> files = new ArrayList<String>();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				try(
						InputStream file = new FileInputStream(listOfFiles[i]);
						InputStream buffer = new BufferedInputStream(file);
						ObjectInput input = new ObjectInputStream (buffer);
						){
					attempts.add((TestAttempt)input.readObject());
				}
				catch(ClassNotFoundException ex){
					continue;
				}catch(IOException ex){
					continue;
				}
				files.add(listOfFiles[i].getName());
			}
		}
		if (attempts.size()==0) {
			System.out.println("No one has taken this Test/Survay yet.");
			return;
		}
		Document doc = attempts.get(0).getDoc(); // We can assume that all entries have the same document.
		ArrayList< TabulatedQuestion > answers = new ArrayList<>();

		for (int i=0; i<doc.getQuestionCount(); i++){
			TabulatedQuestion question = new TabulatedQuestion();
			for (int j=0; j<attempts.size(); j++){
				question.add( attempts.get(j).getAnswer(i) );
			}
			answers.add(question);
		}
		for (int i=0; i<doc.getQuestionCount(); i++){
			Set<Object> answersForQuestion = answers.get(i).answers.keySet();
			System.out.println("Question " + (i+1) + " has " + answersForQuestion.size() + " different answers.");
			for (Object key: answersForQuestion){
				doc.getQuestion(i).printAnswer(key);
				System.out.println("\nUsed " + answers.get(i).answers.get(key) + " times.\n");
			}
		}
	}
	private static class TabulatedQuestion {
		private HashMap<Object, Integer> answers = new HashMap<>();
		public void add (Object answer){
			Integer answerInstances = answers.get(answer);
			answerInstances = answerInstances==null?0:answerInstances;
			answers.put(answer, answerInstances+1);
		}
	}
}
