package Models;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import Controllers.DocIO;

public class TestAttempt implements Serializable{
	private static final long serialVersionUID = -7645122715771240520L;
	private Double score=0.0;
	private int gradedQuestions=0;
	private Document doc;
	private String takersName;
	private ArrayList<AttemptEntry> answers;
	
	/**
	 * @param doc The document that the user is taking.
	 * @param takersName The name of the user.
	 */
	public TestAttempt(Document doc, String takersName){
		this.takersName = takersName;
		this.setDoc(doc);
		answers = new ArrayList<AttemptEntry>();
	}
	/**
	 * Adds an answer, with it resulting to neither true nor false.
	 * @param answer The answer to add.
	 */
	public void addAnswer(Object answer){
		answers.add(new AttemptEntry(answer, -1));
	}
	/**
	 * Adds an answer.
	 * @param answer The answer to add.
	 * @param correct whether the answer was correct.
	 */
	public void addAnswer(Object answer, Boolean correct){
		score=(score*gradedQuestions+(correct?1:0))/(++gradedQuestions);
		answers.add(new AttemptEntry(answer, correct?1:0));
	}
	/**
	 * Saves the TestAttempt to the Disk.
	 */
	public void save(){
		File newDir = new File(DocIO.SAVE_PATH+doc.getName()+"Results");
		if (!newDir.exists())
			newDir.mkdirs();

		try (
				OutputStream file = new FileOutputStream(newDir.getAbsolutePath()+"/"+takersName);
				OutputStream buffer = new BufferedOutputStream(file);
				ObjectOutput output = new ObjectOutputStream(buffer);
				){
			output.writeObject(this);
		}  
		catch(IOException ex){
			ex.printStackTrace();
		}
	}
	/**
	 * Load all attempts for a given document.
	 * @param doc the document to get attempts for
	 * @return An ArrayList of attempts.
	 */
	public static ArrayList<TestAttempt> getAttempts(Document doc){
		File folder = new File(DocIO.SAVE_PATH+doc.getName());
		File[] listOfFiles = folder.listFiles();
		ArrayList<String> files = new ArrayList<String>();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				files.add(listOfFiles[i].getName());
			} 
		}
		if (files.size()==0){
			System.out.println("There are no documents to load");
			return null;
		}
		ArrayList<TestAttempt> attempts = new ArrayList<TestAttempt>();
		for (int i=0;i<files.size(); i++){
			try(
					InputStream file = new FileInputStream(DocIO.SAVE_PATH+doc.getName()+files.get(i));
					InputStream buffer = new BufferedInputStream(file);
					ObjectInput input = new ObjectInputStream (buffer);
					){
				attempts.add((TestAttempt)input.readObject());
			}
			catch(ClassNotFoundException ex){
				ex.printStackTrace();
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
		}
		return attempts;
	}
	
	///////////////////////
	//Getters and Setters//
	///////////////////////
	
	public String getTakersName() {
		return takersName;
	}
	public void setTakersName(String takersName) {
		this.takersName = takersName;
	}
	public Double getScore() {
		return score*100;
	}
	public Document getDoc() {
		return doc;
	}
	public void setDoc(Document doc) {
		this.doc = doc;
	}
	public Object getAnswer(int index){
		return answers.get(index).getAnswer();
	}
	public class AttemptEntry implements Serializable{
		private static final long serialVersionUID = -9223148273116944658L;
		private int status;
		private Object answer;
		public AttemptEntry(Object answer, int status){
			this.status = status;
			this.answer = answer;
		}
		public int getStatus() {
			return status;
		}
		public Object getAnswer(){
			return answer;
		}
	}
}
