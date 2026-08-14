import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize BufferedReader for rapid input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read the username string
        String username = br.readLine();
        
        // Boolean array to track the 26 lowercase English letters
        boolean[] seen = new boolean[26];
        int distinctCount = 0;
        
        // Iterate through the username character by character
        for (int i = 0; i < username.length(); i++) {
            // Calculate the 0-25 index for the current character
            int charIndex = username.charAt(i) - 'a';
            
            // If the character hasn't been encountered yet
            if (!seen[charIndex]) {
                seen[charIndex] = true; // Mark as seen
                distinctCount++;        // Increment the unique counter
            }
        }
        
        // Evaluate the parity of the distinct character count
        if (distinctCount % 2 == 0) {
            System.out.println("CHAT WITH HER!");
        } else {
            System.out.println("IGNORE HIM!");
        }
    }
}