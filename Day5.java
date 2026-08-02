import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize BufferedReader for rapid input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read the number of statements
        int n = Integer.parseInt(br.readLine().trim());
        
        // Initialize the Bit++ variable
        int x = 0;
        
        for (int i = 0; i < n; i++) {
            String statement = br.readLine();
            
            // Optimal check: The middle character always defines the operation.
            // If it's a '+', we increment. Otherwise, we decrement.
            if (statement.charAt(1) == '+') {
                x++;
            } else {
                x--;
            }
        }
        
        // Print the final calculated value of x
        System.out.println(x);
    }
}