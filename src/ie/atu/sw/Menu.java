package ie.atu.sw;

import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.Executors;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author G00411386
 * @version 1.0
 * @since 1.9
 * 
 *        Class Menu is uses in class CreateIndex, FilePhraser,
 *        RemoveDictionary, RemoveWords
 */

public class Menu {

	private Scanner s;
	// Boolean used to toggle the application off/on
	private boolean keepRunning = true;
	// Stores the inputed text file directory
	private String filePath;
	// Stores the inputed text for the CSV file directory
	private String savedPath;
	// Stores indexed word and the index word page
	private Map<String, List<Integer>> indexedWords = new LinkedHashMap<>();
	// Stores indexed word and its dictionary definition
	private Map<String, List<String>> dictionaryWords = new LinkedHashMap<>();

	/**
	 * 
	 * 
	 */

	public Menu() {
		s = new Scanner(System.in);
	}

	/**
	 * Executes method showOptions where the end user can input option 1-6. Option 1
	 * executes getTextFile. Option 2 executes removeWords. Option 3 executes
	 * getDictionary. Option 4 executes getSaveDirtory. Option 5 executes
	 * executeFile. Option 6 exits the menu.
	 * 
	 * @throws Exception
	 */
	public void start() throws Exception {

		// Keep application running when variable keepRunning is equal to true. The
		// application will be terminated when keepRunning is toggled to false. Option 6
		// of the application menu changes keepRunning from true to false.

		while (keepRunning) {
			showOptions();
			// Block and wait for users input
			int choice = Integer.parseInt(s.next());

			if (choice == 1) {
				// Execute method getTextFile
				getTextFile();

			} else if (choice == 2) {
				// Execute method removeWords
				removeWords();

			} else if (choice == 3) {
				// Execute method getDictionary
				getDictionary();

			} else if (choice == 4) {
				// Execute method Execute
				getSaveDirtory();

			} else if (choice == 5) {
				// Execute method executeFile
				executeFile();

			} else if (choice == 6) {
				System.out.println("Shutting down application..");
				keepRunning = false;
			}

			else {
				// Prints Invalid input if an input other than 1-5 is inputted by the user
				System.out.println("Invalid input");
			}

		}
	}

	/**
	 * The inputed file location is inputed in method setIndexedMap. Method
	 * getIndexedMap stores the LinkedHashMap with the indexed words and index page
	 * number to indexedWords
	 * 
	 * @throws Exception
	 */
	public void getTextFile() throws Exception {

		System.out.println("Specify Text File Directorys");
		filePath = s.next();
		System.out.println("Retreiving the text file......");
		FilePhraser fP = new FilePhraser();
		fP.setIndexedMap(filePath);
		indexedWords = fP.getIndexedMap();

	}

	/**
	 * Method setRemovedIndexedWords uses parameter indexedWords. Method
	 * getRemovedIndexedWords stores the updated LinkedHashMap with the indexed
	 * words and index page number to indexedWords with the removed google-1000.txt
	 * words.
	 * 
	 * @throws Exception
	 */

	public void removeWords() throws Exception {
		System.out.println("Removing 1000 common words......");
		RemoveWords rW = new RemoveWords();
		rW.setRemovedIndexedWords(indexedWords);
		indexedWords = rW.getRemovedIndexedWords();
		System.out.println("Removed 1000 common words");

	}

	/**
	 * Method setDictionaryIndex uses parameter indexedWords. Method
	 * getDictionaryIndex stores the updated LinkedHashMap with the indexed words
	 * and definitions to dictionaryWords.
	 * 
	 * @throws Exception
	 */
	public void getDictionary() throws Exception {

		System.out.println("Adding dictionary definitions to indexed words ......");
		RemoveDictionary rD = new RemoveDictionary();
		rD.setDictionaryIndex(indexedWords);
		dictionaryWords = rD.getDictionaryIndex();
		System.out.println("Added dictionary definitions to indexed words");

	}

	/**
	 * Stores the inputed location for indexOutputG00411386.csv to savedPath
	 * dictionaryWords.
	 */

	public void getSaveDirtory() throws Exception {
		System.out.println("Specify Output File Location for file indexOutputG00411386.csv to be saved");
		System.out.println(
				"An input of './exampleFolder' will output indexOutputG00411386.csv to  ./exampleFolder/indexOutputG00411386.csv");
		savedPath = s.next();

	}

	/**
	 * Executes method compileIndex that take in parameter indexedWords,
	 * dictionaryWords, savedPath and outputs indexOutputG00411386.csv
	 * 
	 * @throws Exception
	 */
	public void executeFile() throws Exception {
		CreateIndex cI = new CreateIndex();
		cI.compileIndex(indexedWords, dictionaryWords, savedPath);
		System.out.println("Building Index. Please wait while it gets build in location " + savedPath
				+ "/indexOutputG00411386.csv");

	}

	/**
	 * Executes the Menu UI
	 * 
	 */
	private void showOptions() {

		System.out.println("************************************************************");
		System.out.println("*       ATU - Dept. Computer Science & Applied Physics     *");
		System.out.println("*                                                          *");
		System.out.println("*              Virtual Threaded Text Indexer               *");
		System.out.println("*                                                          *");
		System.out.println("************************************************************");
		System.out.println("(1) Specify Text File");
		System.out.println("(2) Configure Common Words");
		System.out.println("(3) Configure Dictionary");
		System.out.println("(4) Specify Output File");
		System.out.println("(5) Execute");
		System.out.println("(6) Quit");

		System.out.print("Select Option [1-5]>");
		System.out.println();

	}

}
