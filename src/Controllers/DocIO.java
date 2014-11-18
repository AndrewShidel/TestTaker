package Controllers;

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
import java.util.ArrayList;

import Models.Document;

/**
 * Handles input/output for Documents 
 * @author andrew
 */
public class DocIO {
	// The location for saved Documents
	public final static String SAVE_PATH = "Documents/";
	
	/**
	 * Save a document with it's name as the filename
	 * @param doc The document to save
	 */
	public static void save(Document doc){
		try (
				OutputStream file = new FileOutputStream(SAVE_PATH+doc.getName());
				OutputStream buffer = new BufferedOutputStream(file);
				ObjectOutput output = new ObjectOutputStream(buffer);
				){
			output.writeObject(doc);
			System.out.println("Document saved.");
		}  
		catch(IOException ex){
			ex.printStackTrace();
		}
	}
	/**
	 * Load a Document from the disk.
	 * @param docType The type of document to load.
	 * @return The newly created document.
	 */
	public static Document load(){
		File folder = new File(SAVE_PATH);
		System.out.println(folder.getAbsoluteFile());
		File[] listOfFiles = folder.listFiles();
		int count = 1;
		ArrayList<String> files = new ArrayList<String>();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println(count + ") "+ listOfFiles[i].getName());
				files.add(listOfFiles[i].getName());
				count++;
			} 
		}
		System.out.println(count + ") Quit");
		if (files.size()==0){
			System.out.println("There are no documents to load");
			return null;
		}
		int choice = InputHandler.getInt("", 1, count);
		if (choice==count) return null;
		try(
			InputStream file = new FileInputStream(SAVE_PATH + files.get(choice-1));
			InputStream buffer = new BufferedInputStream(file);
			ObjectInput input = new ObjectInputStream (buffer);
		){
			Document document = (Document)input.readObject();
			return document;
		} catch (Exception e){
			System.out.println("That is not a valid Document. ");
		}
		return null;
	}
}
