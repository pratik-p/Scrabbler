import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

class Scrabbler {
    private final HashSet<String> dictionary = new HashSet<>();
    private final Trie prefixTree = new Trie();
    private final Trie suffixTree = new Trie();
    private final Scanner input;
    private TreeSet<String> printList = new TreeSet<>();

    /**
     * Main constructor
     *
     * @param input scanner input from driver
     */
    Scrabbler(Scanner input) {
        this.input = input;
    }

    /**
     * Start method
     */
    void start() {
        System.out.print("Please enter a string of letters, or start your search with \"--prefix\"/\"--suffix\" " +
                "followed by letters. \nEnter \"Ctrl + c\" or \"/quit\" to exit: ");
        boolean run = true;

        makeDictionary();

        try {
            while (run) {
                String textInput = input.nextLine().toLowerCase();
                String[] argument = textInput.split(" ");
                if (!argument[0].equals("/quit")) {
                    printOutput(argument);
                    System.out.print("Please enter a string of letters, or start your search with " +
                            "\"--prefix\"/\"--suffix\" followed by letters. \nEnter \"Ctrl + c\" or \"/quit\" to " +
                            "exit: ");
                    printList = new TreeSet<>();
                } else {
                    run = false;
                    System.out.println("Quit.");
                    input.close();
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("\nQuit.");
            input.close();
        }
    }

    /**
     * Make Dictionary prefix and suffix Trees
     */
    private void makeDictionary() {
        try {
            String filePath = new File("").getAbsolutePath();
            Scanner fileInput = new Scanner(new FileReader(filePath + "/words.txt"));
            while (fileInput.hasNextLine()) {
                String word = fileInput.nextLine();
                if (!word.equals("")) {
                    // build all data structures only once
                    prefixTree.insert(word);
                    dictionary.add(word);
                    StringBuilder s = new StringBuilder(word);
                    suffixTree.insert(s.reverse().toString());
                }
            }
            fileInput.close();
        } catch (FileNotFoundException e) {
            System.out.println("\nMissing file: \"words.txt\"");
            e.printStackTrace();
        }
    }

    /**
     * Prints words that are found in dictionary
     *
     * @param argument string to be checked
     */
    private void printOutput(String[] argument) {
        if (argument.length > 1 && argument[0].equals("--prefix")) {
            prefix(argument[1]);
        } else if (argument.length > 1 && argument[0].equals("--suffix")) {
            // reverse the argument
            StringBuilder s = new StringBuilder(argument[1]);
            suffix(s.reverse().toString());
        } else if (!argument[0].isEmpty()) {
            checkString(argument[0]);
            if (printList.isEmpty()) {
                // if only vowels are entered
                System.out.println("No words found for letters: " + argument[0]);
            } else {
                for (String words : printList) {
                    System.out.println(words);
                }
            }
        } else {
            System.out.println("You entered an empty string!");
        }
    }

    /**
     * Calls checkString method with empty string
     *
     * @param str string to be checked in dictionary
     */
    private void checkString(String str) {
        checkString("", str);
    }

    /**
     * Adds each string combination found in dictionary
     *
     * @param prefix previous string
     * @param str    remaining string
     */
    private void checkString(String prefix, String str) {
        if (dictionary.contains(prefix)) {
            // add to new set to avoid duplicates
            printList.add(prefix);
        }
        for (int i = 0; i < str.length(); i++) {
            checkString(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, str.length()));
        }
    }

    /**
     * Checks if words with prefix are in dictionary
     *
     * @param condition prefix condition
     */
    private void prefix(String condition) {
        if (prefixTree.startsWith(condition)) {
            TrieNode tn = prefixTree.searchNode(condition);
            prefixTree.wordsFinderTraversal(tn, 0);
            prefixTree.displayFoundWordsPrefix();
        } else {
            System.out.println("No words found for letters with prefix: " + condition);
        }
    }

    /**
     * Checks if words with suffix are in dictionary
     *
     * @param condition suffix condition
     */
    private void suffix(String condition) {
        if (suffixTree.startsWith(condition)) {
            TrieNode tn = suffixTree.searchNode(condition);
            suffixTree.wordsFinderTraversal(tn, 0);
            suffixTree.displayFoundWordsSuffix();
        } else {
            System.out.println("No words found for letters with suffix: " + condition);
        }
    }
}