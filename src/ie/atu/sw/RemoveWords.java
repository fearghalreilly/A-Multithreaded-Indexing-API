package ie.atu.sw;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import java.nio.file.Paths;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author G00411386
 * @version 1.0
 * @since 1.9
 * 
 *        Class RemoveWords is used in class Menu.
 *
 */

public class RemoveWords {

	//Stores the indexed word and index page number
	private Map<String, List<Integer>> removedIndexedWords = new LinkedHashMap<>();

	/**
	 * Removes the list of words in google-1000.txt from passed in LinkedHashMap
	 * that stores the indexed words and index page numbers.
	 * 
	 * @param phrasedWords a LinkedHashMap that contains the indexed word and
	 *                     indexed page number
	 * @throws IOException
	 */
	// O(N) The time complexity depends on the amount of words in the inputed 
	public void setRemovedIndexedWords(Map<String, List<Integer>> phrasedWords) throws IOException {

		// Copies the LinkedHashMap that contains the indexed words and indexed page
		// numbers to removedIndexedWords
		Map<String, List<Integer>> removedIndexedWords = new LinkedHashMap<>(phrasedWords);

		// Input the words from google-1000.txt into a List String removedWordKeys
		List<String> removedWordKeys = Files.readAllLines(Paths.get("./google-1000.txt"));

		// Loop through all the removedWordKeys and remove a word if it appears a keySet
		// in removedWordsMap 
		for (String word : removedWordKeys) { //O(N)
			phrasedWords.remove(word);
		}

		// The contents of map removedIndexedWords to equal to map phrasedWords
		this.removedIndexedWords = phrasedWords;

	}

	/**
	 * Gets the LinkedHashMap without the removed indexed words
	 * 
	 * @return a LinkedHashMap with the indexed words, indexed page numbers without
	 *         the google-1000.txt words
	 */
	// O(N) The time complexity depends on size of the map
	public Map<String, List<Integer>> getRemovedIndexedWords() {
		// Gets map removedIndexedWords with the indexed words, indexed page numbers
		// without the google-1000.txt words
		return this.removedIndexedWords;

	}

}
