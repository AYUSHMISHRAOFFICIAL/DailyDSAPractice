// A. Way Too Long Words
// time limit per test1 second
// memory limit per test256 megabytes
// Sometimes some words like "localization" or "internationalization" are so long that writing them many times in one text is quite tiresome.

// Let's consider a word too long, if its length is strictly more than 10 characters. All too long words should be replaced with a special abbreviation.

// This abbreviation is made like this: we write down the first and the last letter of a word and between them we write the number of letters between the first and the last letters. That number is in decimal system and doesn't contain any leading zeroes.

// Thus, "localization" will be spelt as "l10n", and "internationalization» will be spelt as "i18n".

// You are suggested to automatize the process of changing the words with abbreviations. At that all too long words should be replaced by the abbreviation and the words that are not too long should not undergo any changes.

// Input
// The first line contains an integer n (1 ≤ n ≤ 100). Each of the following n lines contains one word. All the words consist of lowercase Latin letters and possess the lengths of from 1 to 100 characters.

// Output
// Print n lines. The i-th line should contain the result of replacing of the i-th word from the input data.

// Examples
// InputCopy
// 4
// word
// localization
// internationalization
// pneumonoultramicroscopicsilicovolcanoconiosis
// OutputCopy
// word
// l10n
// i18n
// p43s







import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader is significantly faster than Scanner for I/O operations
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read the number of test cases
        int n = Integer.parseInt(br.readLine());
        
        // StringBuilder buffers the output to avoid expensive multiple print calls
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            int len = word.length();
            
            // Check if the word is "too long"
            if (len > 10) {
                // Construct the abbreviation: first char + (length - 2) + last char
                sb.append(word.charAt(0))
                  .append(len - 2)
                  .append(word.charAt(len - 1))
                  .append("\n");
            } else {
                // Append the original word
                sb.append(word).append("\n");
            }
        }
        
        // Print the entirely constructed string buffer at once
        System.out.print(sb.toString());
    }
}