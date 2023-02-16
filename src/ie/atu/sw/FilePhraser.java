package ie.atu.sw;

import static java.lang.System.out;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Executors;

/**
 * @author G00411386
 * @version 1.0
 * @since 1.9
 * 
 *        Class FilePhraser is used in class Menu.
 *
 */

public class FilePhraser {

	public void filePraserVT(String filePath) throws Exception {
		try (var pool = Executors.newVirtualThreadPerTaskExecutor()) {

		}
	}

	private Map<String, List<Integer>> wordPages = new LinkedHashMap<>();

	/**
	 * Creates a LinkedHashMap with the indexed word and the index word page
	 * number.Uses the text file from the user inputed file location. Adds a page
	 * number to ever 40 lines. Adds the indexed word and its page index to
	 * LinkedHashMap.
	 * 
	 * @param textFileName is the inputted textfile location
	 * @throws FileNotFoundException
	 */

	// O(N) The time complexity depends on the amount of words in the inputed text
	// file dictionary.csv
	public void setIndexedMap(String textFileName) throws FileNotFoundException {
		// Int linCount is set to zero because before the first count the total line
		// is zero
		int lineCount = 0;
		// Int page number is 1 because its before the first 40 lines
		int page = 1;

		// Scanner inputTxtFile is used to scan the text file by using the full path
		// which uses the parameter textFileName
		Scanner inputTxtFile = new Scanner(new File(textFileName));

		// Loops through each line of the textfile that was used for inputTxtFile until
		// there is no more lines to read

		while (inputTxtFile.hasNextLine()) {
			// String data stores each line and converts it to lower case
			String data = inputTxtFile.nextLine().toLowerCase(); // The data variable stores current one line and make

			// Breaks the line into a word if any space is found and stores them in a String
			// array called words
			String words[] = data.split(" ");
			// Each word that is in the words array is used to search its page number and
			// where it occurs
			for (String word : words) {
				// ^[A-Za-z]{1,}$ is the regular expression of a word to avoid any special
				// characters and numbers
				// if a word from the words array matches do
				if (word.matches("^[A-Za-z]{1,}$")) { //O(N)
					// Int pagenumber is equal to Int page + lineCount / 40
					// i.e. a word in 66th line of the file, then the page number is
					// (1+66/40)=2.6, the integer form is only 2, so the page number is 2
					int pageNumber = ((int) (page + lineCount / 40));
					// if the word is not a key value in map wordPages this block is done
					if (!wordPages.containsKey(word)) {
						// Create an arrayList of Integers
						List<Integer> list = new ArrayList<>(); // We initialized individual page list for each word
						// Add the work and integer to the wordPages map
						wordPages.put(word, list);
						// Get the word for wordPages and add it to pageNumber
						wordPages.get(word).add(pageNumber);
						// It checks that if a word appears more than once, then the block is skipped
					} else if (!wordPages.get(word).contains(pageNumber)) {
						wordPages.get(word).add(pageNumber);
					}
				}

			}
			// Add 1 to current line iteration
			lineCount++;
		}

	}

	/**
	 * Gets the LinkedHashMap with indexed words and its index page number
	 * 
	 * @return
	 * @throws FileNotFoundException
	 */
	// O(N) The time complexity depends on size of the map
	public Map<String, List<Integer>> getIndexedMap() throws FileNotFoundException {
		// Gets map wordPages with the indexed words and index page number
		return this.wordPages;

	}

}
