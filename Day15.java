// import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize BufferedReader for rapid I/O operations
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read the HQ9+ program string
        String p = br.readLine();
        
        // Iterate through each character of the string
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            
            // Check strictly for the instructions that produce visible output
            if (c == 'H' || c == 'Q' || c == '9') {
                System.out.println("YES");
                return; // Exit the program immediately as output is guaranteed
            }
        }
        
        // If the loop finishes without returning, no output instructions were found
        System.out.println("NO");
    }
}