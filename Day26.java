import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize BufferedReader for rapid input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read the single line containing n and k
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        // Perform Tanya's subtraction exactly k times
        for (int i = 0; i < k; i++) {
            // If the last digit is 0, divide by 10
            if (n % 10 == 0) {
                n /= 10;
            } else {
                // Otherwise, decrease by 1
                n--;
            }
        }
        
        // Output the final computed number
        System.out.println(n);
    }
}