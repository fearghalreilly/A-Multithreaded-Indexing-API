package ie.atu.sw;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * @author G00411386
 * @version 1.0
 * @since 1.9
 * 
 *        Class RemoveDictionary is used in class Menu.
 *
 */

public class RemoveDictionary {
	//Stores the indexed word and word definition into a linkedhashmap  
	private Map<String, List<String>> foundWord = new LinkedHashMap<>();

	/**
	 * Compares the indexed words from the LinkedHashMap that stores the indexed
	 * words and index page numbers to the words in dictionary.csv. If the index
	 * word appears in the dictionary.csv then add the word and definition to a new
	 * LinkedHashMap.
	 * 
	 * @param addDictionaryMap a LinkedHashMap that contains an index word and the
	 *                         index word page number
	 * @throws FileNotFoundException
	 */

	// O(N) The time complexity depends on the amount of words in the inputed 
	public void setDictionaryIndex(Map<String, List<Integer>> addDictionaryMap) throws FileNotFoundException {

		// Variable dictionaryFile store the dictionary.csv file
		File dictionaryFile = new File("./dictionary.csv");
		// Variable scanDictFile stores the dictionary.csv file to a Scanner
		Scanner scanDictFile = new Scanner(dictionaryFile);

		// When there is another line to scan from the dictiionary.csv file that was
		// saved to variable dictionaryFile do the following:
		while (scanDictFile.hasNextLine()) {
			// Go through each line of the file, modify everything to lowercase and save it
			// to String data
			String data = scanDictFile.nextLine().toLowerCase();
			// Spilt the data variable into chunks and save it to a String Array details
			String details[] = data.split(",");
			// Loop through each word from the addDictionaryMap keySet and do the following:
			for (String word : addDictionaryMap.keySet()) { //O(N)

				// If the word from addDictionaryMap keySet is equal to the first index of
				// String Array details
				if ((word).equals(details[0])) { 

					// Current line of the dictionary
					String detail = data + "\n";

					// If map foundWord doesn't containsKey word:
					if (!foundWord.containsKey(word)) {
						// Create String ArrayList called list for each word
						List<String> list = new ArrayList<>();

						// Add the word and defintion to foundWord
						foundWord.put(word, list);
						foundWord.get(word).add(detail);

						// If the word meaning appears more than once skip this block
					} else if (!foundWord.get(word).contains(detail)) {
						foundWord.get(word).add(detail);

					}

				}

			}

		}

	}

	/**
	 * Gets the LinkedHashMap with indexed words and its definitions
	 * 
	 * @return
	 */

	// O(N) The time complexity depends on size of the map
	public Map<String, List<String>> getDictionaryIndex() {
		// Gets map foundWord with the indexed words and definitions
		return this.foundWord;
	}

}