import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FindingAMotifInDNA {
    public static void main(String[] args) {
        String filename = "src/rosalind_subs.txt";
        // Load DNA strings from file (line 1 is the DNA string, line 2 is the motif).
        String s = loadDNAStringFromFile(filename, 1);
        String t = loadDNAStringFromFile(filename, 2);
        // Find the motif in the DNA string and print the locations
        System.out.println(findMotif(s, t)); // 6 21 69 85 128 152 183 190 241 267 274 292 314 321 335 347 372 379 424 470 485 580 603 641 648 659 693 709 733 812 819 876 896 903 910 946
    }

    /**
     * Prints the indexes of all occurrences of a substring in a string
     *
     * @param s the DNA string to search for the motif in
     * @param t the motif to search for in the DNA string
     * @return the locations of the motif in the DNA string
     */
    public static String findMotif(String s, String t) {
        // Create a string to store the indexes of the occurrences of t in s. Sidenote: StringBuilder is faster than string (concatenation).
        StringBuilder result = new StringBuilder();
        // Loop through the string s.
        for (int i = 0; i < s.length(); i++) {
            // Check if the substring of s starting at index i is equal to t.
            if (s.substring(i).startsWith(t)) {
                // If it is, add the index to the result string.
                result.append(i + 1).append(" ");
            }
        }
        // Return the result string.
        return result.toString();
    }

    /**
     * Loads a DNA string from a file based on the line number.
     *
     * @param fileName         the name of the file to load the DNA string from
     * @param lineNumberToLoad the line number of the file to load the DNA string from (Starts at 1)
     * @return the DNA string loaded from the file
     */
    public static String loadDNAStringFromFile(String fileName, int lineNumberToLoad) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // Read the file line by line
            for (int i = 0; i < lineNumberToLoad; i++) {
                line = br.readLine();
                // If the line number is reached, return the line
                if (i == lineNumberToLoad - 1) {
                    return line;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
