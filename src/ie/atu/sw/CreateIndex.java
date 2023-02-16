package ie.atu.sw;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author G00411386
 * @version 1.0
 * @since 1.9
 * 
 *        Class CreateIndex is used in class Menu.
 * 
 *
 */
public class CreateIndex {

	/**
	 * It creates a indexOutputG00411386.csv with the word, word definition and the
	 * page index the word appears in alphabetical order. Outputs the most frequent and least frequent
	 * indexed word per page basis to the console.
	 * 
	 * @param indexedMap       LinkedHashMap that stores the indexed words and index
	 *                         page number
	 * @param addDictionaryMap LinkedHashMap that stores the indexed word and
	 *                         definitions
	 * @param savedIndex       the inputed file location for
	 *                         indexOutputG00411386.csv to be created
	 */

	// O(N) The for loop time complexity depends on the amounts of keyset words from
	// dictionary.csv
	public static void compileIndex(Map<String, List<Integer>> indexedMap, Map<String, List<String>> addDictionaryMap,
			String savedIndex) {
		try {
			// File Output
			// Creates a Bufferdwriter object. Then writes the output to the file output
			// directory that was inputted by the user. The outputted file will
			// be in CSV format titled index.csv.

			BufferedWriter index = new BufferedWriter(new FileWriter(savedIndex + "/indexOutputG00411386.csv"));
			// Creates a headings in the index file
			index.write("Word,Details\n\n");

			// Loops through all the addDictionaryMap map keys.
			for (String wordTxt : addDictionaryMap.keySet()) { // O(N)

				// If the indexedMap keySet contains a keySet from addDictionaryMap write the
				// indexed word, definition and page index to the index.csv file
				if (indexedMap.containsKey(wordTxt)) {

					index.write(wordTxt + "  ,Definitions:\n," + addDictionaryMap.get(wordTxt) + ", \n,Pages:"
							+ indexedMap.get(wordTxt) + "\n\n");
				} else {
					// Remove, if the indexedMap keySet does not contain a keySet from
					// addDictionaryMap
					indexedMap.remove(index);

				}
			}

			// Outputs the most frequent indexed word per page basis to the console
			// https://stackoverflow.com/questions/18065738/best-way-to-find-the-largest-value-in-a-hashmaparraylist-arraylist
			String maxKey = null;
			int maxLen = 0;

			for (Entry<String, List<Integer>> e : indexedMap.entrySet()) { // O(N)
				int len = e.getValue().size();

				if (maxKey == null || len > maxLen) {
					maxKey = e.getKey();
					maxLen = len;
				}
			}

			System.out.println("Indexed word " + maxKey + "is the most indexed word per page. It appears on " + maxLen
					+ " total pages.");
			// Outputs the least frequent indexed word per page basis to the console
			// https://stackoverflow.com/questions/18065738/best-way-to-find-the-largest-value-in-a-hashmaparraylist-arraylist

			String minKey = null;
			int minLen = 0;

			for (Entry<String, List<Integer>> e : indexedMap.entrySet()) { // O(N)
				int len = e.getValue().size();

				if (minKey == null || len < minLen) {
					minKey = e.getKey();
					minLen = len;
				}
			}

			System.out.println("Indexed word " + minKey + "is the least indexed word per page. It appears on " + minLen
					+ " total pages.");

			// Close writer
			index.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
