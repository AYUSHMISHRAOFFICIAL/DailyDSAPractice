import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // Fast I/O
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int t = Integer.parseInt(st.nextToken());
        StringBuilder out = new StringBuilder();
        
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            
            List<Integer> roundNumbers = new ArrayList<>();
            int multiplier = 1;
            
            // Extract each digit from right to left
            while (n > 0) {
                int digit = n % 10;
                if (digit != 0) {
                    // Multiply the non-zero digit by its positional value
                    roundNumbers.add(digit * multiplier);
                }
                n /= 10;
                multiplier *= 10;
            }
            
            // Append the count of round numbers
            out.append(roundNumbers.size()).append("\n");
            
            // Append the actual round numbers
            for (int num : roundNumbers) {
                out.append(num).append(" ");
            }
            out.append("\n");
        }
        
        // Print all output at once for efficiency
        System.out.print(out);
    }
}