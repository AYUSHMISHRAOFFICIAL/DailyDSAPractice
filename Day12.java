/*A. String Task
time limit per test2 seconds
memory limit per test256 megabytes
Petya started to attend programming lessons. On the first lesson his task was to write a simple program. The program was supposed to do the following: in the given string, consisting if uppercase and lowercase Latin letters, it:
deletes all the vowels,
inserts a character "." before each consonant,
replaces all uppercase consonants with corresponding lowercase ones.
Vowels are letters "A", "O", "Y", "E", "U", "I", and the rest are consonants. The program's input is exactly one string, it should return the output as a single string, resulting after the program's processing the initial string.
Help Petya cope with this easy task.
Input

The first line represents input string of Petya's program. This string only consists of uppercase and lowercase Latin letters and its length is from 1 to 100, inclusive.
Output

Print the resulting string. It is guaranteed that this string is not empty.
Examples
InputCopy
tour
OutputCopy
.t.r
InputCopy
Codeforces
OutputCopy
.c.d.f.r.c.s
InputCopy
aBAcAba
OutputCopy
.b.c.b */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize BufferedReader for rapid input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read the string and immediately convert it to lowercase
        String s = br.readLine().toLowerCase();
        
        // StringBuilder to efficiently construct the final string
        StringBuilder sb = new StringBuilder();
        
        // Iterate through each character of the normalized string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // Check if the character is a vowel (including 'y')
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y') {
                // Skip vowels entirely
                continue;
            } else {
                // For consonants, append a dot followed by the character
                sb.append('.').append(c);
            }
        }
        
        // Output the fully processed string
        System.out.println(sb.toString());
    }
}