// A. Translation
// time limit per test1 second
// memory limit per test256 megabytes
// The translation from the Berland language into the Birland language is not an easy task. Those languages are very similar: a Berlandish word differs from a Birlandish word with the same meaning a little: it is spelled (and pronounced) reversely. For example, a Berlandish word code corresponds to a Birlandish word edoc. However, making a mistake during the "translation" is easy. Vasya translated the word s from Berlandish into Birlandish as t. Help him: find out if he translated the word correctly.

// Input
// The first line contains word s, the second line contains word t. The words consist of lowercase Latin letters. The input data do not contain unnecessary spaces. The words are not empty and their lengths do not exceed 100 symbols.

// Output
// If the word t is a word s, written reversely, print YES, otherwise print NO.

// Examples
// InputCopy
// code
// edoc
// OutputCopy
// YES
// InputCopy
// abb
// aba
// OutputCopy
// NO
// InputCopy
// code
// code
// OutputCopy
// NO

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize BufferedReader for rapid I/O operations
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read both strings
        String s = br.readLine();
        String t = br.readLine();
        
        // Condition 1: If lengths don't match, they can't be reverses
        if (s.length() != t.length()) {
            System.out.println("NO");
            return;
        }
        
        int len = s.length();
        
        // Condition 2: Check characters against their mirrored index
        for (int i = 0; i < len; i++) {
            // Compare character starting from left of 's' 
            // with character starting from right of 't'
            if (s.charAt(i) != t.charAt(len - 1 - i)) {
                System.out.println("NO");
                return; // Early exit on first mismatch
            }
        }
        
        // If the loop finishes entirely, the strings are perfect reverses
        System.out.println("YES");
    }
}