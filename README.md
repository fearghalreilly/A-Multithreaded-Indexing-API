
A Multithreaded Indexing API

When the application is run on Runner.java, the user is given a prompt to select an option from 1-6.
Option 1 prompts the user to specify the text file directory. Option 2 removes google-1000.txt
words. Option 2 gets the dictionary definitions. Option 4 prompts the user to specify the output file
location for file indexOutputG00411386.csv to be saved. Option 5 creates the csv file and option 6
quits the application.

Features
setIndexedMap – Creates a LinkedHashMap with the indexed word and the index page number of
the user specified text file.

getIndexedMap – Gets a LinkedHashMap with the indexed word and the index page number of the
user specified text file.

setRemovedIndexedWords – Creates a LinkedHashMap of the indexed word and index page
numbers. Indexed words from google-1000.txt are removed.

getRemovedIndexedWords – Gets a LinkedHashMap of the indexed word and index page numbers.
Indexed words from google-1000.txt are removed.

setDictionaryIndex – Creates a LinkedHashMap of the indexed words and definitions from
dictionary.csv.

getDictionaryIndex – Gets a LinkedHashMap of the indexed word and definition from dictionary.csv.

compileIndex – Creates an alphabetical ordered index and outputs the minimum and maximum
indexed word.

showOptions – Menu Interface.

getTextfie – User prompted to enter the text file path when option 1 is selected. Method
setIndexMap and getIndexedMap is executed.

removeWords – User prompted that words from google-1000.txt are being removed from the index
when option 2 is selected. Method setRemovedIndexedWords and getRemovedIndexedWords is
executed.

getDictionary – Prompts that the dictionary definitions from dictionary.csv are being added when
option 3 is selected. Method setDictionaryIndex and getDictionaryIndex is executed.

getSaveDirtory - Prompts the user to specify the output file location for the index to be stored when
option 4 is selected.

exectuteFile - Prompts the user that the index application is being built when option 5 is selected.
Method compileIndex is executed.

start – Starts application.
