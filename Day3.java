import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize BufferedReader for fast I/O
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read the total number of problems
        int n = Integer.parseInt(br.readLine().trim());
        
        // Counter for the number of problems they will implement
        int implementedCount = 0;
        
        for (int i = 0; i < n; i++) {
            // StringTokenizer is highly optimized for splitting strings by whitespace
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            // Parse the votes for the current problem
            int petya = Integer.parseInt(st.nextToken());
            int vasya = Integer.parseInt(st.nextToken());
            int tonya = Integer.parseInt(st.nextToken());
            
            // If the sum of their votes is at least 2, increment the count
            if (petya + vasya + tonya >= 2) {
                implementedCount++;
            }
        }
        
        // Output the final tally
        System.out.println(implementedCount);
    }
}